/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class ContactTest {
    
    public ContactTest() {
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
     * Test of getFirstName method, of class Contact.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("Testing getFirstName:");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "Juliet";
        String result = contact.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Contact.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("Testing setFirstName");
        String firstName = "";
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setFirstName("MaryAnn");
    }

    /**
     * Test of getLastName method, of class Contact.
     */
    @Test
    public void testGetLastName() {
        System.out.println("Testing getLastName");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "Selebalo";
        String result = contact.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Contact.
     */
    @Test
    public void testSetLastName() {
        System.out.println("Testing setLastName");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setLastName("Achieng");
    }

    /**
     * Test of getTelephoneNo method, of class Contact.
     */
    @Test
    public void testGetTelephoneNo() {
        System.out.println("Testing getTelephoneNo");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "+2345412345";
        String result = contact.getTelephoneNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelephoneNo method, of class Contact.
     */
    @Test
    public void testSetTelephoneNo() {
        System.out.println("Testing setTelephoneNo");
        String telephoneNo = "+2344587349";
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setTelephoneNo(telephoneNo);
    }

    /**
     * Test of getEmail method, of class Contact.
     */
    @Test
    public void testGetEmail() {
        System.out.println("Testing getEmail");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "tseleb200@caledonian.ac.uk";
        String result = contact.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Contact.
     */
    @Test
    public void testSetEmail() {
        System.out.println("Testing setEmail");
        String email = "fingab200@caledonian.ac.uk";
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setEmail(email);
    }

    /**
     * Test of getDateCreated method, of class Contact.
     */
    @Test
    public void testGetDateCreated() {
        System.out.println("Testing getDateCreated");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        Calendar expResult = Calendar.getInstance();
        Calendar result = contact.getDateCreated();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateCreated method, of class Contact.
     */
    @Test
    public void testSetDateCreated() {
        System.out.println("Testing setDateCreated");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM");
	Calendar dateCreated = new GregorianCalendar(2018,6,28);
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setDateCreated(dateCreated);
    }

    /**
     * Test of getContactType method, of class Contact.
     */
    @Test
    public void testGetContactType() {
        System.out.println("Testing getContactType");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "Personal";
        String result = contact.getContactType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactType method, of class Contact.
     */
    @Test
    public void testSetContactType() {
        System.out.println("Testing setContactType");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.setContactType("Personal");
    }

    /**
     * Test of formatDateToString method, of class Contact.
     */
    @Test
    public void testFormatDateToString() {
        System.out.println("Testing formatDateToString");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        String expResult = "2018-07-19"; //needs to be manually changed to today's (the day  the test is being carried out) date
        String result = contact.formatDateToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class Contact.
     */
    @Test
    public void testDisplay() {
        System.out.println("Testing display");
        Contact contact = new Contact("Juliet", "Selebalo", "+2345412345", "tseleb200@caledonian.ac.uk","Personal");
        contact.display();
    }
    
}
