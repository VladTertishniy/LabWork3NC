package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
@Getter
@Setter
public class DAOPostgres extends DAO {

    private final DataSource dataSource;

    @Override
    public Connection connect() {
        try {
            connection = dataSource.getConnection();
            if (!connection.isClosed()) {
                System.out.println("Connected!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            resultSet.close();
            statement.close();
            System.out.println("Disconnected!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
