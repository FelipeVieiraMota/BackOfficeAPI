package com.backoffice.backoffice.Services;

import com.backoffice.backoffice.DAO.CadastroQueryServiceDAO;
import com.backoffice.backoffice.DAO.LoginDAO;
import com.backoffice.backoffice.VO.Login;
import com.backoffice.backoffice.VO.Student;
import com.backoffice.backoffice.utils.MD5;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.*;

import java.util.ArrayList;

public class Services {

    public boolean doLogin(String parameters) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Gson gson = new Gson();
        Login login;
        ArrayList <Login> result;
        LoginDAO dao = new LoginDAO();

        login = gson.fromJson(parameters,Login.class);
        login.setPassword(MD5.getHash(login.getPassword(),"MD5"));
        result = dao.doLogin(login);

        if(result.size() == 1){
            for (Login lo: result) {
                if(lo.getCdStatus().equals("AT")){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Student> getAllStudents() throws NullPointerException {
        ArrayList<Student> arrayOfStudents;
        CadastroQueryServiceDAO dao = new CadastroQueryServiceDAO();
        arrayOfStudents = dao.getStudentDAO("","allStudents");
        return arrayOfStudents;
    }

    public ArrayList<Student> getStudent(String cpf_cnpj) throws NullPointerException {
        ArrayList<Student> arrayOfStudent;
        CadastroQueryServiceDAO dao = new CadastroQueryServiceDAO();
        arrayOfStudent = dao.getStudentDAO(cpf_cnpj,"student");
        return arrayOfStudent;
    }
}