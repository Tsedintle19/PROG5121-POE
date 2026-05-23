/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;

/**
 *
 * @author Setlhabe Tsedintle
 */
import java.util.Scanner;
public class RegistrationAndLogin {
    
    
     
    public static void main(String[] args) {
        //Declarations
        String Username="";
        String Password="";
        String CellPhoneNumber;
        String registerUser;
       
        
        Scanner myInput=new Scanner(System.in);
        boolean incorrectUsername=false;
        boolean incorrectPassword=false;
        boolean incorrectCellphoneNumber=false;
        System.out.println("Registration");
        //A while loop to allow the user to re-enter their details if they entered the wrong details
        while(incorrectUsername == false)
        {
        System.out.println(" Please enter Username");
        Username=myInput.nextLine();
    checkUserName(Username);
     if (checkUserName(Username) )
       {
         System.out.println("Username successfully captured.");
         incorrectUsername=true;
       }
       else
       {
           System.out.println("Username is not correctly formatted;please ensure your username contains an underscore and is no more than five characters long in length.");
       }
        
        }
       
     while(incorrectPassword == false)
        {
        
    System.out.println(" Please enter password");
         Password=myInput.nextLine();
       checkPasswordComplexity(Password)  ;
      
       if ( checkPasswordComplexity(Password) )
       {
         System.out.println("Password successfully captured.");
       incorrectPassword  =true;
       }
       else
       {
           System.out.println("Password is not correctly formatted;please ensure that the password contains at least eight characters,a capital letter,a number,and a special character. ");
       }
        
        }
       
     while(incorrectCellphoneNumber== false)
        {
        
       
       System.out.println("Please enter Cellphone");
        CellPhoneNumber=myInput.nextLine();
        
    checkCellPhone(CellPhoneNumber);
     if ( checkCellPhone(CellPhoneNumber) )
       {
         System.out.println("Cell phone number successfully added.");
       incorrectCellphoneNumber =true;
       }
       else
       {
           System.out.println(" Cell phone number incorrectly formatted or does not contain international code.");
       }
        
        }
          //Login
     String userfirstname="";
     String userlastname="";
   
     
     System.out.println("Login");
     System.out.println(" Please enter first name");
     userfirstname=myInput.nextLine();
     System.out.println("Please enter last name");
     userlastname=myInput.nextLine();
     System.out.println(" Please enter username to login");
     String loginUsername=myInput.nextLine();
     System.out.println(" Please enter password to login");
    String loginPassword=myInput.nextLine();
      
    registerUser( Username,Password);
   
   Login myObject=new Login(Username,Password);
   String message=myObject.returnLoginStatus(userfirstname,userlastname,loginUsername,loginPassword);
   System.out.println(message);
   
     System.out.println("Send Messages");
   //After the user has successfully loggedin the program should do the following
   String messageLength="";
   int option;
   int numMessages;
     String recipient="";
     //checks if the login details entered are correct
   if (myObject.loginUser(loginUsername,loginPassword))
   {
   System.out.println("Welcome to QuickChat.");
   //an object of the SendingMessages class is created.
   SendingMessages myObj=new SendingMessages("","");
   do{
   //Ask the user how many meesages they want to enter
   System.out.println("How many messages do you wish to enter.");
   numMessages=myInput.nextInt();
   myInput.nextLine();
   //This variable controls how many messages are sent.
     int counter = 0;
     
    while (counter < numMessages) {
         myObj =new SendingMessages(recipient,messageLength);
        System.out.println("Please enter recipient number:");
        recipient = myInput.nextLine();
        myObj.checkRecipientCell();
        System.out.println("Please enter the message you want to send.");
        messageLength  = myInput.nextLine();
        myObj.checkMessageID(); 
       
       //The program then checks the message length.
        if(messageLength.length()<=250)
        {
          System.out.println("Message sent.");
          
          counter++;
        }
        else
        {
            System.out.println("Please enter a message of less than 250 characters.");
        }
        
   }
     System.out.println("Choose one of the following features");
     String option1="Send Messages";
     String option2="Coming Soon";
     String option3="Quit";          
     System.out.println("1) " + option1 );
     System.out.println("2) " + option2);
     System.out.println("3) " + option3);
     option=Integer.parseInt(myInput.nextLine());
      
     switch(option)
{
    case 1:
        System.out.println(myObj.sentMessage(option));
           
        break;

    case 2:
        System.out.println("Coming Soon.");
        break;

    case 3:
        System.out.println("Quit");
        break;

    default:
        System.out.println("Invalid option");
}
  }
   while (option != 3);
 System.out.println("The total messages sent are: " + SendingMessages.returnTotalMessages());
           
     //Displsy the messages
      System.out.println("The Message ID of the user is: " + myObj.getMessageID());
       System.out.println("The recipient user number is: " + myObj.checkRecipientCell());
      System.out.println("The Message Hash of the user is: " + myObj.getMessageHash());
    
    }
    }
    
    public static boolean checkUserName(String UserName)
    {
        
    return UserName.contains("_")&& UserName.length()<=5;
   
    }
    public static boolean checkPasswordComplexity(String Password)
    {  char c; boolean containsNumber=false;boolean containsCapital=false;boolean containsSpecial=false;
    for(int i=0;i<Password.length();i++)
    
    {
        c=Password.charAt(i);
        if (Character.isDigit(c))
        {
            containsNumber=true;
        }
         if (Character.isUpperCase(c))
        {
             containsCapital=true;
        }
         if (!Character.isLetterOrDigit(c))
        {
            containsSpecial=true;
        }
    }
    
    return Password.length()>=8 &&  containsNumber && containsCapital && containsSpecial;
    }
    public static boolean checkCellPhone(String CellPhone)
        {
           return CellPhone.matches("\\+27\\d{9}");
        }
    public static String registerUser(String Username,String Password)
    {
       if(!checkUserName(Username))
    {
     return "Username is not correctly formatted;please ensure your username contains an underscore and is no more than five characters long in length.";
    }
    if (!checkPasswordComplexity(Password))
    {
       return "Password is not correctly formatted;please ensure that the password contains at least eight characters,a capital letter,a number,and a special character.";
    }
    return "The two above conditions have been met,and the user has been registered successfully";
    }
    
  
}

       


