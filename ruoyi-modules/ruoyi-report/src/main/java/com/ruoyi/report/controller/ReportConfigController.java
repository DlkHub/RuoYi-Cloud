package com.ruoyi.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.MultiValueMap;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.report.domain.ReportConfig;
import com.ruoyi.report.domain.ReportQueryItem;
import com.ruoyi.report.service.IReportConfigService;
import com.ruoyi.report.service.IReportQueryItemService;

/**
 * 报表配置 CRUD 接口。
 */
@RestController
@RequestMapping("/config")
public class ReportConfigController extends BaseController {
    private static final Pattern IDENTIFIER = Pattern.compile("^[A-Za-z_][A-Za-z0-9_]*$");
    private static final List<String> QUERY_TYPES = List.of("eq", "like", "gt", "ge", "lt", "le", "between", "in");

    @Autowired
    private IReportConfigService service;
    @Autowired
    private IReportQueryItemService queryItemService;

    @RequiresPermissions("report:config:list")
    @GetMapping("/list")
    public TableDataInfo list(ReportConfig config) {
        startPage();
        List<ReportConfig> list = service.selectList(config);
        return getDataTable(list);
    }

    /** 按报表配置的数据表及查询条件动态查询，并返回 RuoYi 标准分页结果。 */
    @RequiresPermissions("report:config:data")
    @GetMapping("/custom/data")
    public TableDataInfo data(@RequestParam Long reportId, @RequestParam MultiValueMap<String, String> requestParams) {
        ReportConfig config = service.selectById(reportId);
        if (config == null) {
            throw new IllegalArgumentException("报表不存在或已删除");
        }
        if (!IDENTIFIER.matcher(config.getDataSource() == null ? "" : config.getDataSource()).matches()) {
            throw new IllegalArgumentException("报表数据表配置不合法");
        }
        ReportQueryItem query = new ReportQueryItem();
        query.setReportId(reportId);
        List<ReportQueryItem> items = queryItemService.selectList(query);
        Map<String, Object> params = buildQueryParams(items, requestParams);
        startPage();
        return getDataTable(service.selectReportData(config.getReportCode(), items, params));
    }

    private Map<String, Object> buildQueryParams(List<ReportQueryItem> items, MultiValueMap<String, String> requestParams) {
        Map<String, Object> params = new HashMap<>();
        for (ReportQueryItem item : items) {
            if (!IDENTIFIER.matcher(item.getFieldName()).matches() || !QUERY_TYPES.contains(item.getQueryType())) {
                throw new IllegalArgumentException("报表查询字段或查询方式配置不合法");
            }
            List<String> values = requestParams.get(item.getFieldName());
            if (values == null || values.stream().allMatch(value -> value == null || value.trim().isEmpty())) continue;
            List<String> nonEmptyValues = values.stream().filter(value -> value != null && !value.trim().isEmpty()).collect(java.util.stream.Collectors.toList());
            if ("between".equals(item.getQueryType()) || "in".equals(item.getQueryType())) {
                if (nonEmptyValues.size() == 1 && nonEmptyValues.get(0).contains(",")) nonEmptyValues = List.of(nonEmptyValues.get(0).split(","));
                if ("between".equals(item.getQueryType()) && nonEmptyValues.size() != 2) throw new IllegalArgumentException(item.getFieldLabel() + "需要提供两个查询值");
                params.put(item.getFieldName(), new ArrayList<>(nonEmptyValues));
            } else {
                params.put(item.getFieldName(), nonEmptyValues.get(0));
            }
        }
        return params;
    }

    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return success(service.selectById(id));
    }

    @RequiresPermissions("report:config:add")
    @Log(title = "报表配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ReportConfig config) {
        if (!service.checkCodeUnique(config)) return error("新增报表配置失败，报表编码已存在");
        config.setCreateBy(SecurityUtils.getUsername());
        return toAjax(service.insert(config));
    }

    @RequiresPermissions("report:config:edit")
    @Log(title = "报表配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ReportConfig config) {
        if (!service.checkCodeUnique(config)) return error("修改报表配置失败，报表编码已存在");
        config.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(service.update(config));
    }

    @RequiresPermissions("report:config:remove")
    @Log(title = "报表配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(service.deleteByIds(ids));
    }
}
