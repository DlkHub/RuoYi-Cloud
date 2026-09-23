package com.ruoyi.report.domain;

import jakarta.validation.constraints.NotBlank;
import com.ruoyi.common.core.web.domain.BaseEntity;

/** 报表查询条件配置表 report_query_item。 */
public class ReportQueryItem extends BaseEntity
{
    private Long id; private Long reportId; private String fieldName; private String fieldLabel;
    private String componentType; private String queryType; private String placeholder; private String defaultValue;
    private String optionSource; private String optionConfig; private Integer required; private Integer visible; private Integer sort;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Long getReportId() { return reportId; } public void setReportId(Long reportId) { this.reportId = reportId; }
    @NotBlank(message = "查询字段名不能为空") public String getFieldName() { return fieldName; } public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    @NotBlank(message = "显示名称不能为空") public String getFieldLabel() { return fieldLabel; } public void setFieldLabel(String fieldLabel) { this.fieldLabel = fieldLabel; }
    @NotBlank(message = "组件类型不能为空") public String getComponentType() { return componentType; } public void setComponentType(String componentType) { this.componentType = componentType; }
    public String getQueryType() { return queryType; } public void setQueryType(String queryType) { this.queryType = queryType; }
    public String getPlaceholder() { return placeholder; } public void setPlaceholder(String placeholder) { this.placeholder = placeholder; }
    public String getDefaultValue() { return defaultValue; } public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }
    public String getOptionSource() { return optionSource; } public void setOptionSource(String optionSource) { this.optionSource = optionSource; }
    public String getOptionConfig() { return optionConfig; } public void setOptionConfig(String optionConfig) { this.optionConfig = optionConfig; }
    public Integer getRequired() { return required; } public void setRequired(Integer required) { this.required = required; }
    public Integer getVisible() { return visible; } public void setVisible(Integer visible) { this.visible = visible; }
    public Integer getSort() { return sort; } public void setSort(Integer sort) { this.sort = sort; }
}
