package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domian.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import java.sql.SQLException;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void transfer(String from, String to, Double money) throws SQLException {



            Account fromAccount = accountDao.find(from);
            Account toAccount = accountDao.find(to);
            //（校验）
            fromAccount.setMoney(fromAccount.getMoney()- money);
            toAccount.setMoney(toAccount.getMoney()+ money);
            accountDao.update(fromAccount);
        System.out.println(1/0);
            accountDao.update(toAccount);



    }
}
