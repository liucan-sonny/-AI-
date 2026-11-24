package com.exam.service;

import com.exam.entity.AnswerRecord;

public interface AiJudgeService {
    /**
     * AI自动判分
     * @param userAnswer 用户答案
     * @param standardAnswer 标准答案
     * @param fullScore 满分
     * @return 得分
     */
    Integer judge(String userAnswer, String standardAnswer, Integer fullScore);
}
