package com.blaineli.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 暂时还没用
 */
@Getter
@Setter
public class UserBean implements Serializable {
    private Long id ;
    private String guid;
    private String name;
    private String age;
    private Date createTime;

}
