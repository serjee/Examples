package ru.mibix.im.parser.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mibix.im.parser.dao.impl.AbstractDAO;
import ru.mibix.im.parser.model.AbstractModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ser on 05.01.2016.
 */
public class ShopsDao extends AbstractDAO {

    private static final Logger log = LogManager.getLogger(ShopsDao.class.getName());

    public ShopsDao(Connection connection) {
        setConnection(connection);
    }

    @Override
    public String getSelectRequest() {
        return null;
    }

    @Override
    public String getCreateRequest() {
        return null;
    }

    @Override
    public String getUpdateRequest() {
        return null;
    }

    @Override
    public String getDeleteRequest() {
        return null;
    }

    @Override
    public String getOneRequest() {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, AbstractModel object) throws SQLException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, AbstractModel object) {

    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, AbstractModel object) {

    }

    @Override
    protected List parseResultSet(ResultSet set) throws SQLException {
        return null;
    }
}
