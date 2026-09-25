package com.ruoyi.agent.feign;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 系统模块远程查询服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteSystemQueryService", value = ServiceNameConstants.SYSTEM_SERVICE)
public interface RemoteSystemQueryService
{
    @GetMapping("/user/list")
    TableDataInfo listUser(@RequestParam Map<String, Object> params);

    @GetMapping("/user/{userId}")
    AjaxResult getUser(@PathVariable("userId") Long userId);

    @GetMapping("/role/list")
    TableDataInfo listRole(@RequestParam Map<String, Object> params);

    @GetMapping("/dept/list")
    AjaxResult listDept(@RequestParam Map<String, Object> params);

    @GetMapping("/menu/list")
    AjaxResult listMenu(@RequestParam Map<String, Object> params);
}
