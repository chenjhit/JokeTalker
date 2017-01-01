package com.chenj.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2016/10/15.
 */
@Entity
@Table(name = "joke", schema = "", catalog = "joke_talker")
public class JokeEntity {
    private int id;
    private String content;
    private String website;
    private String siteIndex;
    private Date createDate;
    private WebSiteEntity webSiteBySiteId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false, insertable = true, updatable = true, length = 45)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "website", nullable = true, insertable = true, updatable = true, length = 45)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "site_index", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSiteIndex() {
        return siteIndex;
    }

    public void setSiteIndex(String siteIndex) {
        this.siteIndex = siteIndex;
    }

    @Basic
    @Column(name = "create_date", nullable = false, insertable = true, updatable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JokeEntity that = (JokeEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (siteIndex != null ? !siteIndex.equals(that.siteIndex) : that.siteIndex != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (siteIndex != null ? siteIndex.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false)
    public WebSiteEntity getWebSiteBySiteId() {
        return webSiteBySiteId;
    }

    public void setWebSiteBySiteId(WebSiteEntity webSiteBySiteId) {
        this.webSiteBySiteId = webSiteBySiteId;
    }
}
