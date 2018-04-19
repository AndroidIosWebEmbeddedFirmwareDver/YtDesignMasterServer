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
 * @Description 商品（作品）、服务、需求统一类型表
 * @Author
 * @Create 2018-04-02 下午4:19
 **/

//@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Transactional
@Table(name = "yt_tb_site_common_type", schema = "yitaodesign", catalog = "")
public class YtTbSiteCommonTypeEntity implements DbDataCommonDataEntityChecker {


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

    @Column(name = "name")
    private String name;

    @Column(name = "parentId")
    private long parentId;//父级id,默认0

    @Column(name = "level")
    private int level;//类型级别,1-一级，2-二级，默认1


    /**
     * 新增
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForCreate() throws DataCheckCommonException {
        if (this.name == null || this.name.length() <= 0) {
            throw new DataCheckCommonException();
        }
        if (level <= 0) {
            throw new DataCheckCommonException();
        }
        if (level == 2 && parentId <= 0) {
            throw new DataCheckCommonException();
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