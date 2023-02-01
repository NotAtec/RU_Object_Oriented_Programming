package student;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        welcome();
    }
    
    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, how big do you want the group to be?");
        int size = scan.nextInt();
        //System.out.println("You just entered: " + size);
        Group group = new Group(size);


        for(int i = 0; i < size; i++) {
            System.out.println("Please enter a student");
            String fname = scan.next();
            String lname = scan.next();
            //System.out.println("I heard " + fname + " " + lname);
        }

    }
}
