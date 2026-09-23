package com.ruoyi.report.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.report.domain.ReportQueryItem;
import com.ruoyi.report.mapper.ReportQueryItemMapper;
import com.ruoyi.report.service.IReportQueryItemService;
@Service
public class ReportQueryItemServiceImpl implements IReportQueryItemService {
    @Autowired private ReportQueryItemMapper mapper;
    public ReportQueryItem selectById(Long id) { return mapper.selectReportQueryItemById(id); }
    public List<ReportQueryItem> selectList(ReportQueryItem item) { return mapper.selectReportQueryItemList(item); }
    public int insert(ReportQueryItem item) { return mapper.insertReportQueryItem(item); }
    public int update(ReportQueryItem item) { return mapper.updateReportQueryItem(item); }
    public int deleteByIds(Long[] ids) { return mapper.deleteReportQueryItemByIds(ids); }
}
