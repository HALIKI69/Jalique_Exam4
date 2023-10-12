

package jalique_exam4;

import java.util.Scanner;


public class Jalique_Exam4 {
private class StackNode {
        String data;
        int quanti;
        StackNode next;
    }
     private StackNode top;
    private int size;
    public StackNode createNewNode(String element, int quantity) throws Exception {
        StackNode node = new StackNode();
        if (node == null) {
            throw new Exception("Memory is full");
        } else {
            node.data = element;
            node.quanti = quantity;
            node.next = null;
            return node;
        }
    }

    public void push(String element, int quantity) throws Exception {
        StackNode node = createNewNode(element, quantity);
        if (size == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }

   
    public String pop(String element, int quantity) throws Exception {
        if (size == 0) {
            throw new Exception("Inventory is empty");
        }
        String temporary = peek();
        top = top.next;
        size--;
        return temporary;
    }

    public String  peek() throws Exception {
        if (size == 0) {
            throw new Exception("Inventory is empty");
        }
        return top.data;
        
    }

    public void display() throws Exception {
        if (size == 0) {
            throw new Exception("Inventory is empty");
        }
        StackNode temporary = top;

        System.out.print("Inventory: \n ");
        while (temporary != null) {
            System.out.print(temporary.data + "-->" + "("+temporary.quanti +" pieces)"+" \n ");
            temporary = temporary.next;
        }
        
    }
    public static void main(String[] args) throws Exception {
        Jalique_Exam4 stl = new Jalique_Exam4();
        Scanner s = new Scanner(System.in);
        String element;
        int quantity;
        boolean start = true;

        while (start) {
            System.out.println("MENU");
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Display Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter item name:");
                    element = s.next();
                    System.out.println("Enter quantity:");
                   quantity = s.nextInt();
                    stl.push(element, quantity);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter item name:");
                    element = s.next();
                    System.out.println("Enter quantity:");
                    quantity = s.nextInt();
                    
                  System.out.println(stl.pop(element, quantity)+ " is sold.");
                    System.out.println();
                    break;
                case 3:
                    stl.display();
                    System.out.println();
                    break;
                case 4:
                    start = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    

    }
    
}
