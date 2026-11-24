package com.exam.service.impl;

import com.exam.service.AiJudgeService;
import org.springframework.stereotype.Service;

@Service
public class AiJudgeServiceImpl implements AiJudgeService {
    // 实训版本：模拟AI比对，正式可对接大模型API
    @Override
    public Integer judge(String userAnswer, String standardAnswer, Integer fullScore) {
        if(userAnswer == null || userAnswer.isBlank()){
            return 0;
        }
        // 简单关键词匹配模拟AI判卷，项目里可以替换成LLM http调用
        long matchCount = standardAnswer.chars()
                .filter(c -> userAnswer.contains(String.valueOf((char)c)))
                .count();
        double rate = Math.min(1.0, matchCount / (double)standardAnswer.length());
        return (int) Math.round(fullScore * rate);
    }
}
