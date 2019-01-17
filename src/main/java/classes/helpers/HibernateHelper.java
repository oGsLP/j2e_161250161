package classes.helpers;

import classes.entities.Deal;
import classes.entities.Goods;
import classes.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/13
 * @Time: 18:01
 * @Package: classes.helpers
 */
public class HibernateHelper {
    private static SessionFactory sessionFactory=getSessionFactory();


    private static SessionFactory getSessionFactory(){
        Configuration configuration=new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Goods.class);
        configuration.addAnnotatedClass(Deal.class);
        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory=configuration.buildSessionFactory(registry);
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
