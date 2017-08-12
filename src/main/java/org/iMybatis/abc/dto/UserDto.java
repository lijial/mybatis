package org.iMybatis.abc.dto;

public class UserDto {
    private Integer userid;
    private String username;
    private String password;
    private String address;
    private String createtime;

    public UserDto() {

    }

    public UserDto(Integer userid, String username, String password, String address, String createtime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.address = address;
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
