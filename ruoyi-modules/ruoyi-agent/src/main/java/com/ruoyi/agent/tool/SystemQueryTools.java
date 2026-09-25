package com.ruoyi.agent.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.agent.feign.RemoteSystemQueryService;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.alibaba.fastjson2.JSON;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

/**
 * 系统模块查询工具
 * <p>
 * 将 system 模块的用户、角色、部门、菜单查询能力封装为 AI 可调用的 Tool。
 * 大模型通过 Tool Calling 自动选择并调用这些方法。
 *
 * @author ruoyi
 */
@Component
public class SystemQueryTools
{
    @Autowired
    private RemoteSystemQueryService systemQueryService;

    /**
     * 查询系统用户列表
     */
    @Tool(description = "查询系统用户列表，支持分页，返回用户的账号、名称、部门、状态等信息")
    public String listUsers(
            @ToolParam(description = "页码，从1开始，默认1") int pageNum,
            @ToolParam(description = "每页条数，默认10") int pageSize)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        TableDataInfo data = systemQueryService.listUser(params);
        return JSON.toJSONString(data);
    }

    /**
     * 根据用户ID查询用户详细信息
     */
    @Tool(description = "根据用户ID查询用户的详细信息，包括账号、昵称、邮箱、手机号、状态等")
    public String getUserById(@ToolParam(description = "用户ID") Long userId)
    {
        AjaxResult result = systemQueryService.getUser(userId);
        return JSON.toJSONString(result);
    }

    /**
     * 查询系统角色列表
     */
    @Tool(description = "查询系统角色列表，支持分页，返回角色名称、权限字符、状态等信息")
    public String listRoles(
            @ToolParam(description = "页码，从1开始，默认1") int pageNum,
            @ToolParam(description = "每页条数，默认10") int pageSize)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        TableDataInfo data = systemQueryService.listRole(params);
        return JSON.toJSONString(data);
    }

    /**
     * 查询部门列表
     */
    @Tool(description = "查询系统所有部门列表，返回部门名称、负责人、排序、状态等信息")
    public String listDepts()
    {
        AjaxResult result = systemQueryService.listDept(new HashMap<>());
        return JSON.toJSONString(result);
    }

    /**
     * 查询菜单列表
     */
    @Tool(description = "查询系统菜单列表，返回菜单名称、类型、路由路径等信息")
    public String listMenus()
    {
        AjaxResult result = systemQueryService.listMenu(new HashMap<>());
        return JSON.toJSONString(result);
    }
}
