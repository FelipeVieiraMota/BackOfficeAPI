package com.backoffice.backoffice.DAO;

import com.backoffice.backoffice.VO.Login;
import com.backoffice.backoffice.utils.Connections;
import java.sql.*;
import java.util.ArrayList;

public class LoginDAO {

    public ArrayList<Login> doLogin(Login login){
        ArrayList<Login> loginList = new ArrayList();
        StringBuilder str = new StringBuilder();
        str.append(" select * from tb_core_user ");
        str.append(" inner join tb_core_dm_user_status on tb_core_user.cd_status = tb_core_dm_user_status.cd_status ");
        str.append(" where cd_user = ? and password = ? ");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            int i = 0;
            ps = Connections.coreConnection().prepareStatement(str.toString());
            ps.setString(++i,login.getLogin());
            ps.setString(++i,login.getPassword());
            rs = ps.executeQuery();
            if( rs != null){
                while(rs.next()){
                    Login lo = new Login();
                    lo.setLogin(rs.getString("cd_user"));
                    lo.setPassword(rs.getString("password"));
                    lo.setCdStatus(rs.getString("cd_status"));
                    lo.setDtInsert(rs.getString("dt_insert"));
                    lo.setIdUser(rs.getLong("id_user"));
                    loginList.add(lo);
                }
            }
        }catch(SQLException | NullPointerException e){
            String msg = e.getMessage();
            Throwable cause = e.getCause();
            System.out.println("Message: " + msg + "Cause " + cause);
        }finally {
            Connections.closeConnection(rs, ps);
        }
        return loginList;
    }

}