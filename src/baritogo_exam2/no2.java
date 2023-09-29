/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baritogo_exam2;

/**
 *
 * @author Tovi Myer
 */
import java.util.Scanner;

public class no2{
    private class DoubleNode {
        DoubleNode next;
        String data;  // Change data type to String
        DoubleNode prev;
    }

    private int size;
    private DoubleNode head;

    private DoubleNode createNewNode(String value) throws Exception {
        DoubleNode doubleNewNode = new DoubleNode();
        doubleNewNode.data = value;
        doubleNewNode.prev = null;
        doubleNewNode.next = null;
        return doubleNewNode;
    }

    public DoubleNode getNodeAt(int index) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        }
        if (index < 0 || index >= size) {
            throw new Exception("Invalid Index");
        }
        DoubleNode temporary = head;

        for (int i = 0; i < index; i++) {
            temporary = temporary.next;
        }
        return temporary;
    }

    public void insertion(String value, int position) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Invalid position");
        } else if (position == 0) {
            insertAtBeginning(value);
        } else if (position == size) {
            InsertAtEnding(value);
        } else {
            DoubleNode node = createNewNode(value);
            DoubleNode prevNode = getNodeAt(position - 1);
            DoubleNode nextNode = prevNode.next;

            prevNode.next = node;
            node.prev = prevNode;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }
    }

    public void insertAtBeginning(String value) throws Exception {
        DoubleNode doubleNewNode = createNewNode(value);

        if (head == null) {
            head = doubleNewNode;
        } else {
            doubleNewNode.next = head;
            head.prev = doubleNewNode;
            head = doubleNewNode;
        }
        size++;
    }

    public void InsertAtEnding(String value) throws Exception {
        DoubleNode doubleNewNode = createNewNode(value);

        if (head == null) {
            head = doubleNewNode;
        } else {
            DoubleNode temporary = head;
            while (temporary.next != null) {
                temporary = temporary.next;
            }
            temporary.next = doubleNewNode;
            doubleNewNode.prev = temporary;
        }
        size++;
    }

    public void deletion(int position) throws Exception {
        if (position < 0 || position == size) {
            throw new Exception("Invalid index");
        }
        if (size == 0) {
            throw new Exception("List is empty");
        }
        String deletedData = null;
        if (position == 0) {
            deleteBeginning();
        } else if (position == size - 1) {
            deleteAtEnd();
        } else {
            DoubleNode prevNode = getNodeAt(position - 1);
            DoubleNode nextNode = getNodeAt(position + 1);
            deletedData = prevNode.next.data;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        System.out.println("Deleted data: " + deletedData);
    }

    public void deleteBeginning() throws Exception {
        if (head == null) {
            return;
        }
        String deletedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        System.out.println("Deleted data: " + deletedData);
    }

    public void deleteAtEnd() throws Exception {
        if (head == null) {
            return;
        }
        String deletedData;
        if (head.next == null) {
            deletedData = head.data;
            head = null;
        } else {
            DoubleNode temporary = head;
            while (temporary.next != null) {
                temporary = temporary.next;
            }
            deletedData = temporary.data;
            temporary.prev.next = null;
        }
        System.out.println("Deleted data: " + deletedData);
        size--;
    }

    public void searchNode(String value) {
        int i = 1;
        boolean flag = false;
        DoubleNode current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            if (current.data.equalsIgnoreCase(value)) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if (flag)
            System.out.println("Naa Dong: ");
        else
            System.out.println("Wala Dong");
    }

    private void display() throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        } else {
            DoubleNode temporary = head;
            while (temporary != null) {
                System.out.print(temporary.data + " <-> ");
                temporary = temporary.next;
            }
            System.out.println("null\n");
        }
    }
    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        no2 list = new no2();
        boolean hiee = true;

        list.insertAtBeginning("Fita, Pride, Powder, Canola, oil, Nescafe, Black Coffee, Ariel Powder, Rebisco, Steelwool, Head and Shoulder, Nova, Tanduay, Bearbrand, Nature Sring Mineral Water 80z., Coke 1ltr., Sprite Kasalo, Royal 1ltr., Sugar"+ "");
        list.display();
        
        while (hiee) {
            System.out.println("1. unsa imo dong?");
            System.out.println("2. edi dont");
            int choice = s.nextInt();
            int position;
            String value;

            switch (choice) {
                case 1:
                    System.out.println("unsa imo: ");
                    String search = s.next();
                    list.searchNode(search);                  
                    break;
                case 2:
                    hiee = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}