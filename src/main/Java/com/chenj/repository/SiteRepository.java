package com.chenj.repository;

import com.chenj.model.WebSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by Administrator on 2016/10/17.
 */
@Repository
public interface SiteRepository extends JpaRepository<WebSiteEntity,Integer> {
}
