package com.ruoyi.report.domain;

import jakarta.validation.constraints.NotBlank;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 报表表格字段配置表 report_column_config。
 */
public class ReportColumnConfig extends BaseEntity {
    private Long id;
    private Long reportId;
    private String fieldName;
    private String fieldLabel;
    private String fieldType;
    private Integer width;
    private String align;
    private String formatter;
    private String dictType;
    private Integer sortable;
    private Integer visible;
    private String fixed;
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @NotBlank(message = "字段名不能为空")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @NotBlank(message = "字段标题不能为空")
    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getSortable() {
        return sortable;
    }

    public void setSortable(Integer sortable) {
        this.sortable = sortable;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
