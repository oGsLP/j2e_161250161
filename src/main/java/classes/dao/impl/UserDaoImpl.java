package classes.dao.impl;

import classes.dao.BaseDao;
import classes.dao.UserDao;
import classes.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 20:45
 * @Package: classes.dao.impl
 */
@Repository(value = "UserDao")
public class UserDaoImpl implements UserDao  {


    @Autowired
    private BaseDao baseDao;
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
//    private static UserDaoImpl userDao=new UserDaoImpl();
//
//    private UserDaoImpl() {
//    }
//
//    public static UserDaoImpl getInstance(){
//        return userDao;
//    }



    @Override
    public String getName(int id) {
        String username=null;
        User user= (User) baseDao.load(User.class,id);
        if(user!=null){
            username=user.getUsername();
        }
        return username;
    }

    @Override
    public User findUser(String username) {
        int id = getIdByName(username);
        if(id>0){
            return (User) baseDao.load(User.class,id);
        }
        else return null;
    }

    @Override
    public List getUsers() {
        return baseDao.getAllList(User.class);
    }

    @Override
    public boolean addUser(User user) {
        if(user!=null){
            return baseDao.insert(user);
        }
        else
            return false;
    }

    @Override
    public boolean deleteUser(String username) {
        if(username!=null&&getIdByName(username)>0){
            return baseDao.delete(User.class,getIdByName(username));
        }
        else
            return false;
    }

    @Override
    public boolean updateUser(User user) {
        if(user!=null){
            return baseDao.update(user);
        }
        else return false;
    }


//    private void setUserExID(User user, PreparedStatement pstmt) throws SQLException {
//        pstmt.setString(1,user.getUsername());
//        pstmt.setString(2,user.getPassword());
//        pstmt.setDouble(3,user.getAccount());
//    }
    private int getIdByName(String username){
        int id = -1;
        Query query=getSession().createQuery("from User user where user.username=:name");
        query.setParameter("name",username);
        List list=query.list();
        if(list!=null) {
            User user = (User) list.get(0);
            id = user.getId();
        }
        return id;
    }

}
