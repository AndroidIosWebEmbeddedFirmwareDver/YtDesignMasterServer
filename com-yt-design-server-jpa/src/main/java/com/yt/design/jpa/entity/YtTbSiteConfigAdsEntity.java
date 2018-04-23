package com.yt.design.jpa.entity;

import com.yt.design.exception.DataCheckCommonException;
import com.yt.design.jpa.entity.common.DbDataCommonDataEntityChecker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description 页面广告
 * @Author
 * @Create 2018-04-02 下午4:19
 **/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Transactional
@Table(name = "yt_tb_site_config_ads", schema = "yitaodesign", catalog = "")

public class YtTbSiteConfigAdsEntity implements DbDataCommonDataEntityChecker {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//采用数据库ID自增长的方式来自增主键字段，Oracle 不支持这种方式
    private long id;

    @Column(name = "modifiedDateTime")
    private Timestamp modifiedDateTime;//修改时间

    @Column(name = "createdDateTime")
    private Timestamp createdDateTime;//创建时间

    @Column(name = "isDeleted")
    private Integer isDeleted;//是否被删除/隐藏 1-删除 0-正常 -1-封印

    @Column(name = "adName")
    private String adName;//广告名称

    @Column(name = "adDesc")
    private String adDesc;//广告描述

    @Column(name = "adLinks")
    private String adLinks;//广告链接

    @Column(name = "adCoverUrl")
    private String adCoverUrl;//广告封面图URL


    /**
     * 新增
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForCreate() throws DataCheckCommonException {
        if (this.adName == null || this.adName.length() <= 0) {
            throw new DataCheckCommonException("广告名称不能为空");
        }
        if (this.adDesc == null || this.adDesc.length() <= 0) {
            throw new DataCheckCommonException("广告描述不能为空");
        }
        if (this.adLinks == null || this.adLinks.length() <= 0) {
            throw new DataCheckCommonException("广告跳转链接不能为空");
        }
        if (this.adCoverUrl == null || this.adCoverUrl.length() <= 0) {
            throw new DataCheckCommonException("广告封面图片不能为空");
        }

        this.isDeleted = 0;
        this.createdDateTime = new Timestamp(System.currentTimeMillis());
        this.modifiedDateTime = new Timestamp(System.currentTimeMillis());
        return true;
    }

    /**
     * 删除
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForDelete() throws DataCheckCommonException {

        if (this.id <= 0) {
            throw new DataCheckCommonException();
        }
        this.isDeleted = 1;
        this.modifiedDateTime = new Timestamp(System.currentTimeMillis());
        return true;
    }

    /**
     * 修改
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForUpdate() throws DataCheckCommonException {

        if (this.id <= 0) {
            throw new DataCheckCommonException();
        }
        this.isDeleted = 0;
        this.modifiedDateTime = new Timestamp(System.currentTimeMillis());
        return true;
    }

    /**
     * 查询一条
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForFindOne() throws DataCheckCommonException {

        if (this.id <= 0) {
            throw new DataCheckCommonException();
        }
        return true;
    }

    /**
     * 查询一堆
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForFind() throws DataCheckCommonException {
        return true;
    }


}