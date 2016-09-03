package net.lyugaev.shop.service;

import net.lyugaev.shop.entity.Account;

/**
 * Created by dmitrylyugaev on 01/09/16.
 */
public interface AccountService {

    public Account findAccount(String userName );

    public void saveAccount(Account account);

    public boolean isLoginAlreadyExist(String login);
}
