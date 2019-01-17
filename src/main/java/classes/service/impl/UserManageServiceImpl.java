package classes.service.impl;

import classes.dao.UserDao;
import classes.dao.impl.UserDaoImpl;
import classes.entities.User;
import classes.factory.DaoFactory;
import classes.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:28
 * @Package: classes.service.impl
 */
@Service(value = "UserManageService")
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserDao userDao;




//    private static UserManageServiceImpl userService=new UserManageServiceImpl();
//    public static UserManageServiceImpl getInstance(){return userService;}


    @Override
    public User findUser(int id) {
        User user=null;
        String username= userDao.getName(id);
        if(username!=null){
            user=findUser(username);
        }
        return user;
    }

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }

    @Override
    public List getUsers() {
        return userDao.getUsers();
    }

    @Override
    public boolean checkUserName(String username) {
        return findUser(username) != null;
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        return findUser(username).getPassword().equals(password);
    }

    @Override
    public boolean registerUser(String username, String password) {
        if(findUser(username)!=null){
            userDao.addUser(new User(username,password));
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteUser(String username) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean spendMoney(String username, double sum) {
        return false;
    }


}
