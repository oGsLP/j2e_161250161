package classes.dao.impl;

import classes.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/14
 * @Time: 21:39
 * @Package: classes.dao.impl
 */
@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Object load(Class c, int id) {
        try {
            return getSession().get(c,id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List getAllList(Class c) {
        try {
            return getSession().createQuery("from "+ c.getName()).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public int getNum(Class c) {
        List list=getAllList(c);
        if(list!=null)
            return getAllList(c).size();
        else return 0;
    }

    @Override
    public boolean insert(Object bean) {
        try {
            getSession().save(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Object bean) {
        try {
            getSession().save(bean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Class c, int id) {
        boolean sign=false;
        try {
            Object bean=load(c,id);
            if(bean!=null){
                getSession().delete(bean);
                sign=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sign;
    }


    @Override
    public boolean delete(Class c, String[] ids) {
        //to do
        return false;
    }
}
