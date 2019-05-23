package com.szu.labmanagementsystem.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("tb_user")
public class UserEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String userName;
    private String passWord;
    private String StudentNo;
    private Integer age;

    public UserEntity() {
    }

    public UserEntity(Long userId, String userName, String passWord, String studentNo, Integer age) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        StudentNo = studentNo;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
