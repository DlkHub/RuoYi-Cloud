package com.ruoyi.agent.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.agent.tool.ReportQueryTools;
import com.ruoyi.agent.tool.SystemQueryTools;

/**
 * AI 对话配置
 * <p>
 * 基于 Spring AI 的 ChatClient 构建统一对话入口，
 * 并将 system / report 模块的查询工具注册为 Tool Calling。
 *
 * @author ruoyi
 */
@Configuration
public class ChatClientConfig
{
    /**
     * 系统提示词：定义 AI 助手的角色与行为约束
     */
    private static final String SYSTEM_PROMPT = """
            你是若依管理系统的智能数据助手，擅长通过调用工具查询系统模块和报表模块的数据。

            你的能力：
            1. 查询系统用户列表、用户详情、角色列表、部门列表、菜单列表
            2. 查询报表配置列表、根据报表ID查询报表数据

            行为规则：
            - 当用户的问题涉及数据查询时，必须调用对应的工具获取真实数据，不要编造数据。
            - 根据用户问题中的关键词和数字ID，选择最合适的工具及参数。
            - 如果用户问题中包含数字ID，优先使用按ID查询的工具。
            - 调用工具后，基于返回的JSON数据，用简洁的中文自然语言总结回答。
            - 如果工具返回的数据为空，如实告知用户暂无数据。
            - 如果无法理解用户问题或没有匹配的工具，礼貌地说明你目前支持的查询范围。
            """;

    @Bean
    public ChatClient chatClient(OpenAiChatModel chatModel,
                                 SystemQueryTools systemQueryTools,
                                 ReportQueryTools reportQueryTools)
    {
        return ChatClient.builder(chatModel)
                .defaultSystem(SYSTEM_PROMPT)
                .defaultTools(systemQueryTools, reportQueryTools)
                .build();
    }
}
