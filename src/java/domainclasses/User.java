/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainclasses;
import java.io.Serializable;
/**
 *
 * @author 742227
 */
public class User implements Serializable{
    
    private String userName;
    private String passWord;

    public User() {
        userName = "";
        passWord = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + userName + ", password=" + passWord + '}';
    }
    
    public String getString() {
        return "foo";
    }
    
    
}


