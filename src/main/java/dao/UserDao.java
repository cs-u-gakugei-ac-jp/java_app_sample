package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import entity.User;

public class UserDao {


//フィールド
  private final DataSource dataSorce;
  private final ConnectionCloser connectionCloser;

//コンストラクタ
  public UserDao() {
    this.dataSorce = new DataSourceHolder().dataSource;
    this.connectionCloser = new ConnectionCloser();
  }

  public List<User> getAll() throws DaoException {
    Connection connection = null;



  try{
    //ここで，データベースと接続
    System.out.println("UserDaoを実行しています");
    connection = this.dataSorce.getConnection();
    //sqlを文を格納
    PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
    //結果を格納
    ResultSet resultSet = preparedStatement.executeQuery();

    //listに格納
    List<User> users = new LinkedList<>();
    while (resultSet.next()) {
        users.add(new User(resultSet.getString("user_id"), resultSet.getString("user_name")));
    }

    return users;

  }catch (SQLException e) {

    throw new DaoException("DB error", e); 
    
  }finally{
    
    this.connectionCloser.closeConnection(connection);

  }

  }


}