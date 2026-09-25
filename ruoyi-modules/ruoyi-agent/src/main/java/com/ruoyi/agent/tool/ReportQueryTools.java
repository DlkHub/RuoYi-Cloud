package com.ruoyi.agent.tool;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.agent.feign.RemoteReportQueryService;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.alibaba.fastjson2.JSON;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

/**
 * 报表模块查询工具
 * <p>
 * 将 report 模块的报表配置查询与动态数据查询能力封装为 AI 可调用的 Tool。
 *
 * @author ruoyi
 */
@Component
public class ReportQueryTools
{
    @Autowired
    private RemoteReportQueryService reportQueryService;

    /**
     * 查询报表配置列表
     */
    @Tool(description = "查询所有报表配置列表，返回报表ID、编码、名称、数据源、状态等信息")
    public String listReportConfigs(
            @ToolParam(description = "页码，从1开始，默认1") int pageNum,
            @ToolParam(description = "每页条数，默认10") int pageSize)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        TableDataInfo data = reportQueryService.listConfig(params);
        return JSON.toJSONString(data);
    }

    /**
     * 根据报表ID查询报表数据
     */
    @Tool(description = "根据报表ID查询该报表的动态数据，返回报表的实际业务数据记录")
    public String getReportData(
            @ToolParam(description = "报表ID") Long reportId,
            @ToolParam(description = "页码，从1开始，默认1") int pageNum,
            @ToolParam(description = "每页条数，默认10") int pageSize)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("reportId", reportId);
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        TableDataInfo data = reportQueryService.getReportData(params);
        return JSON.toJSONString(data);
    }
}
