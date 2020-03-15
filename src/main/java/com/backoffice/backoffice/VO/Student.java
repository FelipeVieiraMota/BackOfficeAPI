package com.backoffice.backoffice.VO;

public class Student {

    Long idPerson;
    String name;
    String cpfCnpj;
    String rg;
    String email;
    String dtBirth;
    String cdPersonType;
    String dsPersonType;
    String cdPersonToken;
    String dtInsert;

    public Student() {
    }

    public Student(Long idPerson, String name, String cpfCnpj, String rg, String email, String dtBirth, String cdPersonType, String dsPersonType, String cdPersonToken, String dtInsert) {
        this.idPerson = idPerson;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.rg = rg;
        this.email = email;
        this.dtBirth = dtBirth;
        this.cdPersonType = cdPersonType;
        this.dsPersonType = dsPersonType;
        this.cdPersonToken = cdPersonToken;
        this.dtInsert = dtInsert;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(String dtBirth) {
        this.dtBirth = dtBirth;
    }

    public String getCdPersonType() {
        return cdPersonType;
    }

    public void setCdPersonType(String cdPersonType) {
        this.cdPersonType = cdPersonType;
    }

    public String getDsPersonType() {
        return dsPersonType;
    }

    public void setDsPersonType(String dsPersonType) {
        this.dsPersonType = dsPersonType;
    }

    public String getCdPersonToken() {
        return cdPersonToken;
    }

    public void setCdPersonToken(String cdPersonToken) {
        this.cdPersonToken = cdPersonToken;
    }

    public String getDtInsert() {
        return dtInsert;
    }

    public void setDtInsert(String dtInsert) {
        this.dtInsert = dtInsert;
    }
}
