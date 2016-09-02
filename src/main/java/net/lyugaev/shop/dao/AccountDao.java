package net.lyugaev.shop.dao;

import net.lyugaev.shop.entity.Account;

/**
 * Created by dmitry on 29.08.16.
 */
public interface AccountDao {

    public Account findAccount(String userName );

    public void saveAccount(Account account);
}