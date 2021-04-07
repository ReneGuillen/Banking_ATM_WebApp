package simpleservlet;

import java.sql.*;

public class RegisterDao {

    private String dbUrl = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net/heroku_4e6640c13f3a3bb";
    private String dbUsername = "b9d82f50480f79";
    private String dbPassword = "d16cbee0";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    //Load jdbc driver to connect to the database.
    public void loadDriver(){
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //Make a connection to the database.
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    //Method to add a new member to the database with username, email and password.
    public void insert(Member member) throws SQLException, ClassNotFoundException {
        loadDriver();
        Connection connection = getConnection();
        String sql =  "insert into heroku_4e6640c13f3a3bb.member values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, member.getUserName());
        ps.setString(2, member.getEmail());
        ps.setString(3, member.getPassword());
        ps.setString(4, "0");
        ps.executeUpdate();
    }

    //Method to get user's information from the database when loging in.
    public boolean retrieve(Member member) throws SQLException {
        loadDriver();
        Connection connection = getConnection();
        String uName = member.getUserName();
        String password = member.getPassword();
        String query = "Select userName, password from heroku_4e6640c13f3a3bb.member where `userName` = ? and `password` = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, uName);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            return uName.equals(resultSet.getString("userName")) && password.equals(resultSet.getString("password"));
        }
        return false;
    }

    //Method to show current user's balance in database.
    public String showBalance(String username) throws SQLException {
        loadDriver();
        Connection connection = getConnection();
        String query = "Select balance from heroku_4e6640c13f3a3bb.member where `userName` = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getString("balance");

    }

    //Method to update the user's balace in the database.
    public void updateBalance(String username, String value) throws SQLException {
        loadDriver();
        Connection connection = getConnection();
        String sql =  "UPDATE heroku_4e6640c13f3a3bb.member SET balance = ? where `userName` = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, value);
        ps.setString(2, username);
        ps.executeUpdate();
    }
}
