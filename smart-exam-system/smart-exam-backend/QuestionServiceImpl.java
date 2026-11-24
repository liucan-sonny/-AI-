package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.Question;
import com.exam.mapper.QuestionMapper;
import com.exam.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public List<Question> getRandomQuestion(Long categoryId, Integer type, Integer level, Integer num) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Question::getCategoryId, categoryId)
                .eq(Question::getType, type)
                .eq(Question::getLevel, level);
        // mybatis-plus随机查询（mysql order by rand()）
        wrapper.last("ORDER BY RAND() LIMIT " + num);
        return list(wrapper);
    }
}
