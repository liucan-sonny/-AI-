CREATE DATABASE IF NOT EXISTS exam_system DEFAULT CHARACTER SET utf8mb4;
USE exam_system;

-- 题目表
CREATE TABLE t_question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(500) NOT NULL COMMENT '题干',
    type TINYINT NOT NULL COMMENT '1单选 2多选 3判断 4简答',
    level TINYINT NOT NULL COMMENT '1简单2中等3困难',
    options TEXT COMMENT '选项json',
    answer TEXT COMMENT '参考答案',
    score INT NOT NULL COMMENT '分值',
    category_id BIGINT,
    file_url VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 试卷表
CREATE TABLE t_paper(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paper_name VARCHAR(100),
    total_score INT,
    time_limit INT COMMENT '考试时长分钟',
    status TINYINT COMMENT '0未发布1已发布',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 学生答题记录表
CREATE TABLE t_answer_record(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paper_id BIGINT,
    question_id BIGINT,
    user_id BIGINT,
    user_answer TEXT,
    ai_score INT COMMENT 'AI判分',
    final_score INT COMMENT '教师复核最终分',
    submit_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
