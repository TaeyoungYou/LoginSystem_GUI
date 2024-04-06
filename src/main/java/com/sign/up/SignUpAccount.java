package com.sign.up;

import com.save.SaveAccount;
import com.sign.AccountInfo;


public class SignUpAccount implements CheckPermit{
    private AccountInfo accountInfo;

    public SignUpAccount(){
        accountInfo = new AccountInfo();
    }
    public AccountInfo returnSignUpInfo(){
        return accountInfo;
    }
    public void createNickName(String name){
        accountInfo.setNickName(name);
    }
    public boolean createID(String id){
        if(!checkIDDuplication(id)){
            accountInfo.setUserID(id);
            return true;
        }
        return false;
    }
    public boolean createPW(String pw){
        if(checkPWPermittion(pw)){
            accountInfo.setUserPW(pw);
            return true;
        }
        return false;
    }
    public void createSecurityQuestion(String que){
        accountInfo.setSecQues(que);
    }
    public void createSecurityAnswer(String ans){
        accountInfo.setSecAns(ans);
    }

    @Override
    public boolean checkIDDuplication(String id) {  // ID가 중복이니?, ID가 8자 미만이니?
    	if(id.length() >= 8) {
    		if(SaveAccount.accList == null){
                return false;
            }
            for(AccountInfo i: SaveAccount.accList){
                if(id.equals(i.getUserID())){
                    return true;
                }
            }
            return false;
    	}
    	return true;
    }

    @Override
    public boolean checkPWPermittion(String pw) {   // PW가 허용가능?
        // 아스키코드: 33 ~ 126
        if(pw.length() < 8){
            return false;
        }
        for(String s: pw.split("")){
            if(!((int)s.charAt(0) > 32 && (int)s.charAt(0) < 127)){
                return false;
            }
        }
        return true;
    }
}
