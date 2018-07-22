package ru.mibix.im.parser.dao.impl;

import ru.mibix.im.parser.model.AbstractModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Абстрактный класс для реализации GRUD-операций
 */
public abstract class AbstractDAO<T extends AbstractModel> {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Returns SQL request to insert some element to the DB
     * Ex.: SELECT * FROM [Table]
     * */
    public abstract String getSelectRequest();

    /**
     * Returns SQL request to insert some element to the DB
     * Ex.: INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...)
     * */
    public abstract String getCreateRequest();

    /**
     * Returns SQL request to update some element in the DB
     * Ex.: UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     * */
    public abstract String getUpdateRequest();

    /**
     * Returns SQL request to delete some element in the DB
     * Ex.:DELETE FROM [Table] WHERE id= ?;
     * */
    public abstract String getDeleteRequest();

    /**
     * Returns SQL request to get one element by id from the table
     * Ex.: SELECT * FROM [Table] WHERE id = ?;
     * */
    public abstract String getOneRequest();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    protected abstract void prepareStatementForDelete(PreparedStatement statement, T object);

    protected abstract List<T> parseResultSet(ResultSet set) throws SQLException;

    public void create(T object) throws SQLException {
        String request = getCreateRequest();
        try (PreparedStatement statement = getConnection().prepareStatement(request)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("You can't modify more than one object at a time");
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(T entity) throws SQLException {
        String request = getDeleteRequest();
        try(PreparedStatement statement = getConnection().prepareStatement(request)) {
            prepareStatementForDelete(statement, entity);

            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("You can't delete more than one object at a time");
            }
        } catch (SQLException e) {
            throw new SQLException(e);

        }
    }

    public void update(T entity) throws SQLException {
        String request = getUpdateRequest();
        try(PreparedStatement statement = getConnection().prepareStatement(request)) {
            prepareStatementForUpdate(statement, entity);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("You can't update more than one object at a time");
            }
        } catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public T get(Integer key) throws SQLException {
        String request = getOneRequest();
        PreparedStatement statement = getConnection().prepareStatement(request);

        statement.setInt(1, key);

        ResultSet set = statement.executeQuery();
        return parseResultSet(set).get(0);
    }

    public List<T> getAll() throws SQLException {
        String request = getSelectRequest();
        PreparedStatement statement = getConnection().prepareStatement(request);

        ResultSet set = statement.executeQuery();
        return parseResultSet(set);
    }
}
