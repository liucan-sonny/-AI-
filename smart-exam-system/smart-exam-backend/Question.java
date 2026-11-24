package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_question")
public class Question {
    @TableId(type = IdType.AUTO)
    private Long id;
    // 题目标题
    private String title;
    // 题型：1单选 2多选 3判断 4简答
    private Integer type;
    // 难度 1简单 2中等 3困难
    private Integer level;
    // 选项json
    private String options;
    // 参考答案
    private String answer;
    // 分值
    private Integer score;
    // 分类id
    private Long categoryId;
    // 题目附件minio地址
    private String fileUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
