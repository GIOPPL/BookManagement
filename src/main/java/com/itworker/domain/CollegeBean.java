package com.itworker.domain;

/**
 * Created by GIOPPL
 * on 2020/11/22 9:39
 * TODO:
 */
public class CollegeBean {
    private int c_id;
    private int college_code;
    private String college_name;

    public CollegeBean() {
    }

    public CollegeBean(int c_id, int college_code, String college_name) {
        this.c_id = c_id;
        this.college_code = college_code;
        this.college_name = college_name;
    }

    @Override
    public String toString() {
        return "CollegeBean{" +
                "c_id=" + c_id +
                ", college_code=" + college_code +
                ", college_name='" + college_name + '\'' +
                '}';
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getCollege_code() {
        return college_code;
    }

    public void setCollege_code(int college_code) {
        this.college_code = college_code;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }
}
