package com.ruoyi.agent.domain;

/**
 * AI 问答响应对象
 *
 * @author ruoyi
 */
public class AiAnswerResponse
{
    /** 识别到的意图 */
    private String intent;

    /** 自然语言回答 */
    private String answer;

    public String getIntent()
    {
        return intent;
    }

    public void setIntent(String intent)
    {
        this.intent = intent;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
}
