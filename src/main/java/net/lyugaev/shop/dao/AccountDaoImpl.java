package net.lyugaev.shop.dao;

/**
 * Created by dmitry on 29.08.16.
 */
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import net.lyugaev.shop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository("accountDAO")
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {

    public Account findAccount(String userName ) {
        Criteria crit = getSession().createCriteria(Account.class);
        crit.add(Restrictions.eq("userName", userName));
        return (Account) crit.uniqueResult();
    }

    public void saveAccount(Account account) {
        getSession().persist(account);
    }
}
