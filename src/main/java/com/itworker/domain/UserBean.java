package com.itworker.domain;

/**
 * Created by GIOPPL
 * on 2020/11/21 22:09
 * TODO:
 */
public class UserBean {
    private int u_id;
    private String username;
    private String phone_number;
    private String school_area;
    private String verify_code;
    private int grade;
    private int college;

    public UserBean(){}
    public UserBean(String username, String phone_number, String school_area, String verify_code, int grade, int college) {
        this.username = username;
        this.phone_number = phone_number;
        this.school_area = school_area;
        this.verify_code = verify_code;
        this.grade = grade;
        this.college = college;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", school_area='" + school_area + '\'' +
                ", verify_code='" + verify_code + '\'' +
                ", grade=" + grade +
                ", college=" + college +
                '}';
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSchool_area() {
        return school_area;
    }

    public void setSchool_area(String school_area) {
        this.school_area = school_area;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }
}
