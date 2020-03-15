package com.backoffice.backoffice.VO;

public class Login {
    private long idUser;
    private String login;
    private String password;
    private String dtInsert;
    private String userAgent;
    private String cdStatus;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDtInsert() {
        return dtInsert;
    }

    public void setDtInsert(String dtInsert) {
        this.dtInsert = dtInsert;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
}
