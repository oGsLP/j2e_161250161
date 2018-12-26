package classes.service;

import classes.entities.User;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 20:30
 * @Package: classes.service
 */
public interface UserService {

    /**
     * 根据ID找user
     * @param id
     * @return
     */
    User findUser(int id);

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
     * 检查username是否被注册
     * @param username
     * @return
     */
    boolean checkUserName(String username);

    /**
     * 检查user密码
     * @param username
     * @param password
     * @return
     */
    boolean checkUserPassword(String username,String password);

    /**
     * 注册一个user
     * @param username
     * @param password
     * @return
     */
    boolean registerUser(String username,String password);

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

    /**
     * user消费
     * @param username
     * @param sum
     * @return
     */
    boolean spendMoney(String username,double sum);
}
