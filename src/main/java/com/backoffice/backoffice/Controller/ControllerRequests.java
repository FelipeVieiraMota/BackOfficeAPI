package com.backoffice.backoffice.Controller;

import com.backoffice.backoffice.Services.Services;
import com.backoffice.backoffice.VO.ResponseStatus;
import com.backoffice.backoffice.VO.Student;

import com.backoffice.backoffice.utils.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@RestController
public class ControllerRequests {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcomeMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta charset=\"utf-8\">\n");
        sb.append("<title>Welcome</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<h1>Welcome to Back Office API.</h1>\n");
        sb.append("<p>This system will be improve to bring a complete Back Office platform.</p>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity doLogin (@Valid @RequestBody String parameters) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Services service = new Services();
        if(service.doLogin(parameters))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<ResponseStatus> getAllStudents () throws NullPointerException {
        Services service = new Services();
        ArrayList<Student> arrayOfStudents = service.getAllStudents();
        Integer sizeOfArray = arrayOfStudents.size();
        ResponseStatus response = null;
        if( sizeOfArray == 0 ){
            response = ResponseObject.getResponseObject(arrayOfStudents, true, HttpStatus.NO_CONTENT);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.NO_CONTENT);
        } else{
            response = ResponseObject.getResponseObject(arrayOfStudents, true, HttpStatus.OK);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.OK);
        }
    }

    @GetMapping(value = "/student/{cpf_cnpj}")
    public ResponseEntity<ResponseStatus> getStudent (@PathVariable("cpf_cnpj") String cpf_cnpj) throws NullPointerException {
        Services service = new Services();
        ArrayList<Student> arrayOfStudent = service.getStudent(cpf_cnpj);
        Integer sizeOfArray = arrayOfStudent.size();
        ResponseStatus response = null;

        if( sizeOfArray == 0 ){
            response = ResponseObject.getResponseObject(arrayOfStudent, true, HttpStatus.NO_CONTENT);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.NO_CONTENT);
        } else{
            response = ResponseObject.getResponseObject(arrayOfStudent, true, HttpStatus.OK);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.OK);
        }
    }
}