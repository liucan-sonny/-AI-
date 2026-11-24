package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.entity.Question;

public interface QuestionService extends IService<Question> {
    /**
     * 智能随机抽取题目（智能组卷核心）
     * @param categoryId 分类
     * @param type 题型
     * @param level 难度
     * @param num 抽取数量
     * @return
     */
    List<Question> getRandomQuestion(Long categoryId, Integer type, Integer level, Integer num);
}
