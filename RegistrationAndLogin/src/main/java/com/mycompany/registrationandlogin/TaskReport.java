/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Setlhabe Tsedintle
 */
public class TaskReport {
    //Arrays
    private static String[] sentMessages=new String[100];
    private static String[] disregardedMessages=new String[100];
    private static String[] storedMessages=new String[100];
    private static String[] messageHash=new String[100];
    private static String[] messageID=new String[100];
    private static String[] recipientID=new String[100];
    
    private static int sentCount=0;
    private static int storedCount=0;
    private static int disregardedCount=0;
    
    //Populating arrays by reading the Json file from SendingMessages class
    public static void readStoredMessages()
    {
        
    // Reset counters
    sentCount = 0;
    storedCount = 0;
    disregardedCount = 0;

    // Clear arrays
    sentMessages = new String[100];
    storedMessages = new String[100];
    disregardedMessages = new String[100];
    messageID = new String[100];
    messageHash = new String[100];
    recipientID = new String[100];
    
        try
        {
            BufferedReader reader =new BufferedReader(new FileReader("message.json"));

            String line;

            String messageId = "";
            String recipient = "";
            String message = "";
            String MessageHash = "";
            String flag="";

            while((line = reader.readLine()) != null)
            {
                line = line.trim();

                if(line.startsWith("\"MessageID\""))
                {
                    messageId = line.substring(
                            line.indexOf(":") + 1)
                            .replace("\"","")
                            .replace(",","")
                            .trim();
                }

                else if(line.startsWith("\"Recipient\""))
                {
                    recipient = line.substring(
                            line.indexOf(":") + 1)
                            .replace("\"","")
                            .replace(",","")
                            .trim();
                }

                else if(line.startsWith("\"Message\""))
                {
                    message = line.substring(
                            line.indexOf(":") + 1)
                            .replace("\"","")
                            .replace(",","")
                            .trim();
                }

                else if(line.startsWith("\"MessageHash\""))
                {
                    MessageHash = line.substring(
                            line.indexOf(":") + 1)
                            .replace("\"","")
                            .replace(",","")
                            .trim();

                }
                    else if(line.startsWith("\"Flag\""))
{
    flag = line.substring(
            line.indexOf(":") + 1)
            .replace("\"","")
            .replace(",","")
            .trim();

    if(flag.equals("Sent"))
    {
        sentMessages[sentCount] = message;

        recipientID[sentCount] = recipient;
        messageID[sentCount] = messageId;
        messageHash[sentCount] = MessageHash;

        sentCount++;
    }

    else if(flag.equals("Stored"))
    {
        storedMessages[storedCount] = message;

        recipientID[storedCount] = recipient;
        messageID[storedCount] = messageId;
        messageHash[storedCount] = MessageHash;

        storedCount++;
    }

    else if(flag.equals("Disregard"))
    {
        disregardedMessages[disregardedCount] = message;

        disregardedCount++;
    }
}
                }
            

            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Error reading JSON file.");
        }
            
    }
    public static void subtituteSentMessages(String message)
    {
        sentMessages[sentCount]=message;
        sentCount++;
    }
    
    public static void substituteDisregardedMessages(String message)
    {
        disregardedMessages[disregardedCount]=message;
        disregardedCount++;
    }
    
    public static void presentSentMessages()
    {
        for (int i=0;i<sentCount;i++)
        {
            System.out.println(sentMessages[i]);
        }
    }
    
    public static void presentDisregardedMessages()
    {
        for (int i=0;i<disregardedCount;i++)
        {
            System.out.println(disregardedMessages[i]);
        }
    } 
    
     public static void presentStoredMessages()
    {
        for (int i=0;i<storedCount;i++)
        {
            System.out.println("RecipientID"+recipientID[i]);
            System.out.println("Message"+storedMessages[i]);
        }
    }
    
     // This method searches through all stored messages
    // and returns the longest message
   public static String displayLongestMessage()
    {
    
         if(storedCount == 0)
    {
        return "No stored messages.";
    }
        String longestMessage = storedMessages[0];

    for(int i = 1; i < storedCount; i++)
    {
        if( storedMessages[i].length() > longestMessage.length())
        {
            longestMessage = storedMessages[i];
        }
    }

    return longestMessage;
   }
   
   // This method searches for a Message ID and displays the corresponding recipient and message.
  public static String searchMessageID(String id)
    {
    String result = "Message not found";

    for(int i = 0; i < sentCount; i++)
    {
        if(messageID[i] != null)
        {
            if(messageID[i].equals(id))
            {
                result = "Recipient: " + recipientID[i] + "\nMessage: " + sentMessages[i];
            }
        }
    }

    return result;
}

// This method searches for all messages sent to a particular recipient.
public static String searchMessages(String recipient)
{
    String result = "";
    boolean found = false;

    for(int i = 0; i < storedCount; i++)
    {
        if(recipientID[i] != null)
        {
            if(recipientID[i].equals(recipient))
            {
                result = result + "Message ID: " + messageID[i]+ "\nMessage: " + storedMessages[i] +"\n\n";
                found = true;
            }
        }
    }

    if(found == false)
    {
        result = "No messages found for this recipient.";
    }

    return result;
}
    
    
// This method searches for a message hash
// and deletes the corresponding message
public static String deleteMessage(String hash)
{
    String deletedMessage = "";
    boolean found = false;

    for(int i = 0; i < storedCount; i++)
    {
        if(messageHash[i].equals(hash))
        {
            deletedMessage = storedMessages[i];
            storedMessages[i] = "";
            recipientID[i] = "";
            messageID[i] = "";
            messageHash[i] = "";
            found = true;
            break;
        }
    }

    if(found)
    {
        return "Message deleted: " + deletedMessage;
    }
    else
    {
        return "Message not found.";
    }
}    
    
  // This method displays a report of all stored messages
public static String displayReport()
{
    String report = "";

    for(int i = 0; i < sentCount; i++)
    {
        report += "Message ID: " + messageID[i] + "\n";
        report += "Recipient: " + recipientID[i] + "\n";
        report += "Message Hash: " + messageHash[i] + "\n";
        report += "Message: " + sentMessages[i] + "\n\n";
        
    }

    return report;
}    
    
  // GETTERS

    public static String[] getStoredMessages()
    {
        return storedMessages;
    }

    public static String[] getRecipientID()
    {
        return recipientID;
    }

    public static String[] getMessageID()
    {
        return messageID;
    }

    public static String[] getMessageHash()
    {
        return messageHash;
    }  
    
    public static String[] getSentMessages()
{
    return sentMessages;
}
    
 public static String[] getDisregardedMessages()
{
    return disregardedMessages;
}   
    
 public static int getStoredCount()
{
    return storedCount;
}   
    
    
    
      
}
