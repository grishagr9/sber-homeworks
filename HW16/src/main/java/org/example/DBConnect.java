package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBConnect implements Source{

    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static  String password = "password";

    public DBConnect(){
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Создать таблицу
            String sql = "CREATE TABLE IF NOT EXISTS data (id SERIAL PRIMARY KEY, input INTEGER, result INTEGER [])";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Успешное подключение к таблице");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public List<Integer> getData(int i) {
        List<Integer> result = null;
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Выполнить запрос
            String sql = "SELECT * FROM data WHERE data.input = %d";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(sql, i));

            result = resultToList(resultSet);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return result;
    }

    private List<Integer> resultToList(ResultSet resultSet) throws SQLException {
        java.sql.Array resultSetArray = null;
        while (resultSet.next()){
            resultSetArray = resultSet.getArray("result");
        }

        if(resultSetArray!=null) {
            Integer[] arr = (Integer[]) resultSetArray.getArray();
            return new ArrayList<>(Arrays.asList(arr));
        }else{
            return null;
        }
    }

    @Override
    public void saveData(int i, List<Integer> list) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Создать подготовленный запрос для вставки данных
            String sql = "INSERT INTO data (input, result) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, i);
            statement.setArray(2, conn.createArrayOf("Integer", list.toArray(new Integer[0])));

            // Выполнить запрос и получить количество затронутых строк
            int rowCount = statement.executeUpdate();

            // Обработать результат
            if (rowCount > 0) {
                System.out.println("Запись успешно добавлена.");
            } else {
                System.out.println("Не удалось добавить запись.");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
