package org.iMybatis.abc;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.iMybatis.abc.dao.UserDao;
import org.iMybatis.abc.dto.UserDto;

public class UserTest {
    private static final Log logger = LogFactory.getLog(UserTest.class);
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String args[]) {
        try {
            init();
        } catch (IOException e) {
            logger.error("", e);
        }
//        testSelect();
//        testInsert();
//        testInsertList();
//        testDeleteList();
        testUpdateList();
    }

    private static void init() throws IOException {
//        String resource = "mybatis-config.xml";
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
    }

    private static void testSelect() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            UserDto user = new UserDto();
            user.setUsername("aaa");
            List<UserDto> users = userDao.selectUsers(user);
            if (null != users) {
                // Mybatis的日志级别竟然没得info，只好用error代替了
                logger.error("****************\n Find " + users.size()
                        +"value are " + JSON.toJSONString(users)+"\n****************");
            }
            session.commit(true);
        } catch (Exception e) {
            logger.error("", e);
            session.rollback(true);
        } finally {
            session.close();
        }
    }

    private static void testInsert() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            UserDto user = new UserDto(2,"second","second","second","2017-08-12 09:10:35");
            userDao.insertUser(user);
            session.commit(true);
        } catch (Exception e) {
            logger.error("", e);
            session.rollback(true);
        } finally {
            session.close();
        }
    }

    private static void testInsertList() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            List<UserDto> userDaoList = new ArrayList<UserDto>();
            UserDao userDao = session.getMapper(UserDao.class);
            for(int i=0;i<10;i++) {
                userDaoList.add(new UserDto(i,"third","third","third","2017-08-12 09:10:35"));
            }
            userDao.insertUserList(userDaoList);
            session.commit(true);
        } catch (Exception e) {
            logger.error("", e);
            session.rollback(true);
        } finally {
            session.close();
        }
    }

    private static void testDeleteList() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            List<UserDto> userDtoList = new ArrayList<UserDto>();
            UserDao userDao = session.getMapper(UserDao.class);
            for(int i=1;i<3;i++) {
                userDtoList.add(new UserDto(i,"third","third","third","2017-08-12 09:10:35"));
            }
            userDao.deleteList(userDtoList);
            session.commit(true);
        } catch (Exception e) {
            logger.error("", e);
            session.rollback(true);
        } finally {
            session.close();
        }
    }

    private static void testUpdateList() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            List<UserDto> userDtoList = new ArrayList<UserDto>();
            UserDao userDao = session.getMapper(UserDao.class);
            for(int i=1;i<3;i++) {
                userDtoList.add(new UserDto(i,"third","third","third","2017-08-12 09:10:35"));
            }
            userDao.updateList(userDtoList);
            session.commit(true);
        } catch (Exception e) {
            logger.error("", e);
            session.rollback(true);
        } finally {
            session.close();
        }
    }
}
