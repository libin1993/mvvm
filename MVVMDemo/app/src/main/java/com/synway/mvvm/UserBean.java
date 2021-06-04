package com.synway.mvvm;


/**
 * Author：Libin on 2021/4/20 17:03
 * Email：1993911441@qq.com
 * Describe：
 */
public class UserBean {
    private String userName;
    private int age;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserBean() {
    }


    public UserBean(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
