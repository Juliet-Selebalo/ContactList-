/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

import static com.sun.javafx.util.Utils.stripQuotes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.log;

/**
 * a circular linked list of contact nodes: contains contacts
 * @author S1719043_Selebalo_Thakane
 */
public class ContactList implements IDisplayable{

    /**
     * keeps track of the starting node for the doubly linked list
     */
    protected Node start,

    /**
     * keeps track of the end node for the doubly linked list
     */
    end,

    /**
     * keeps track of the currently selected node for the doubly linked list
     */
    current;

    /**
     * keeps track of the number of nodes in the doubly linked list
     */
    protected int size; 
    
    /**
     * created an empty doubly linked contact list
     */
    public ContactList(){
        this.size = 0;
        this.start = null;
        this.end = null;
    }
    
    /**
     * adds a new contact to the end of the contact list
     * @param contact - contact object that we want to add to the contact list
     */
    public void insertContact (Contact contact){
        Node node = new Node(contact);
        
        if (isEmpty()){
            this.start = node;
            this.end = start;
            this.start.setNext(null);
            this.start.setPrev(null);   
        }
        else if(this.size==1){
            current = node;
            start.next = current;
            current.prev = start;
            current.next = start;
            end = current;
            start.prev = end;
        }
        else{
            current = node;
            end.next = current;
            current.prev = end;
            current.next  = start;
            end = current;     
            start.prev = end;
        }
        this.size++;
    }
    
    /**
     * adds a new contact to the given position of the contact list
     * @param contact - contact object that we want to add to the contact list
     * @param pos -  the position in the contact list where we want to insert the contact
     */
    public void insertContactAtPosition(Contact contact, int pos){
       
        if((pos==0 && size==0) || (pos>0 && size==0)){
            System.out.println("Sorry, the list is empty. We can only insert at the beginning.");
            insertContact(contact);
        }
        else if(pos==0 && size>0){
            Contact emptyContact = null;
            insertContact(emptyContact);
            Node node = new Node(contact);
            
            current = node;
            current.next = start;
            current.prev = end;
            start.prev = current;
            start = current;
        }
        else if(pos>0 && pos>size){
            System.out.println("Sorry, the position given is greater than the size of the contactList. The contact has been inserted at the end.");
            insertContact(contact);  
        }
        else if(pos>0 && pos<size){
            Contact emptyContact = null;
            insertContact(emptyContact);
            Node node = new Node(contact);
            current = start;
            
            for(int i=0; i<this.size; i++){   
                
                if(pos==i){
                    Node temp = current.getPrev();
                    temp.next = node;
                    node.prev = current.prev;
                    node.next = current;
                    current.prev = node;  
                }
                else{
                current = current.next;
                }
            }
        }
        else if(pos==size){
            insertContact(contact);
        }
        size++;
    }
    
    /**
     * reads contacts from a file and adds them to the contact list
     * @param filename - the name of the file we are loading the contacts from
     * @throws IOException
     * @throws ParseException
     */
    public void insertContactsFromFile(String filename) throws IOException, ParseException{
        
        //ContactList contactList = new ContactList();
        char delimeter = ',';

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { 
            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(delimeter));        
                String firstName = stripQuotes(temp[0]);
                String lastName = stripQuotes(temp[1]);
                String telephoneNo = stripQuotes(temp[2]);
                String email = stripQuotes(temp[3]);
                String contactType = stripQuotes(temp[4]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String creationDateStr = stripQuotes(temp[5]);
                    Date date;
                    Calendar dateCreated = null;
                    try {
                        date = dateFormat.parse(creationDateStr);
                        dateCreated = Calendar.getInstance();
                        dateCreated.setTime(date);                
                    } catch (ParseException ex) {
                        Logger.getLogger(ContactList.class.getName()).log(Level.SEVERE, null, ex);
                }
                Contact contact = new Contact(firstName, lastName, telephoneNo, email, contactType, dateCreated);
                insertContact(contact);         
                line = br.readLine();                
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ContactList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * removes a contact with the matching telephone no. from the contact list
     * @param telephoneNo - the telephone number of the contact that is to be removed from the list
     */
    public void removeContact(String telephoneNo){
        String telNo = telephoneNo; 
        
        try{
            Node removedContact;
            removedContact=this.searchByTelephoneNo(telNo);
            
            if(removedContact.data == start.getData()){
                if(size==1){
                    start = null;
                    end = null;
                }
                else{
                this.start = start.getNext();
                this.start.setPrev(end);
                this.end.setNext(start);
                }
                System.out.println("Contact removed successfully");
            }
            else if(removedContact.data == end.getData()){
                end = end.getPrev();
                end.setNext(start);
                start.setPrev(end);
                System.out.println("Contact removed successfully");
            }
            else {
                removedContact.getPrev().setNext(removedContact.getNext());
                removedContact.getNext().setPrev(removedContact.getPrev());
                System.out.println("Contact removed successfully");
            }
            size--;
            
        }catch (NullPointerException nullPointer)
            {
            log(nullPointer, System.out);
            System.out.println("The contact you are trying to remove is not on the list.");
            }
        
    }
        
    /**
     * searches the contact list to find the contact with the given telephone no.
     * @param telephoneNo -  the telephone number of the contact we are looking for
     * @return contact (a contact matching the given telephone number)
     */
    public Node searchByTelephoneNo(String telephoneNo){
        current = start;
        Contact foundContact;
        Node foundContactNode = null;
        boolean isFound = false;
        
        try{
        do{
            if(current.getData().getTelephoneNo().equals(telephoneNo)){
                isFound = true;
                foundContact = current.getData();
                foundContactNode = current;
                System.out.println("The telephoneNo "+telephoneNo+ " belongs to "+foundContact.getFirstName()+ " " +foundContact.getLastName());
            }
            else{
                current=current.next;
            }
        }while((current!=start)&&(isFound!=true));
        
        if(isFound==false){
                    System.out.println("The contact you are looking for has not been found.");
                }
        
        }catch (NullPointerException nullPointer)
            {
            log(nullPointer, System.out);
            System.out.println("The contact you are looking for has not been found.");
            }
        return foundContactNode;
    }
    
    /**
     * searches the contact list to find the contact with the given name and surname.
     * @param firstName - the first name of the contact we are looking for
     * @param lastName - the last name of the contact we are looking for
     * @return contact (a contact with the given names)
     */
    public Contact searchByName(String firstName, String lastName){
       
        current=start;
        Contact yourContact = null;
        boolean isFound = false;
        
            try{
                do{
                    if((current.getData().getFirstName().equals(firstName))&&(current.getData().getLastName().equals(lastName))){
                        yourContact = current.getData();
                        isFound = true;
                        System.out.println("The contact details of "+firstName+" "+lastName+" are:");
                        System.out.println("TelephoneNo: "+yourContact.getTelephoneNo()+", Email "+yourContact.getEmail()+", Contact Type: "+yourContact.getContactType()+", Created on: "+yourContact.formatDateToString());
                    }
                else{
                        current=current.next;
                    }
                }while((current!=start)&&(isFound!=true));
                 
                if(isFound==false){
                    System.out.println("The contact you are looking for has not been found.");
                }  
                
            }catch (NullPointerException nullPointer)
            {
            log(nullPointer, System.out);
            System.out.println("The contact you are looking for has not been found.");
            }
                 
        return yourContact;
    }
    
    /**
     * checks if the contact list is empty
     * @return true/false 
     */
    public boolean isEmpty(){
        return this.start == null;
    }

    /**
     * checks the number of elements in the list
     * @return size
     */
    public int checkSize(){
        return this.size;
    }

    /**
     * displays all the contacts in the contact list (if any)
     */
    @Override
    public void display() {
        current=start;
        int count = 1;
        try{
            do{
            System.out.println("Contact "+count);
            System.out.println(current.getData().getFirstName()+ " , "+current.getData().getLastName()+" , "+current.getData().getTelephoneNo()+" , "+current.getData().getEmail()+" , "+current.getData().getContactType()+" , "+current.getData().formatDateToString());
            current = current.next;
            count++;
            }while((start!=null)&&(current!=start));
        }catch (NullPointerException nullPointer)
            {
            log(nullPointer, System.out);
            System.out.println("The list is empty. There are no contacts to display.");
            }
    }
    
}
