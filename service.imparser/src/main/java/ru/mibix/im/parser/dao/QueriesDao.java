package ru.mibix.im.parser.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mibix.im.parser.dao.impl.*;
import ru.mibix.im.parser.model.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

public class QueriesDao extends AbstractDAO<Queries> {

    private static final Logger log = LogManager.getLogger(QueriesDao.class.getName());

    public QueriesDao(Connection connection) {
        setConnection(connection);
    }

    @Override
    public String getSelectRequest() {
        return "SELECT * FROM im_queries";
    }

    @Override
    public String getCreateRequest() {
        return "INSERT INTO im_queries (shop_id, name, status, create_time) \n" +
                "VALUES(?, ?, ?, ?)";
    }

    @Override
    public String getUpdateRequest() {
        return "UPDATE im_queries SET shop_id= ?, name= ?, status= ?, update_time= ? WHERE id= ?";
    }

    @Override
    public String getDeleteRequest() {
        return "DELETE FROM im_queries WHERE id= ?";
    }

    @Override
    public String getOneRequest() {
        return "SELECT * FROM im_queries WHERE id= ?";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Queries object) throws SQLException {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }

            statement.setInt(1, object.getShopId());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getStatus());
            statement.setDate(4, (java.sql.Date) object.getCreateTime());

        } catch (SQLException e) {
            log.error("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Queries object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }

            statement.setInt(1, object.getId());
            statement.setInt(2, object.getShopId());
            statement.setString(3, object.getName());
            statement.setInt(4, object.getStatus());
            statement.setDate(5, (java.sql.Date) object.getUpdateTime());

        } catch (SQLException e) {
            log.error("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Queries object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }
            statement.setInt(1, object.getId());
        } catch (SQLException e) {
            log.error("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected List<Queries> parseResultSet(ResultSet set) throws SQLException {
        if (set == null) {
            throw new SQLException("Statement cannot be null");
        }
        List<Queries> setQueries = new LinkedList<>();
        while (set.next()) {
            Queries queries = new Queries();

            queries.setId(set.getInt("id"));
            queries.setShopId(set.getInt("shop_id"));
            queries.setName(set.getString("name"));
            queries.setStatus(set.getInt("status"));
            queries.setCreateTime(set.getDate("create_time"));
            queries.setUpdateTime(set.getDate("update_time"));

            setQueries.add(queries);
        }
        return setQueries;
    }

    public List<Queries> getQueriesByStatus(int status) throws SQLException {

        String request = "SELECT * FROM im_queries WHERE status = ? ";
        PreparedStatement statement = getConnection().prepareStatement(request);

        statement.setInt(1, status);

        ResultSet set = statement.executeQuery();

        return parseResultSet(set);
    }
}