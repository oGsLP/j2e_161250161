package classes.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/14
 * @Time: 21:40
 * @Package: classes.dao
 */
public interface BaseDao {

    Object load(Class c, int id);

    List getAllList(Class c) ;

    int getNum(Class c) ;

    boolean insert(Object bean) ;

    boolean update(Object bean) ;

    boolean delete(Class c, int id) ;

    boolean delete(Class c, String[] ids) ;

}
