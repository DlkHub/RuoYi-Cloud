package com.ruoyi.agent.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agent.domain.AiAnswerResponse;
import com.ruoyi.agent.domain.AiQuestionRequest;
import com.ruoyi.agent.service.IAiChatService;
import com.ruoyi.common.core.utils.StringUtils;

/**
 * AI 问答服务实现
 * <p>
 * 基于 Spring AI 的 ChatClient + Tool Calling 机制。
 * 大模型根据用户问题自动选择并调用已注册的工具（system/report 查询），
 * 再基于工具返回的数据生成自然语言回答。
 *
 * @author ruoyi
 */
@Service
public class AiChatServiceImpl implements IAiChatService
{
    private static final Logger log = LoggerFactory.getLogger(AiChatServiceImpl.class);

    @Autowired
    private ChatClient chatClient;

    @Override
    public AiAnswerResponse ask(AiQuestionRequest request)
    {
        AiAnswerResponse response = new AiAnswerResponse();

        if (StringUtils.isEmpty(request.getQuestion()))
        {
            response.setAnswer("请输入您想查询的问题。");
            return response;
        }

        try
        {
            // 调用 ChatClient，大模型会自动进行 Tool Calling
            String answer = chatClient.prompt()
                    .user(request.getQuestion())
                    .call()
                    .content();

            response.setAnswer(answer);
        }
        catch (Exception e)
        {
            log.error("AI 问答调用失败，问题：{}", request.getQuestion(), e);
            response.setAnswer("AI 服务调用异常：" + e.getMessage() + "，请稍后重试。");
        }

        return response;
    }
}
