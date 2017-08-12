package org.iMybatis.abc.dao;

import java.util.List;

import org.iMybatis.abc.dto.UserDto;

/**
 * UserDao 这个接口的同名实现在 UserDao.xml 里
 */
public interface UserDao {
    public List<UserDto> selectUsers(UserDto user) throws Exception;
    public int insertUser(UserDto user);
    public int insertUserList(List<UserDto> userList);
    public int deleteList(List<UserDto> userList);
    public int updateList(List<UserDto> userList);

}
