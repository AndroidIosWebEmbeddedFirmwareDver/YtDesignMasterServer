package com.yt.design.jpa.entity;

import com.yt.design.exception.DataCheckCommonException;
import com.yt.design.jpa.entity.common.DbDataCommonDataEntityChecker;
import com.yt.design.jpa.utils.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description 文件中心表
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
@Table(name = "yt_tb_site_file_center", schema = "yitaodesign", catalog = "")
public class YtTbSiteConfigFilesCenterEntity implements DbDataCommonDataEntityChecker {


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

    @Column(name = "fileName")
    private String fileName;//文件完整名称

    @Column(name = "fileUid")
    private String fileUid;//文件唯一下载ID

    @Column(name = "fileLinks")
    private String fileLinks;//文件下载链接

    @Column(name = "filePaths")
    private String filePaths;//文件存放路径

    @Column(name = "fileFromIp")
    private String fileFromIp;//文件上传Ip


    /**
     * 新增
     *
     * @return 检测结果
     */
    @Override
    public boolean dataCheckForCreate() throws DataCheckCommonException {
        if (this.fileName == null || this.fileName.length() <= 0) {
            throw new DataCheckCommonException("文件完整名称不能为空");
        }
        if (this.fileLinks == null || this.fileLinks.length() <= 0) {
            throw new DataCheckCommonException("文件下载链接不能为空");
        }
        if (this.filePaths == null || this.filePaths.length() <= 0) {
            throw new DataCheckCommonException("文件存放路径不能为空");
        }
        this.isDeleted = 0;
        this.fileUid = this.fileName.substring(0, this.fileName.lastIndexOf("."));
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