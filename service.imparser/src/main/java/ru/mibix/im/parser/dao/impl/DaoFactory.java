package ru.mibix.im.parser.dao.impl;

import ru.mibix.im.parser.dao.*;
import java.sql.Connection;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    Connection getConnection() throws DaoException;
    QueriesDao getQueriesDao() throws DaoException;
    ShopsDao getShopsDao() throws DaoException;
}
