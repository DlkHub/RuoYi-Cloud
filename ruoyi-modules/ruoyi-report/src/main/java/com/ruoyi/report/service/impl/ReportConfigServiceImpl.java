package com.ruoyi.report.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.report.domain.ReportConfig;
import com.ruoyi.report.domain.ReportQueryItem;
import com.ruoyi.report.mapper.ReportConfigMapper;
import com.ruoyi.report.service.IReportConfigService;

@Service
public class ReportConfigServiceImpl implements IReportConfigService {
    @Autowired
    private ReportConfigMapper mapper;

    public ReportConfig selectById(Long id) {
        return mapper.selectReportConfigById(id);
    }

    public List<ReportConfig> selectList(ReportConfig config) {
        return mapper.selectReportConfigList(config);
    }

    public int insert(ReportConfig config) {
        return mapper.insertReportConfig(config);
    }

    public int update(ReportConfig config) {
        return mapper.updateReportConfig(config);
    }

    public int deleteByIds(Long[] ids) {
        return mapper.deleteReportConfigByIds(ids);
    }

    public List<Map<String, Object>> selectReportData(String tableName, List<ReportQueryItem> items, Map<String, Object> params) {
        return mapper.selectReportData(tableName, items, params);
    }

    public boolean checkCodeUnique(ReportConfig config) {
        ReportConfig existed = mapper.selectReportConfigByCode(config.getReportCode());
        return StringUtils.isNull(existed) || existed.getId().longValue() == (config.getId() == null ? -1L : config.getId().longValue()) ? UserConstants.UNIQUE : UserConstants.NOT_UNIQUE;
    }
}
