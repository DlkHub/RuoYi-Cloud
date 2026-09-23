package com.ruoyi.report.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.ruoyi.common.core.web.domain.BaseEntity;

/** 报表配置表 report_config。 */
public class ReportConfig extends BaseEntity
{
    private Long id;
    private String reportCode;
    private String reportName;
    private String description;
    private String dataSource;
    private String queryApi;
    private Integer status;
    private Integer sort;
    private Integer deleted;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    @NotBlank(message = "报表编码不能为空") @Size(max = 64, message = "报表编码不能超过64个字符")
    public String getReportCode() { return reportCode; }
    public void setReportCode(String reportCode) { this.reportCode = reportCode; }
    @NotBlank(message = "报表名称不能为空") @Size(max = 128, message = "报表名称不能超过128个字符")
    public String getReportName() { return reportName; }
    public void setReportName(String reportName) { this.reportName = reportName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDataSource() { return dataSource; }
    public void setDataSource(String dataSource) { this.dataSource = dataSource; }
    public String getQueryApi() { return queryApi; }
    public void setQueryApi(String queryApi) { this.queryApi = queryApi; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Integer getSort() { return sort; }
    public void setSort(Integer sort) { this.sort = sort; }
    public Integer getDeleted() { return deleted; }
    public void setDeleted(Integer deleted) { this.deleted = deleted; }
}
