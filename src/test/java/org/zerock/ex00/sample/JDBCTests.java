package org.zerock.ex00.sample;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;


//CREATE DATABASE springdb;
//
//        CREATE USER 'springdbuser'@'localhost' IDENTIFIED BY 'springdbuser';
//        CREATE USER 'springdbuser'@'%' IDENTIFIED BY 'springdbuser';
//
//        GRANT ALL PRIVILEGES ON springdb.* TO 'springdbuser'@'localhost';
//
//        GRANT ALL PRIVILEGES ON springdb.* TO 'springdbuser'@'%';

public class JDBCTests {

  @Test
  public void testConnection() throws Exception{

    //DB Driver Class
    Class.forName("org.mariadb.jdbc.Driver");

    //URL
    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/springdb",
            "springdbuser",
            "springdbuser");

    System.out.println(connection);
    //username/password

    connection.close();

  }

}
