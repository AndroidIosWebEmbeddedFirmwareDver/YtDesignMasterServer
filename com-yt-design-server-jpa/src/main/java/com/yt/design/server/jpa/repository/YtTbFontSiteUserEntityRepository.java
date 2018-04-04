package com.yt.design.server.jpa.repository;

import com.yt.design.server.jpa.entity.YtTbFontSiteUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/

public interface YtTbFontSiteUserEntityRepository extends JpaRepository<YtTbFontSiteUserEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from LeMobileUserSmsEntity entity where entity.isDeleted=?1")
    public YtTbFontSiteUserEntity findALLByIsDeleted(int isDeleted);


}
