package classes.dao;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/14
 * @Time: 21:40
 * @Package: classes.dao
 */
public interface BaseDao {


    public Object load(Class c, int id);

    public List getAllList(Class c) ;

    public int getNum(Class c) ;

    public boolean insert(Object bean) ;

    public boolean update(Object bean) ;

    public boolean delete(Class c, int id) ;

    public boolean delete(Class c, String[] ids) ;

}
