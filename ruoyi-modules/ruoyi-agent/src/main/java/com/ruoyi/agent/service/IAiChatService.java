package com.ruoyi.agent.service;

import com.ruoyi.agent.domain.AiAnswerResponse;
import com.ruoyi.agent.domain.AiQuestionRequest;

/**
 * AI 问答服务接口
 *
 * @author ruoyi
 */
public interface IAiChatService
{
    /**
     * 根据自然语言问题返回 AI 回答
     *
     * @param request 提问请求
     * @return AI 回答
     */
    AiAnswerResponse ask(AiQuestionRequest request);
}
