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

        //asking for all students and adding them in the group
        for(int i = 0; i < size; i++) {
            System.out.println("Please enter a student");
            int sNum = scan.nextInt();
            String fName = scan.next();
            String lName = scan.next();            
            //first make student with constructer
            Student studentToAdd = new Student(fName, lName, sNum);
            //add student to group
            group.addStudent(studentToAdd);
        }

        //print all students from the group
        System.out.println("The group now contains:");
        group.printGroup();

        //keep asking if the user wants to change a name
        System.out.println("Student number and new given/family name? ");
        int sNum = scan.nextInt();
        String fName = null;
        String lName = null; 
        if(sNum >= 0) {
            fName = scan.next();
            lName = scan.next(); 
        }

        while(sNum >= 0){
            group.updateNameOfsNum(fName, lName, sNum); 

            System.out.println("The group now contains:");
            group.printGroup();
            
            System.out.println("Student number and new given/family name? ");
            sNum = scan.nextInt();
            if(sNum >= 0) {
                fName = scan.next();
                lName = scan.next(); 
            }
        }
    }
}
