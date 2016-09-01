package net.lyugaev.shop.service;

import java.util.List;

import net.lyugaev.shop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lyugaev.shop.dao.AccountDAO;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO dao;

    public Account findAccount(String userName ) {
        return dao.findAccount(userName);
    }
}