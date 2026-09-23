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
import com.ruoyi.report.domain.ReportQueryItem;
import com.ruoyi.report.service.IReportQueryItemService;

/**
 * 报表查询条件 CRUD 接口。
 */
@RestController
@RequestMapping("/queryItem")
public class ReportQueryItemController extends BaseController {
    @Autowired
    private IReportQueryItemService service;

    @RequiresPermissions("report:queryItem:list")
    @GetMapping("/list")
    public TableDataInfo list(ReportQueryItem item) {
        startPage();
        List<ReportQueryItem> list = service.selectList(item);
        return getDataTable(list);
    }

    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return success(service.selectById(id));
    }

    @RequiresPermissions("report:queryItem:add")
    @Log(title = "报表查询条件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ReportQueryItem item) {
        return toAjax(service.insert(item));
    }

    @RequiresPermissions("report:queryItem:edit")
    @Log(title = "报表查询条件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ReportQueryItem item) {
        return toAjax(service.update(item));
    }

    @RequiresPermissions("report:queryItem:remove")
    @Log(title = "报表查询条件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(service.deleteByIds(ids));
    }
}
