package com.ruoyi.report.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.report.domain.ReportConfig;
import com.ruoyi.report.domain.ReportQueryItem;
public interface ReportConfigMapper {
    ReportConfig selectReportConfigById(Long id);
    List<ReportConfig> selectReportConfigList(ReportConfig config);
    ReportConfig selectReportConfigByCode(String reportCode);
    int insertReportConfig(ReportConfig config);
    int updateReportConfig(ReportConfig config);
    int deleteReportConfigByIds(Long[] ids);
    List<Map<String, Object>> selectReportData(@Param("tableName") String tableName,
                                                @Param("items") List<ReportQueryItem> items,
                                                @Param("params") Map<String, Object> params);
}
