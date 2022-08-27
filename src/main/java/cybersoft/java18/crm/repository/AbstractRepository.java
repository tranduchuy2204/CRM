package cybersoft.java18.crm.repository;

import cybersoft.java18.crm.jdbc.MysqlConnection;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected List<T> executeQuery(JdbcExecute<List<T>> process) {
        try {
            Connection connection = MysqlConnection.getConnection();
            return process.processor(connection);
        } catch (Exception e) {
            throw new RuntimeException("Error connect database");
        }
    }

    protected Integer executeSaveAndUpdate(JdbcExecute<Integer> process) {
        try {
            Connection connection = MysqlConnection.getConnection();
            return process.processor(connection);
        } catch (Exception e) {
            throw new RuntimeException("Error connect database");
        }
    }
}
