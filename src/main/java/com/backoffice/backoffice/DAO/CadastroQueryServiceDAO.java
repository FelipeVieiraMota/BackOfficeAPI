package com.backoffice.backoffice.DAO;

import com.backoffice.backoffice.VO.Student;
import com.backoffice.backoffice.utils.Connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroQueryServiceDAO {
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public ArrayList<Student> getStudentDAO(String cpf_cnpj, String searchType){
        ArrayList<Student> loginList = new ArrayList();
        try{
            String query = CadastroQueryServiceDAO.getStudentQuery(searchType);
            ps = Connections.coreConnection().prepareStatement(query);
            ps = CadastroQueryServiceDAO.getStudentParameters(searchType, cpf_cnpj);
            rs = ps.executeQuery();
            if( rs != null){
                while(rs.next()){
                    Student student = new Student();
                    student.setIdPerson(rs.getLong("id_person"));
                    student.setName(rs.getString("name"));
                    student.setCpfCnpj(rs.getString("cpf_cnpj"));
                    student.setDsPersonType(rs.getString("cd_person_type"));
                    student.setDtBirth(rs.getString("dt_birth"));
                    student.setEmail(rs.getString("email"));
                    loginList.add(student);
                }
            }else{
                System.out.println("No results for "+ rs.toString());
            }
        }catch (SQLException | NullPointerException e){
            System.out.println("Error "+e);
        }finally {
            Connections.closeConnection(rs, ps);
        }
        return loginList;
    }

    private static String getStudentQuery(String searchType){
        StringBuilder str = new StringBuilder();
        str.append(" select ");
        str.append(" tb_core_person.id_person, ");
        str.append(" dm_person.ds_person_type, ");
        str.append(" tb_core_person.cd_person_type, ");
        str.append(" tb_core_person.dt_insert, ");
        str.append(" tb_core_person.name, ");
        str.append(" tb_core_person.cpf_cnpj, ");
        str.append(" tb_core_person.rg , ");
        str.append(" tb_core_person.email , ");
        str.append(" tb_core_person.dt_birth, ");
        str.append(" tb_core_person.cd_person_token ");
        str.append(" from tb_core_person ");
        str.append(" left join dm_person on tb_core_person.cd_person_type = dm_person.cd_person_type ");
        switch (searchType){
            case "student":{
                str.append(" where tb_core_person.cpf_cnpj = ? and tb_core_person.cd_person_type in ('student') ");
            }break;
            default:{
                str.append(" where tb_core_person.cd_person_type in ('student') order by id_person desc limit 200");
            }
        }
        return str.toString();
    }

    private static PreparedStatement getStudentParameters(String searchType, String parameter) throws SQLException{
        Integer i = 0;
        switch (searchType){
            case "student":{
                ps.setString(++i,parameter);
            }
        }
        return ps;
    }
}
