/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework;

/**
 * creates a contact node for the circular linked list (ContactList)
 * @author S1719043_Selebalo_Thakane
 */
public class Node implements IDisplayable{
    
    /**
     * data contained by the node is a contact
     */
    protected Contact data;

    /**
     * points to the next node
     */
    protected Node next,

    /**
     * points to the previous node
     */
    prev;
    
    static int noOfNodes = 0;
    
    /**
     * Creates a node and sets the value of the data field of the node to the given contact
     * @param data: a contact object
     */
    public Node(Contact data){
        this.data = data;
        this.next = null;
        this.prev = null;
        noOfNodes++;
    }
    
    /**
     * returns the contact in the data field of the selected node
     * @return data: a contact
     */
    public Contact getData(){
        return data;
    }

    /**
     * sets the value of the data field of the selected node to a given contact
     * @param contact: a contact object
     */
    public void setData(Contact contact){
        this.data = contact;
    }
    
    /**
     * returns the value of the prev field of the selected node
     * @return prev: the previous node
     */
    public Node getPrev(){
        return prev;
    }

    /**
     * sets the value of the prev field of the selected node to a given node
     * @param prevNode: the node object we want to set as previous of the current node
     */
    public void setPrev(Node prevNode){
        this.prev = prevNode;
    }
    
    /**
     * returns the value of the next field of the selected node
     * @return next: the next node
     */
    public Node getNext(){
        return next;
    }

    /**
     * sets the value of the next field of the selected node to a given node
     * @param nextNode: the node object we want to set as next of the current node
     */
    public void setNext(Node nextNode){
        this.next = nextNode;
    }
    
    /**
     * displays the value of the selected node's fields
     */
    @Override
    public void display(){
        System.out.println(this.getData());
        System.out.println(this.next);
        System.out.println(this.prev);
    }
}
