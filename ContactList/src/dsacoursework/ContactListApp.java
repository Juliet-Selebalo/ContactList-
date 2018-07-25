/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
/**
 * Acts as an interface to the ContactList, allows the user to perform various actions
 * @author S1719043_Selebalo_Thakane
 */
public class ContactListApp {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static void main(String[] args)throws IOException, ParseException {
                ContactListApp contactListApp = new ContactListApp();
                contactListApp.run();
    }
    
    /**
     * @throws java.io.IOException
     * @throws java.text.ParseException
     * The interface to the application. Allows you to perform the different tasks on the application by choosing from the menu
     */
    public void run() throws IOException, ParseException{
                ContactList contactList = new ContactList();
                boolean finished = false;
        do{ 
        System.out.println("Please select the action you'd like to perform: (Type only the letter)");
        System.out.println("A. Create contact");
        System.out.println("B. Insert contacts from file");
        System.out.println("C. Remove contact");
        System.out.println("D. Search for contact by telephone no.");
        System.out.println("E. Search for contact by name");
        System.out.println("F. Display contacts");
        System.out.println("H. Help");
        System.out.println("Q. Quit");
        System.out.println("");

      Scanner scan = new Scanner(System.in); 
      char choice = scan.next().charAt(0);
      
      switch(choice){
          case 'A':
          case 'a':{
              Scanner scanner = new Scanner(System.in); 
              System.out.println("Please enter the first name of the contact:");
              String firstName = scanner.nextLine();
              System.out.println("Please enter the last name of the contact:");
              String lastName = scanner.nextLine();
              System.out.println("Please enter the telephoneNo. of the contact:");
              String telephoneNo = scanner.nextLine();
              System.out.println("Please enter the email of the contact:");
              String email = scanner.nextLine();
              System.out.println("Please enter the type of the contact (NOTE: Contact Type can only be Personal/Business):");
              String contactType = scanner.nextLine();
              
              boolean contactAdded = false;
              do{
              if((contactType.equals("Personal"))||(contactType.equals("Business"))){
                  Contact contact;
                  contact = new Contact(firstName, lastName, telephoneNo, email, contactType);
                  contactAdded = true;
                  System.out.println("Contact created successfully.");
                  System.out.println("");
              }
              else{
                System.out.println("Invalid account type.");
                System.out.println("Please enter the type of the contact (NOTE: Contact Type can only be Personal/Business):");
                contactType = scanner.nextLine(); 
                System.out.println("");
              }
              }while(contactAdded == false);
              break;
          }
          
          case 'B':
          case 'b':{
              Scanner scanner = new Scanner(System.in); 
              System.out.println("Please type the filename:");
              String fileName = scanner.nextLine();
              contactList.insertContactsFromFile(fileName);
              System.out.println("Contacts loaded successfully.");
              System.out.println("");
              break;
          }
          case 'C':
          case 'c':{
              Scanner scanner = new Scanner(System.in); 
              System.out.println("Please type the telephone no. of the contact you would like to remove:");
              String telephoneNo = scanner.nextLine();
              contactList.removeContact(telephoneNo);
              System.out.println("");
              break;
          }
          case 'D':
          case 'd':{
              Scanner scanner = new Scanner(System.in); 
              System.out.println("Please type the telephone No you would like to search for:");
              String telephoneNo = scanner.nextLine();
              contactList.searchByTelephoneNo(telephoneNo);
              System.out.println("");
              break;
              }
              
          case 'E':
          case 'e':{
              Scanner scanner = new Scanner(System.in); 
              System.out.println("Please type the first name of the contact you would like to search for:");
              String firstName = scanner.nextLine();
              System.out.println("Please type the last name of the contact you would like to search for:");
              String lastName = scanner.nextLine();
              contactList.searchByName(firstName, lastName);
              System.out.println("");
              break;
          }
          case 'F':
          case 'f':{
              contactList.display();
              System.out.println("");
              break;
          }
          case 'H':
          case 'h':{
              System.out.println("Hi there, you seem stuck: Here's what the different options do:");
              System.out.println("Create contact: allows you to create a new contact.");
              System.out.println("Insert contacts from file: lets you load contacts from a given file.");
              System.out.println("Remove contact: lets you remove a contact from the contact list by giving the telephone number of the contact");
              System.out.println("Search for contact by telephone no: lets search the contact list for a contact matching the given telephone number.");
              System.out.println("Search by name: lets you search for a contact by giving the first and last name of the contact.");
              System.out.println("Display contacts: lets you display all contacts in the contact list.");
              System.out.println("Quit: let's you exit the application.");
              System.out.println("NOTE: TYPE THE LETTER OF THE ACTION YOU WANT TO PERFORM AND NOT THE TEXT");
              System.out.println("");
              break;
          }
          case 'Q':
          case 'q':{
              finished = true;
              break;
          }
      }
        }while(!finished);
    }
    
}
