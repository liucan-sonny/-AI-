package com.exam.service.impl;

import com.exam.entity.Paper;
import com.exam.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {
    private final RedisTemplate<String,Object> redisTemplate;

    public Paper getPaperById(Long paperId){
        String key = "exam:paper:" + paperId;
        Object cache = redisTemplate.opsForValue().get(key);
        if(cache != null){
            return (Paper) cache;
        }
        // 查库
        Paper paper = this.getById(paperId);
        if(paper != null){
            redisTemplate.opsForValue().set(key, paper, 30, TimeUnit.MINUTES);
        }
        return paper;
    }
}
