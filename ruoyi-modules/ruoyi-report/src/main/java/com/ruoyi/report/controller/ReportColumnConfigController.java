package com.ruoyi.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.report.domain.ReportColumnConfig;
import com.ruoyi.report.service.IReportColumnConfigService;

/**
 * 报表表格字段 CRUD 接口。
 */
@RestController
@RequestMapping("/columnConfig")
public class ReportColumnConfigController extends BaseController {
    @Autowired
    private IReportColumnConfigService service;

    @RequiresPermissions("report:columnConfig:list")
    @GetMapping("/list")
    public TableDataInfo list(ReportColumnConfig config) {
        startPage();
        List<ReportColumnConfig> list = service.selectList(config);
        return getDataTable(list);
    }

    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return success(service.selectById(id));
    }

    @RequiresPermissions("report:columnConfig:add")
    @Log(title = "报表表格字段", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ReportColumnConfig config) {
        return toAjax(service.insert(config));
    }

    @RequiresPermissions("report:columnConfig:edit")
    @Log(title = "报表表格字段", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ReportColumnConfig config) {
        return toAjax(service.update(config));
    }

    @RequiresPermissions("report:columnConfig:remove")
    @Log(title = "报表表格字段", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(service.deleteByIds(ids));
    }
}
