package com.sign.in;

import com.save.SaveAccount;
import com.sign.AccountInfo;
import java.util.*;

public class SignInAccount implements CheckAccount{
    private List<String> accountList;
    private AccountInfo accountInfo;

    public SignInAccount(){
        accountInfo = new AccountInfo();
    }

    @Override
    public boolean checkIDExist(String id) {
        for(AccountInfo i: SaveAccount.accList){
            if(id.equals(i.getUserID())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPWExist(String pw) {
        for(AccountInfo i: SaveAccount.accList){
            if(pw.equals(i.getUserPW())){
                return true;
            }
        }
        return false;
    }
}
