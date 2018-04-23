package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteConfigFilesCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/
//商品信息表

public interface YtTbSiteConfigFilesCenterEntityRepository extends JpaRepository<YtTbSiteConfigFilesCenterEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSiteConfigFilesCenterEntity entity where entity.isDeleted=?1")
    public YtTbSiteConfigFilesCenterEntity findALLByIsDeleted(int isDeleted);

    @Query("Select entity from YtTbSiteConfigFilesCenterEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteConfigFilesCenterEntity findOneById(long id, int isDeleted);

    @Query("Select entity from YtTbSiteConfigFilesCenterEntity entity where entity.fileUid=?1 and entity.isDeleted=?2")
    public YtTbSiteConfigFilesCenterEntity findOneByFileUid(String fileUid, int isDeleted);


    @Query(value = "select count(*) from yt_tb_site_file_center datas where  datas.isDeleted=?1 ", nativeQuery = true)
    public int findSizeByIsDeleted(int isDeleted);
}
