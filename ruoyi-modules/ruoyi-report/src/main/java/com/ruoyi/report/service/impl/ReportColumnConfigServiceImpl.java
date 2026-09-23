package com.ruoyi.report.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.report.domain.ReportColumnConfig;
import com.ruoyi.report.mapper.ReportColumnConfigMapper;
import com.ruoyi.report.service.IReportColumnConfigService;

@Service
public class ReportColumnConfigServiceImpl implements IReportColumnConfigService {
    @Autowired
    private ReportColumnConfigMapper mapper;

    public ReportColumnConfig selectById(Long id) {
        return mapper.selectReportColumnConfigById(id);
    }

    public List<ReportColumnConfig> selectList(ReportColumnConfig config) {
        return mapper.selectReportColumnConfigList(config);
    }

    public int insert(ReportColumnConfig config) {
        return mapper.insertReportColumnConfig(config);
    }

    public int update(ReportColumnConfig config) {
        return mapper.updateReportColumnConfig(config);
    }

    public int deleteByIds(Long[] ids) {
        return mapper.deleteReportColumnConfigByIds(ids);
    }
}
