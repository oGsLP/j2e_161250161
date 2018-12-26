package classes.dao;

import classes.entities.User;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:42
 * @Package: classes.dao
 */
public interface UserDao {

    /**
     * 根据ID找username
     * @param id
     * @return
     */
    String getName(int id);

    /**
     * 根据username找user
     * @param username
     * @return
     */
    User findUser(String username);

    /**
     * 返回所有user的列表
     * @return
     */
    List getUsers();


    /**
     * 新增一个user
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 移除user
     * @param username
     * @return
     */
    boolean deleteUser(String username);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

}
