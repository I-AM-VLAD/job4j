package ru.job4j.chapter_007.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.StringJoiner;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("jdbc.driver"));
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void createStatement(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format(
                "create table if not exists %s (%s, %s);",
                tableName,
                "id serial primary key",
                "name text"
        );
        createStatement(sql);
    }

    public void dropTable(String tableName) throws Exception{
        String sql = String.format(
                "drop table %s;",
                tableName
        );
        createStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
                "alter table %s add %s %s;",
                tableName,
                columnName,
                type
        );
        createStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
                "alter table %s drop %s;",
                tableName,
                columnName
        );
        createStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        createStatement(sql);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) throws SQLException, Exception {
        Properties properties = new Properties();
        try(FileInputStream in = new FileInputStream("./chapter_002/data/tableEditor.properties")) {
            properties.load(in);
        }
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("new_table");
        tableEditor.createTable("new_table1");
        tableEditor.addColumn("new_table", "second_name", "text");
        tableEditor.renameColumn("new_table", "name", "option");
        tableEditor.dropColumn("new_table", "name1");
        tableEditor.dropTable("new_table1");
        System.out.println(getTableScheme(tableEditor.connection, "new_table1"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}









