package com.ycx.wpp.core.domain.dataobject;

import java.util.Date;

public class TUser {
    private Integer id;

    private Integer poiId;

    private String name;

    private String telephone;

    private String address;

    private Integer age;

    private Integer number;

    private Integer score;

    private Date updateTime;

    private String point;

    private Float lat;

    private Float lon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", poiId=" + poiId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", score=" + score +
                ", updateTime=" + updateTime +
                ", point='" + point + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}