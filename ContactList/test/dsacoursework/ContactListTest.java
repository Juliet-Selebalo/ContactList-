/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

import java.io.IOException;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class ContactListTest {
    
    public ContactListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertContact method, of class ContactList.
     */
    @Test
    public void testInsertContact() {
        System.out.println("Testing insertContact");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        ContactList contactList = new ContactList();
        contactList.insertContact(contact);
    }
    
        /**
     * Test of insertContact method, of class ContactList.
     */
    @Test
    public void testInsertContactAtPosition() {
        System.out.println("Testing insertContactAtPsition");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        int pos = 3;
        ContactList contactList = new ContactList();
        contactList.insertContactAtPosition(contact,pos);
    }

    /**
     * Test of insertContactsFromFile method, of class ContactList.
     */
    @Test
    public void testInsertContactsFromFile() throws Exception {
        System.out.println("Testing insertContactsFromFile");
        String filename = "contacts.txt";
        ContactList contactList = new ContactList();
        contactList.insertContactsFromFile(filename);
    }

    /**
     * Test of removeContact method, of class ContactList.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("Testing removeContact");
        String telephoneNo = "+23058123456";
        ContactList contactList = new ContactList();
        contactList.removeContact(telephoneNo);
    }

    /**
     * Test of searchByTelephoneNo method, of class ContactList.
     */
    @Test
    public void testSearchByTelephoneNo() {
        System.out.println("searchByTelephoneNo");
        String telephoneNo = "+230123456";
        ContactList contactList = new ContactList();
        Node expResult = null;
        Node result = contactList.searchByTelephoneNo(telephoneNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByName method, of class ContactList.
     */
    @Test
    public void testSearchByName() throws IOException, ParseException {
        System.out.println("searchByName");
        String firstName = "Juliet";
        String lastName = "Selebalo";
        ContactList contactList = new ContactList();
        contactList.insertContactsFromFile("contacts.txt");
        Contact contact = contactList.searchByName("Juliet", "Selebalo");
        Contact expResult = contact;
        Contact result = contactList.searchByName(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class ContactList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty");
        ContactList contactList = new ContactList();
        boolean expResult = true;
        boolean result = contactList.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkSize method, of class ContactList.
     */
    @Test
    public void testCheckSize() {
        System.out.println("Testing checkSize");
        ContactList contactList = new ContactList();
        int expResult = 0;
        int result = contactList.checkSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class ContactList.
     */
    @Test
    public void testDisplay() {
        System.out.println("Testing display");
        ContactList contactList = new ContactList();
        contactList.display();
    }
    
}
