package com.save;

import com.sign.AccountInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveAccount implements Serializable{
    public static ArrayList<AccountInfo> accList;
    private final String path;
    private SaveAccount(){
        path = "bin/Account.bin";   // should change bin path
        accList = loadAccountList();
    }
    private ArrayList<AccountInfo> loadAccountList(){
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))){
            return (ArrayList<AccountInfo>) oi.readObject();
        }catch(ClassNotFoundException | IOException e){
            return new ArrayList<>();
        }
    }
    public static class CreateClass {
        public static final SaveAccount INSTANCE = new SaveAccount();
    }
    public static SaveAccount getInstance(){
        return CreateClass.INSTANCE;
    }

    public void addAccount(AccountInfo accountInfo){
        accList.add(accountInfo);
    }
    public void saveAccountInfo(){
        try(ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(path))){
            obOut.writeObject(accList);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void showAll(){
        for(AccountInfo i: accList){
            System.out.println(i.getNickName());
            System.out.println(i.getUserID());
            System.out.println(i.getUserPW());
            System.out.println(i.getSecAns());
        }
    }
}
