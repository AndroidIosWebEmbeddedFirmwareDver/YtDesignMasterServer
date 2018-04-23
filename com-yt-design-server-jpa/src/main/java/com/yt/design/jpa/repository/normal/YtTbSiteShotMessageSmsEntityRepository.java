package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteShotMessageSmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/
//商品信息表

public interface YtTbSiteShotMessageSmsEntityRepository extends JpaRepository<YtTbSiteShotMessageSmsEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSiteShotMessageSmsEntity entity where entity.isDeleted=?1")
    public YtTbSiteShotMessageSmsEntity findALLByIsDeleted(int isDeleted);

    @Query("Select entity from YtTbSiteShotMessageSmsEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteShotMessageSmsEntity findOneById(long id, int isDeleted);


    @Query("Select entity from YtTbSiteShotMessageSmsEntity entity where entity.isDeleted=?1")
    public List<YtTbSiteShotMessageSmsEntity> findAllByIsDeleted(int isDeleted);

    @Query(value = "select count(*) from yt_tb_site_sms_code datas where  datas.isDeleted=?1 ", nativeQuery = true)
    public int findSizeByIsDeleted(int isDeleted);
}
