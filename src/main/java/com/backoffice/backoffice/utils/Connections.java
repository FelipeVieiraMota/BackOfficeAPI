/*
 * Tenho PLENA conciência de que isso não é o ideal e que em  um ambiente melhor
 * configurado as variáveis de conexão deveriam vir como variaveis de  ambiente.
 * Porem para fins de testes fiz dessa forma.
 * */

package com.backoffice.backoffice.utils;

import java.sql.*;

public class Connections {
    public static Connection coreConnection(){
        Connection conn = null;
        try{
            if(conn == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/core_test";
                String user = "root";
                String password = "root@test#2019!";
                conn = DriverManager.getConnection(url,user,password);
            }
        }catch(SQLException  | ClassNotFoundException exception){
            System.out.println(exception.getCause());
        }
        return conn;
    }

    public static void closeConnection(ResultSet rs, Statement ps) {
        if (rs!=null) {
            try {
                rs.close();
            }
            catch(SQLException e) {
                System.out.println("The result set cannot be closed." + e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("The statement set cannot be closed." + e);
            }
        }
    }
}