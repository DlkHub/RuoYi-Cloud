package com.ruoyi.report.service;

import java.util.List;

import com.ruoyi.report.domain.ReportColumnConfig;

public interface IReportColumnConfigService {
    ReportColumnConfig selectById(Long id);

    List<ReportColumnConfig> selectList(ReportColumnConfig config);

    int insert(ReportColumnConfig config);

    int update(ReportColumnConfig config);

    int deleteByIds(Long[] ids);
}
