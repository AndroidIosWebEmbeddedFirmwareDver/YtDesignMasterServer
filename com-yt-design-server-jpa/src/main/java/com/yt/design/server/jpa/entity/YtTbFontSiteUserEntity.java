package com.yt.design.server.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:19
 **/

@Data
//指定JPA注解，表示当前类是一个实体类
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
//指定JPA注解，指定绑定的表
@Table(name = "yt_tb_font_site_user", schema = "yitaodesign", catalog = "")
public class YtTbFontSiteUserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//采用数据库ID自增长的方式来自增主键字段，Oracle 不支持这种方式
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "modifiedDateTime")
    private Timestamp modifiedDateTime;

    @Column(name = "createdDateTime")
    private Timestamp createdDateTime;

    @Column(name = "isDeleted")
    private Integer isDeleted;



}