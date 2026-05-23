/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;



/**
 *
 * @author Setlhabe Tsedintle
 */
public class Login {
     private String loginUsername;
     private String loginPassword;
     
     //Constructor
     public Login(String Username,String Password)
     {
     this.loginUsername=Username;
     this.loginPassword=Password;
     }
     
      public  boolean loginUser(String Username,String Password)
    {
      return Username.equals(loginUsername) && Password.equals(loginPassword);
    }
    
        public String  returnLoginStatus(String userfirstname,String userlastname,String Username,String Password)
    { 
        if (loginUser(Username,Password))
        {
            return " Welcome "+ userfirstname + " "+ userlastname +" it is nice to see again.";
            
        }
        else
        {
        return  "Username or password incorrect,please try again.";
          
        }
        
    }
}
