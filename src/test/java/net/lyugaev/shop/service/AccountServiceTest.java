package net.lyugaev.shop.service;

import net.lyugaev.shop.dao.AccountDao;
import net.lyugaev.shop.entity.Account;
import net.lyugaev.shop.entity.Account;
import org.hamcrest.core.IsEqual;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by dmitry on 10.09.16.
 */
public class AccountServiceTest {

    private AccountServiceImpl accountService;
    private AccountDao dao;

    @Before
    public void setup() {
        accountService = new AccountServiceImpl();
        dao = mock(AccountDao.class);
        accountService.dao = dao;
    }

    @Test
    public void findAccount_Ok_Test() {
        Account account = new Account();
        account.setUserName("jora");
        when(dao.findAccount("jora")).thenReturn(account);

        Account account1 = accountService.findAccount("jora");

        verify(dao).findAccount("jora");
        assertThat(account1.getUserName(), equalTo("jora"));
    }

    @Test
    public void findAccount_ReturnNull_Test() {
        when(dao.findAccount(anyString())).thenReturn(null);

        Account result = accountService.findAccount("xxx");

        verify(dao).findAccount("xxx");
        assertThat(result, equalTo(null));
    }

    @Test
    public void saveAccount_Ok_Test() {
        Account account = new Account();

        accountService.saveAccount(account);

        verify(dao).saveAccount(account);
    }

    @Test
    public void isLoginAlreadyExist_Test() {
        when(dao.findAccount("dmitry")).thenReturn(new Account());
        when(dao.findAccount("jora")).thenReturn(new Account());
        when(dao.findAccount("wefwefwefwefe")).thenReturn(null);

        boolean result1 = accountService.isLoginAlreadyExist("jora");
        boolean result2 = accountService.isLoginAlreadyExist("wefwefwefwefe");
        boolean result3 = accountService.isLoginAlreadyExist(null);
        boolean result4 = accountService.isLoginAlreadyExist("dmitry");

        verify(dao, times(4)).findAccount(anyString());
        assertThat(result1, equalTo(true));
        assertThat(result2, equalTo(false));
        assertThat(result3, equalTo(false));
        assertThat(result4, equalTo(true));
    }
}
