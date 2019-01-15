package classes.dao.impl;

import classes.dao.BaseDao;
import classes.helpers.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/14
 * @Time: 21:39
 * @Package: classes.dao.impl
 */
public class BaseDaoImpl implements BaseDao {

    @Override
    public Object load(Class c, int id) {
        try {
            Session session=HibernateHelper.getSession();
            Transaction transaction=session.beginTransaction();
            Object o=session.get(c,id);
            transaction.commit();
            return o;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List getAllList(Class c) {
        try {
            Session session=HibernateHelper.getSession();
            Transaction transaction=session.beginTransaction();
            List list=session.createQuery("from "+ c.getName()).list();
            transaction.commit();
            return list;
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
            Session session=HibernateHelper.getSession();
            Transaction transaction=session.beginTransaction();
            session.save(bean);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Object bean) {
        try {
            Session session=HibernateHelper.getSession();
            Transaction transaction=session.beginTransaction();
            session.update(bean);
            transaction.commit();
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
            Session session=HibernateHelper.getSession();
            Transaction transaction=session.beginTransaction();
            Object bean=load(c,id);
            if(bean!=null){
                session.delete(bean);
                sign=true;
            }
            transaction.commit();
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
