package com.ruoyi.report.mapper;
import java.util.List;
import com.ruoyi.report.domain.ReportColumnConfig;
public interface ReportColumnConfigMapper {
    ReportColumnConfig selectReportColumnConfigById(Long id);
    List<ReportColumnConfig> selectReportColumnConfigList(ReportColumnConfig config);
    int insertReportColumnConfig(ReportColumnConfig config);
    int updateReportColumnConfig(ReportColumnConfig config);
    int deleteReportColumnConfigByIds(Long[] ids);
}
