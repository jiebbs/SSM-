package com.jiebbs.ssm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Integer id;

    private String username;

    private String password;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    private Integer role;

    public User(Integer id, String username, String password, Date regDate, Date lastUpdateDate, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.lastUpdateDate = lastUpdateDate;
        this.role = role;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}