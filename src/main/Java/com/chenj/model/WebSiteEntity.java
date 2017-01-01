package com.chenj.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2016/10/15.
 */
@Entity
@Table(name = "web_site", schema = "", catalog = "joke_talker")
public class WebSiteEntity {
    private int id;
    private String webAddress;
    private String name;
    private Collection<JokeEntity> jokesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "web_address", nullable = false, insertable = true, updatable = true, length = 45)
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSiteEntity that = (WebSiteEntity) o;

        if (id != that.id) return false;
        if (webAddress != null ? !webAddress.equals(that.webAddress) : that.webAddress != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (webAddress != null ? webAddress.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "webSiteBySiteId")
    public Collection<JokeEntity> getJokesById() {
        return jokesById;
    }

    public void setJokesById(Collection<JokeEntity> jokesById) {
        this.jokesById = jokesById;
    }
}
