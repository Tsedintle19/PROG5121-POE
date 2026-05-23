/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author setlh
 */
public class LoginTest {
    
    public LoginTest() {
    }

     @Test
    public void testLoginUser() 
    { 
         Login testMethod=new Login("","");
         boolean actual=testMethod.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
     public void testloginUserfalse() 
    {
        Login testMethod=new Login("","");
        assertFalse(testMethod.loginUser("kyle","password"));
    }    
}
