package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
//表名与实体类名称不一致需要手动指定表名
@TableName("tb_student")
public class MybatisStudent implements Serializable {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer sex;

    @Getter
    @Setter
    private Integer age;

    @Getter
    @Setter
    private String grade;
}
