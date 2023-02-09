/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Gebruiker
 */
public class Group {
    private Student[] all;
    private int numStud;
    
    public Group(int amount) {
        all = new Student[amount];
        numStud = 0;
    }
    
    public void addStudent(Student name) {
        if(numStud < all.length) {
            all[numStud] = name;
            numStud++;
        }
    }

    //this function returns the index of the array of all students where the student number is the same as the given student number
    public int findStudent(int Snum){
        for(int i = 0; i < all.length; i++){
            if(all[i].getSnum() == Snum){
                return i;
            }
        }
        return -1;
    }

    public void updateNameOfsNum(String fName, String lName, int sNum) {
        int index = findStudent(sNum);
        if(index >= 0){ //if index was -1, the student with sNum does not exist in the group
            all[index].changeStudent(fName, lName, sNum);
        }
    }

    public void printGroup(){
        for(int i = 0; i < numStud; i++){
            System.out.println(all[i].toString());
        }
    }
}
