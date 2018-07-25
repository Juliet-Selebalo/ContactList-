/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * A user contact
 * @author S1719043_Selebalo_Thakane
 */
public class Contact implements IDisplayable{
    
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private Calendar dateCreated;
    private String contactType;
    
    /**
     * Creates a contact instance/object
     * @param firstName - first name of the person whose contact is being created
     * @param surname - last name of the person whose contact is being created
     * @param telephoneNo - telephone number of the person whose contact is being created
     * @param email - email address of the person whose contact is being created
     * @param contactType - The date when the contact was created
     */
    public Contact(String firstName, String surname, String telephoneNo, String email, String contactType){
        this.firstName = firstName;
        this.lastName = surname;
        this.telephoneNumber = telephoneNo;
        this.email = email;
        this.dateCreated = Calendar.getInstance();
        this.contactType = contactType;
        
        if("Personal".equals(contactType) || "Business".equals(contactType)){
            contactType = contactType;
        }
        else{
            System.out.println("Sorry, we could not create the contact. Please confirm that contact type is either Business or Personal.");
        }
        
    }
    
    /**
     * Creates a contact instance/object
     * @param firstName - first name of the person whose contact is being created
     * @param surname - last name of the person whose contact is being created
     * @param telephoneNo - telephone number of the person whose contact is being created
     * @param email - email address of the person whose contact is being created
     * @param contactType - Type of contact being created (Can only be Personal or Business)
     * @param creationDate - The date when the contact was created
     */
    public Contact(String firstName, String surname, String telephoneNo, String email, String contactType, Calendar creationDate){
        this.firstName = firstName;
        this.lastName = surname;
        this.telephoneNumber = telephoneNo;
        this.email = email;
        this.dateCreated = creationDate;
        this.contactType = contactType;
    }
    
    /**
     * returns the value of the firstName field for the selected contact
     * @return firstName
     */
    public String getFirstName(){
        return this.firstName;
    }
    
    /**
     * sets the value of the firstName field for the selected contact
     * @param firstName - first name of the person who the contact belongs to
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    /**
     *returns the last name of the selected contact
     * @return lastName
     */
    public String getLastName(){
        return this.lastName;
    }
    
    /**
     *sets the last name of the selected contact
     * @param lastName - last name of the person who the contact belongs to
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    /**
     *returns the telephone number of the selected contact
     * @return telephoneNumber
     */
    public String getTelephoneNo(){
        return this.telephoneNumber;
    }
    
    /**
     *sets the value of the TelephoneNo field for the selected contact
     * @param telephoneNo - Telephone number of the person who the contact belongs to
     */
    public void setTelephoneNo(String telephoneNo){
        this.telephoneNumber = telephoneNo;
    }
    
    /**
     *returns the value of the email field for the selected contact
     * @return email
     */
    public String getEmail(){
        return this.email;
    }
    
    /**
     *sets the value of the email field of the selected contact
     * @param email - Email address of the person who the contact belongs to
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     *returns the value of the dateCreated field for the selected contact
     * @return dateCreated
     */
    public Calendar getDateCreated(){
        return this.dateCreated;
    }
    
    /**
     * sets the value of the dateCreated field for the selected contact
     * @param dateCreated - The date when the contact was created
     */
    public void setDateCreated(Calendar dateCreated){
        this.dateCreated = dateCreated;
    }
    
    /**
     * returns the value of the contactType field for the selected contact
     * @return contactType
     */
    public String getContactType(){
        return this.contactType;
    }
    
    /**
     * sets the value of the contactType field for the selected contact
     * @param contactType - The type of contact this is (Can only be Personal/Business)
     */
    public void setContactType(String contactType){
        
            if(null == contactType) {
                System.out.println("You have entered the wrong contact type. NOTE: Contact Type can only be either Personal or business.");
        } else switch (contactType) {
            case "Personal":
            case "personal":
                this.contactType = contactType;
                break;
            case "Business":
            case "business":
                this.contactType = contactType;
                break;
            default:
                System.out.println("You have entered the wrong contact type. NOTE: Contact Type can only be either Personal or business.");
                break;
        }  
    }
    
    /**
     * Converts the value of dateCreated field of a contact to a string
     * @return dateString 
     */
    protected String formatDateToString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.dateCreated.getTime());
        return dateString;
    }
    
/*@Override
public String toString() {
        return "\nFirst Name: " + this.getFirstName() +
                " Last Name: " + this.getLastName() +                               
                " Telephone No: " + this.getTelephoneNo() + 
                " Email: " + this.getEmail() +
                " Contact Type: " + this.getContactType() + 
                "Date Created: "+ this.formatDateToString() + "\n";   
    }*/
    
    /**
     *
     */
    @Override
public void display(){
        System.out.println("First name: "+this.firstName);
        System.out.println("Last name: "+this.lastName);
        System.out.println("Telephone No.: "+this.telephoneNumber);
        System.out.println("Email: "+this.email);
        System.out.println("Contact Type: "+this.contactType);
        System.out.println("Date Created: "+this.formatDateToString());
    }
}
