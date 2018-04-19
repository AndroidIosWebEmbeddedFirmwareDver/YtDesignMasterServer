package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description 商品（作品）、服务、需求统一类型表
 * @Author
 * @Create 2018-04-02 下午4:22
 **/

public interface YtTbSiteCommonTypeEntityRepository extends JpaRepository<YtTbSiteCommonTypeEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSiteCommonTypeEntity entity where entity.isDeleted=?1")
    public YtTbSiteCommonTypeEntity findALLByIsDeleted(int isDeleted);


    @Query("Select entity from YtTbSiteCommonTypeEntity entity where entity.level=?1 and entity.isDeleted=?2")
    public List<YtTbSiteCommonTypeEntity> findAllByLevel(int level, int isDeleted);

    @Query("Select entity from YtTbSiteCommonTypeEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteCommonTypeEntity findOneById(long id, int isDeleted);

    @Query(value = "select count(*) from yt_tb_site_common_type datas where  datas.isDeleted=?1 and datas.level=?2", nativeQuery = true)
    public int findSizeByPagesAndIsDeletedAndLevel(int isDeleted, int level);

}
