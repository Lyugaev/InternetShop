package net.lyugaev.shop.service;

import net.lyugaev.shop.entity.Account;
import org.hibernate.annotations.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by dmitry on 10.09.16.
 */
public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;
    private AccountService accountService;

    @Before
    public void setup() {
        authenticationService = new AuthenticationService();
        accountService = mock(AccountService.class);
        authenticationService.accountService = accountService;
    }

    @Test
    public void loadUserByUsername_Ok_Test() {
        Account account = new Account();
        account.setUserName("jora");
        account.setPassword("pass");
        when(accountService.findAccount("jora")).thenReturn(account);

        UserDetails result = authenticationService.loadUserByUsername("jora");

        verify(accountService).findAccount("jora");
        assertThat(result.getUsername(), equalTo("jora"));
        assertThat(result.getPassword(), equalTo("pass"));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_Fail_Test() {
        when(accountService.findAccount(anyString())).thenReturn(null);

        authenticationService.loadUserByUsername("jora");
    }
}
