/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Setlhabe Tsedintle
 */
public class TaskReportTest {
    
    public TaskReportTest() {
    }
    
    @BeforeAll
    public static void setUpClass() 
    {
        TaskReport.readStoredMessages();
    }

    @Test
    public void testSubtituteSentMessages() //
    {
         TaskReport.readStoredMessages();
        String[] sentMessages=TaskReport.getSentMessages();
        assertEquals("Did you get the cake?",sentMessages[1]);
        assertEquals("It is dinner time.",sentMessages[4]);
    }

    @Test
    public void testDisplayLongestMessage() //
    {
        TaskReport.readStoredMessages();
        String expected="Where are you?You are late! I have asked you to be on time.";
        String actual=TaskReport.displayLongestMessage();
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchMessageID() //
    {
        String expected= "Recipient: 0838884567\nMessage: It is dinner time.";
        String actual=TaskReport.searchMessageID("4180414314");
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchMessages() //
    {
        TaskReport.readStoredMessages();
        String testMethod =TaskReport.searchMessages("+27838884567");
        System.out.println(testMethod);
    }

    @Test
    public void testDeleteMessage() 
    {
        TaskReport.readStoredMessages();
        String expected ="Message deleted: Where are you?You are late! I have asked you to be on time.";
        String actual =TaskReport.deleteMessage("27:1:WHERETIME.");
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayReport() 
    {
        TaskReport.readStoredMessages();
        String actual = TaskReport.displayReport();
        System.out.println("REPORT OUTPUT:");
        System.out.println(actual);
        assertEquals(true,actual.contains("Did you get the cake?"));
    }
    
}
