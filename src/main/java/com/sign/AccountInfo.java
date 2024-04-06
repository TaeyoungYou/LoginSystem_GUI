package com.sign;

import java.io.*;

public class AccountInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nickName;
    private String userID;
    private String userPW;
    private String secQues ="";
    private String secAns ="";


    public AccountInfo(){

    }

    // Getter
    public String getNickName() {
        return nickName;
    }

    public String getUserID() {
        return userID;
    }
    public String getUserPW(){
        return userPW;
    }
    public String getSecQues(){
        return secQues;
    }
    public String getSecAns(){
        return secAns;
    }

    // Setter
    public void setNickName(String name){
        this.nickName = name;
    }
    public void setUserID(String id){
        this.userID = id;
    }
    public void setUserPW(String pw){
        this.userPW = pw;
    }
    public void setSecQues(String ques){
        this.secQues = ques;
    }
    public void setSecAns(String ans){
        this.secAns = ans;
    }
}
