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
            int Snum = scan.nextInt();
            String fName = scan.next();
            String lName = scan.next();
            //System.out.println("I heard " + fname + " " + lname);
            
            //first make student with constructer
            Student studentToAdd = new Student(fName, lName, Snum);
            //add student to group
            group.addStudent(studentToAdd, i);
        }

        //print all students from the group
        System.out.println("The group now contains:");
        group.printGroup();
    }
}
