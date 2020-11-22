package com.itworker.domain;

/**
 * Created by GIOPPL
 * on 2020/11/22 9:50
 * TODO:
 */
public class SchoolAreaBean {
    private int a_id;
    private int area_code;
    private String area_name;

    @Override
    public String toString() {
        return "SchoolAreaBean{" +
                "a_id=" + a_id +
                ", college_code=" + area_code +
                ", area_name='" + area_name + '\'' +
                '}';
    }

    public SchoolAreaBean(int a_id, int area_code, String area_name) {
        this.a_id = a_id;
        this.area_code = area_code;
        this.area_name = area_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public SchoolAreaBean() {
    }


    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getArea_code() {
        return area_code;
    }

    public void setArea_code(int area_code) {
        this.area_code = area_code;
    }
}
