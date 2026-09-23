package com.ruoyi.report.mapper;
import java.util.List;
import com.ruoyi.report.domain.ReportQueryItem;
public interface ReportQueryItemMapper {
    ReportQueryItem selectReportQueryItemById(Long id);
    List<ReportQueryItem> selectReportQueryItemList(ReportQueryItem item);
    int insertReportQueryItem(ReportQueryItem item);
    int updateReportQueryItem(ReportQueryItem item);
    int deleteReportQueryItemByIds(Long[] ids);
}
