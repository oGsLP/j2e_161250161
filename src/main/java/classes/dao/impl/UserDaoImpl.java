package classes.dao.impl;

import classes.dao.UserDao;
import classes.entities.User;
import classes.helpers.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 20:45
 * @Package: classes.dao.impl
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao  {

    private static UserDaoImpl userDao=new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance(){
        return userDao;
    }



    @Override
    public String getName(int id) {
        String username=null;
        User user= (User) super.load(User.class,id);
        if(user!=null){
            username=user.getUsername();
        }
        return username;
    }

    @Override
    public User findUser(String username) {
        int id = getIdByName(username);
        if(id>0){
            return (User) super.load(User.class,id);
        }
        else return null;
    }

    @Override
    public List getUsers() {
        return super.getAllList(User.class);
    }

    @Override
    public boolean addUser(User user) {
        if(user!=null){
            return super.insert(user);
        }
        else
            return false;
    }

    @Override
    public boolean deleteUser(String username) {
        if(username!=null&&getIdByName(username)>0){
            return super.delete(User.class,getIdByName(username));
        }
        else
            return false;
    }

    @Override
    public boolean updateUser(User user) {
        if(user!=null){
            return super.update(user);
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
        Session session=HibernateHelper.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from User user where user.username=:name");
        query.setParameter("name",username);
        List list=query.list();transaction.commit();
        if(list!=null) {
            User user = (User) list.get(0);
            id = user.getId();
        }
        return id;
    }

}
