package com.ruoyi.agent.feign;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 报表模块远程查询服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteReportQueryService", value = "ruoyi-report")
public interface RemoteReportQueryService
{
    @GetMapping("/config/list")
    TableDataInfo listConfig(@RequestParam Map<String, Object> params);

    @GetMapping("/config/{id}")
    AjaxResult getConfig(@PathVariable("id") Long id);

    @GetMapping("/config/custom/data")
    TableDataInfo getReportData(@RequestParam Map<String, Object> params);
}
