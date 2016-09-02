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
    private AccountDao dao;

    public Account findAccount(String userName ) {
        return dao.findAccount(userName);
    }

    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }
}