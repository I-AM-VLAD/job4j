package ru.job4j.chapter_007.jdbc;

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
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception{
        try (Connection connection1 = connection) {
            try (Statement statement = connection1.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s (%s, %s);",
                        tableName,
                        "id serial primary key",
                        "name text"
                );
                statement.execute(sql);
            }
        }
    }

    public void dropTable(String tableName) throws Exception{
        try (Connection connection2 = connection) {
            try (Statement statement = connection2.createStatement()) {
                String sql = String.format(
                        "drop table %s;",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        try (Connection connection3 = connection) {
            try (Statement statement = connection3.createStatement()) {
                String sql = String.format(
                        "alter table %s add %s %s;",
                        tableName,
                        columnName,
                        type
                );
                statement.execute(sql);
            }
        }
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        try (Connection connection4 = connection) {
            try (Statement statement = connection4.createStatement()) {
                String sql = String.format(
                        "alter table %s drop %s;",
                        tableName,
                        columnName
                );
                statement.execute(sql);
            }
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        try (Connection connection5 = connection) {
            try (Statement statement = connection5.createStatement()) {
                String sql = String.format(
                        "alter table %s rename column %s to %s;",
                        tableName,
                        columnName,
                        newColumnName
                );
                statement.execute(sql);
            }
        }
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

        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("new_table");
        tableEditor.createTable("new_table1");
        tableEditor.addColumn("new_table", "name", "text");
        tableEditor.addColumn("new_Table", "second name", "text");
        System.out.println(getTableScheme(tableEditor.connection, "new_table"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}









