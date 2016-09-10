package net.lyugaev.shop.service;

import net.lyugaev.shop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lyugaev.shop.dao.AccountDao;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao dao;

    public Account findAccount(String userName ) {
        return dao.findAccount(userName);
    }

    public void saveAccount(Account account) {
//        if (account.getUserRole() == null)
//            account.setUserRole(Account.ROLE_USER);

        dao.saveAccount(account);
    }

    public boolean isLoginAlreadyExist(String login) {
        Account account = dao.findAccount(login);
        return account != null;
    }
}