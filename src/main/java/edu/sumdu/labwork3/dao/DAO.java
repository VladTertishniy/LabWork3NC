package edu.sumdu.labwork3.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class DAO {
    public ResultSet resultSet;
    public PreparedStatement statement;
    public Connection connection;
    public abstract Connection connect();
    public abstract void disconnect();
    public PreparedStatement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
