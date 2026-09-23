package com.ruoyi.report.service;
import java.util.List;
import com.ruoyi.report.domain.ReportQueryItem;
public interface IReportQueryItemService {
    ReportQueryItem selectById(Long id); List<ReportQueryItem> selectList(ReportQueryItem item);
    int insert(ReportQueryItem item); int update(ReportQueryItem item); int deleteByIds(Long[] ids);
}
