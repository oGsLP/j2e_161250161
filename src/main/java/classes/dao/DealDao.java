package classes.dao;

import classes.entities.Deal;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/15
 * @Time: 13:03
 * @Package: classes.dao
 */
public interface DealDao {

    Deal findDeal(int id);

    List getDeals();

    List getDeals(String username);

    boolean addDeal(Deal deal);

    boolean deleteDeal(int id);

    boolean updateDeal(Deal deal);

}
