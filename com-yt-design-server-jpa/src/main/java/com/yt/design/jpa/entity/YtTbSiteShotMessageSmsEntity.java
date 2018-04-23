package com.yt.design.jpa.entity;

import com.yt.design.exception.DataCheckCommonException;
import com.yt.design.jpa.entity.common.DbDataCommonDataEntityChecker;
import com.yt.design.jpa.entity.common.DbDataCommonStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description 服务信息表
 * @Author
 * @Create 2018-04-02 下午4:19
 **/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Transactional
@Table(name = "yt_tb_site_sms_code", schema = "yitaodesign", catalog = "")

public class YtTbSiteShotMessageSmsEntity implements DbDataCommonDataEntityChecker {

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

    @Column(name = "smsCode")
    private String smsCode;//短信验证码

    @Column(name = "smsContent")
    private String smsContent;//短信全文内容

    @Column(name = "smsPhone")
    private String smsPhone;//短信接收对象

    @Column(name = "smsInvalidSecs")
    private Integer smsInvalidSecs;//短信失效时间(分钟)


    /**
     * 新增
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForCreate() throws DataCheckCommonException {
        if (this.smsCode == null || this.smsCode.length() <= 0) {
            throw new DataCheckCommonException("短信验证码不能为空");
        }
        if (this.smsContent == null || this.smsContent.length() <= 0) {
            throw new DataCheckCommonException("短信内容不能为空");
        }
        if (this.smsPhone == null || this.smsPhone.length() <= 0) {
            throw new DataCheckCommonException("短信接收手机不能为空");
        }

        this.isDeleted = 0;
        this.smsInvalidSecs = DbDataCommonStatusEntity.DB_SITESHORTMESSAGESMS_SMS_INVALID_TIME;
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