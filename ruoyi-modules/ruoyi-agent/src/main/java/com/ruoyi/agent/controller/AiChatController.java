package com.ruoyi.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.agent.domain.AiAnswerResponse;
import com.ruoyi.agent.domain.AiQuestionRequest;
import com.ruoyi.agent.service.IAiChatService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;

/**
 * AI 问答控制器
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/ai")
public class AiChatController extends BaseController
{
    @Autowired
    private IAiChatService aiChatService;

    /**
     * AI 问答接口
     */
    @PostMapping("/ask")
    public AjaxResult ask(@Validated @RequestBody AiQuestionRequest request)
    {
        AiAnswerResponse response = aiChatService.ask(request);
        return success(response);
    }
}
