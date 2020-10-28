package lab5_10;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static final String CON_STR = "jdbc:sqlite:sqllite/company.db";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet data;

    public void setConnection() throws ClassNotFoundException, SQLException {

        connection = null;
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection(CON_STR);

        System.out.println("База Подключена!");
    }

    public ArrayList<Vehicle> read(String type) throws ClassNotFoundException, SQLException {

        ArrayList<Vehicle> list = new ArrayList<>();

        statement = connection.createStatement();

        data = statement.executeQuery(String.format("SELECT * FROM %s", type));

        while(data.next())
        {
            int id = data.getInt("id");
            String  name = data.getString("name");
            int  speed = data.getInt("speed");
            int weight = data.getInt("weight");
            String color = data.getString("color");


            if (type.equals("cars")) {
                int wheelsCount = data.getInt("wheelsCount");

                Car car = new Car(id, name, speed, weight, color, wheelsCount);
                list.add(car);
            } else if (type.equals("express")) {
                int railsCount = data.getInt("railsCount");
                String expressType = data.getString("expressType");

                Express express = new Express(id, name, speed, weight, color, railsCount, expressType);
                list.add(express);
            }

        }

        return list;
    }

    public void close() throws ClassNotFoundException, SQLException {
        connection.close();
        statement.close();
        data.close();

        System.out.println("Соединения закрыты");
    }

    public void add(String name, int speed, int weight, String color, int wheelsCount) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO cars(`name`, `weight`, `speed`, `color`, `wheelsCount`) VALUES(?, ?, ?, ?, ?)"
        );
        statement.setObject(1, name);
        statement.setObject(2, weight);
        statement.setObject(3, speed);
        statement.setObject(4, color);
        statement.setObject(5, wheelsCount);
        // Выполняем запрос
        statement.execute();
    }

    public void add(String name, int speed, int weight, String color, int railsCount, String expressType) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO express(`name`, `weight`, `speed`, `color`, `railsCount`, `expressType`) VALUES(?, ?, ?, ?, ?, ?)"
        );
        statement.setObject(1, name);
        statement.setObject(2, weight);
        statement.setObject(3, speed);
        statement.setObject(4, color);
        statement.setObject(5, railsCount);
        statement.setObject(6, expressType);
        // Выполняем запрос
        statement.execute();
    }

    public void remove(int id, String type) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
            String.format("DELETE FROM %s WHERE id = ?", type)
        );
        statement.setObject(1, id);
        // Выполняем запрос
        statement.execute();
    }

    public void update(int id, String name, int speed, int weight, String color, int railsCount, String expressType) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE express SET name = ?, speed = ?, weight = ?, color = ?, railsCount = ?, expressType = ? WHERE id = ?"
        );
        statement.setObject(1, name);
        statement.setObject(2, speed);
        statement.setObject(3, weight);
        statement.setObject(4, color);
        statement.setObject(5, railsCount);
        statement.setObject(6, expressType);
        statement.setObject(7, id);
        // Выполняем запрос
        statement.execute();
    }

    public void update(int id, String name, int speed, int weight, String color, int wheelsCount) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE cars SET name = ?, speed = ?, weight = ?, color = ?, wheelsCount = ? WHERE id = ?"
        );
        statement.setObject(1, name);
        statement.setObject(2, speed);
        statement.setObject(3, weight);
        statement.setObject(4, color);
        statement.setObject(5, wheelsCount);
        statement.setObject(6, id);
        // Выполняем запрос
        statement.execute();
    }
}
