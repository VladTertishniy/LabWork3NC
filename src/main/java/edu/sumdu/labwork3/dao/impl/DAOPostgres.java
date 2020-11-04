package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.controller.BasketOfGoodsController;
import edu.sumdu.labwork3.dao.DAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
@Getter
@Setter
@Repository
public class DAOPostgres extends DAO {

    final static Logger logger = Logger.getLogger(BasketOfGoodsController.class);
    private final DataSource dataSource;

    @Override
    public Connection connect() {
        try {
            connection = dataSource.getConnection();
            if (!connection.isClosed()) {
                logger.info("Connection Successful!");
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return connection;
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            logger.info("Connection was closed!");
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
    }
}
