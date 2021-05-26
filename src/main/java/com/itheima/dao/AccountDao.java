package com.itheima.dao;

import com.itheima.domian.Account;

import java.sql.SQLException;

public interface AccountDao {

    Account find(String accountName) throws SQLException;

    void update(Account account) throws SQLException;
}
