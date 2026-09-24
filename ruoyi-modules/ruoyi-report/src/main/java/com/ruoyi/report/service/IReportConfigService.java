package com.ruoyi.report.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.report.domain.ReportConfig;
import com.ruoyi.report.domain.ReportQueryItem;
import com.ruoyi.system.api.model.LoginUser;

public interface IReportConfigService {
    ReportConfig selectById(Long id);

    List<ReportConfig> selectList(ReportConfig config);

    int insert(ReportConfig config);

    int update(ReportConfig config);

    int deleteByIds(Long[] ids);

    boolean checkCodeUnique(ReportConfig config);

    List<Map<String, Object>> selectReportData(String tableName, List<ReportQueryItem> items, Map<String, Object> params);

    R<LoginUser> getUserService(String username,String source);
}
