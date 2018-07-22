package ru.mibix.im.parser.dao.impl;

import ru.mibix.im.parser.dao.*;
import java.sql.Connection;

public class DbDaoFactory implements DaoFactory {

    @Override
    public Connection getConnection() throws DaoException {
        return ConnectionFactory.getConnection();
    }

    @Override
    public QueriesDao getQueriesDao() throws DaoException {
        return new QueriesDao(getConnection());
    }

    @Override
    public ShopsDao getShopsDao() throws DaoException {
        return new ShopsDao(getConnection());
    }
}
