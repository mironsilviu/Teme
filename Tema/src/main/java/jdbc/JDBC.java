package jdbc;

import javafx.util.converter.LocalDateStringConverter;
import model.person.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBC {



    public static void main(String[] args) {
//        CreateDB();
        JDBC();
    }
//    private static void CreateDB() {
//        Connection connection = newConnection(
//                "localhost",
//                "5432",
//                "postgres",
//                "qwerty",
//                "postgresql"
//        );
////     autocomit true will make the commit automaticaly after the submision
//        try {
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        PreparedStatement preparedStatement =
//                null;
//        try {
//            preparedStatement = connection.prepareStatement("create database homework9;");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    private static void JDBC() {
        Connection connection = newConnection(
                "localhost",
                "5432",
               "homework9",
                "postgres",
                "qwerty",
                "postgresql"
        );
// autocommit false - you can make the commit after submiting a block of code
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("create table client(PersonID serial," +
//                            " FirstName varchar(255)," +
//                            " LastName varchar(255) not null," +
//                            " CNP bigint, " +
//                            " acoommodated boolean," +
//                            "posting_date DATE NOT NULL DEFAULT CURRENT_DATE);");
//
//            preparedStatement.execute();
//            connection.commit();

//            PreparedStatement preparedStatement1 =
//                    connection.prepareStatement("insert into client (FirstName, LastName, CNP, acoommodated) values " +
//                            "('Silviu','Miron', 1890745453212, true)," +
//                            "('Alexandru', 'Popovici', 1890725333123, true)," +
//                            "('Andrei', 'Miron', 1894725385523, false)," +
//                            "('Vlad', 'Miron', 1890755381234, true);");
//
//
//            preparedStatement1.execute();
//            connection.commit();

//            PreparedStatement preparedStatement2 =
//                    connection.prepareStatement("delete from client where personid = 3");
//
//            preparedStatement2.execute();
//           connection.commit();

//            PreparedStatement preparedStatement3 =
//                    connection.prepareStatement("update client set firstname = ?, acoommodated = ? where personid = ?");
//            preparedStatement3.setString(1,"Cristi");
//            preparedStatement3.setBoolean(2, false);
//            preparedStatement3.setInt(3,1);
//
//            preparedStatement3.execute();
//            connection.commit();

            Statement statement =
                    connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select cnp, posting_date from client");
            System.out.println(resultSet);

            List<Client> listClient = new ArrayList<>();
            while(resultSet.next()){
                Client client = new Client();
//                client.setFirstName(resultSet.getString("FirstName"));
//                client.setLastName(resultSet.getString("LastName"));
//                client.setPersonID(resultSet.getInt("personID"));
                client.setCnp(resultSet.getLong("cnp"));
//                client.setAccommodated(resultSet.getBoolean("acoommodated"));
                client.setPostingDate(resultSet.getString("posting_date"));

                listClient.add(client);
            }
listClient.forEach(System.out::println);
//            listClient.forEach(client -> System.out.println(client.getCnp()));
//            listClient.forEach(client -> System.out.println(client.getPostingDate()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection newConnection(String host, String port,  String user, String password, String type) {
        loadDriver();

        String url = "jdbc:" + type + "://" + host + ":" + port + "/"+ "?user=" + user + "&password=" + password;

        System.out.println(url);
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static Connection newConnection(String host, String port, String dataB, String user, String password, String type) {
        loadDriver();

        String url = "jdbc:" + type + "://" + host + ":" + port + "/"+dataB+ "?user=" + user + "&password=" + password;

        System.out.println(url);
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
