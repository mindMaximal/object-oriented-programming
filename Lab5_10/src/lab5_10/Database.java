package lab5_10;

import java.sql.*;

public class Database {
    private static final String CON_STR = "jdbc:sqlite:company.db";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet data;

    public static void setConnection() throws ClassNotFoundException, SQLException
    {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");

        System.out.println("База Подключена!");
    }

    public static void read() throws ClassNotFoundException, SQLException
    {
        data = statement.executeQuery("SELECT * FROM cars");

        while(data.next())
        {
            int id = data.getInt("id");
            String  name = data.getString("name");
            String  speed = data.getString("speed");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "speed = " + speed );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void close() throws ClassNotFoundException, SQLException
    {
        connection.close();
        statement.close();
        data.close();

        System.out.println("Соединения закрыты");
    }
}
