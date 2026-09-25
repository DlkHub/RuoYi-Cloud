package com.ruoyi.agent.domain;

import jakarta.validation.constraints.NotBlank;

/**
 * AI 问答请求对象
 *
 * @author ruoyi
 */
public class AiQuestionRequest
{
    /** 用户提问内容 */
    @NotBlank(message = "提问内容不能为空")
    private String question;

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }
}
