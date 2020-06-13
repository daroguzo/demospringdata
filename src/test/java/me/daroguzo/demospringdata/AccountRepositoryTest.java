package me.daroguzo.demospringdata;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
//        QAccount account = QAccount.account;
//        Predicate predicate = account.userName.containsIgnoreCase("daroguzo")
//                .and(account.password.startsWith("rlawlsdn"));
//        Optional<Account> one = accountRepository.findOne(predicate);
//        assertThat(one).isEmpty();
        Account account = new Account();
        account.setUserName("daroguzo");
        account.setPassword("rlawlsdn");
        accountRepository.save(account);
        assertEquals(1, accountRepository.findAll().size());

        Optional<Account> daroguzo = accountRepository.findOne(QAccount.account.userName.contains("daroguzo"));
        assertThat(daroguzo).isPresent();
        Optional<Account> jpa = accountRepository.findOne(QAccount.account.userName.contains("jpa"));
        assertThat(jpa).isEmpty();


    }
}