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
public class RegistrationAndLoginTest {
    
    public RegistrationAndLoginTest() {
    }

    @Test
    public void testCheckUserName() 
    { RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=true;
        boolean actual=testMethod.checkUserName("kyl_1");
        assertEquals(expected,actual,"The username contains an underscore is no more than five characters long.");   
    }

     @Test
    public void testIncorrectCheckUserName() 
    { RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=false;
        boolean actual=testMethod.checkUserName("kyle!!!!!!!");
        assertEquals(expected,actual,"The username does not contain an underscore is no more than five characters long.");   
    }
    
    @Test
    public void testCheckPasswordComplexity() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=true;
        boolean actual=testMethod.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals(expected,actual,"The password meets the complexity requirements.");   
        
    }
    
     @Test
    public void testIncorrectCheckPasswordComplexity() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=false;
        boolean actual=testMethod.checkPasswordComplexity("password");
        assertEquals(expected,actual,"The password does not meet the complexity requirements.");   
        
    }
    
    @Test
    public void testCheckCellPhone()
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=true;
        boolean actual=testMethod.checkCellPhone("+27838968976");
        assertEquals(expected,actual,"The cell phone is correctly formatted.");   
        
    }
    
     @Test
    public void testIncorrectCheckCellPhone()
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
        boolean expected=false;
        boolean actual=testMethod.checkCellPhone("08966553");
        assertEquals(expected,actual,"The cell phone number is incorrectly formatted.");   
    }
   

 @Test
 public void testUsernameTrue() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=true;
        boolean actual=testMethod.checkUserName("kyle!!!!!!!");
        assertTrue(testMethod.checkUserName("kyl_1"));
    }
 @Test
 public void testUsernamefalse() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=false;
        boolean actual=testMethod.checkUserName("kyle!!!!!!!");
        assertFalse(testMethod.checkUserName("kyle!!!!!!!"));
    }
  @Test
 public void testCheckPasswordComplexityTrue() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=true;
        boolean actual=testMethod.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(testMethod.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
 @Test
 public void testCheckPasswordComplexityfalse() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=false;
        boolean actual=testMethod.checkPasswordComplexity("Ch&&sec@ke99!");
        assertFalse(testMethod.checkPasswordComplexity("password"));
    }
  @Test
 public void testCheckCellPhoneTrue() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=true;
        boolean actual=testMethod.checkCellPhone("+27838968976");
        assertTrue(testMethod.checkCellPhone("+27838968976"));
    }
 @Test
 public void testCheckCellPhonefalse() 
    {
        RegistrationAndLogin testMethod=new RegistrationAndLogin();
         boolean expected=false;
        boolean actual=testMethod.checkCellPhone("08966553");
        assertFalse(testMethod.checkCellPhone("08966553"));
    }
    
}
