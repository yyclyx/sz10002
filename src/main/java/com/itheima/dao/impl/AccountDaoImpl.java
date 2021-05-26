package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domian.Account;
import com.itheima.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*@Autowired
    private QueryRunner queryRunner;*/

    public Account find(String accountName) throws SQLException {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        //Account account = queryRunner.query("select * from account where name = ?", new BeanHandler<Account>(Account.class), accountName);
        return account;
    }

    public void update(Account account) throws SQLException {
        String sql = "update account set name = ?,money = ? where id = ?";
        jdbcTemplate.update(sql,account.getName(), account.getMoney(), account.getId());

    }
}
