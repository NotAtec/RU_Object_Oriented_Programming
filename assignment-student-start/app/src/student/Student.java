/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Jeroen Brinkhorst and Floris Reuvers
 */
public class Student {
    private String firstName;
    private String lastName;
    private int stNumber;
    
    public Student (String fName, String lName, int sNum) {
        this.firstName = fName;
        this.lastName = lName;
        this.stNumber = sNum;
    }

    private void updateName(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    public void changeStudent(String fName, String lName, int Snum){
        if(Snum == stNumber){
            updateName(fName, lName);
        }
    }

    public String toString() {
        String result = firstName + " " + lastName + ", s" + String.valueOf(stNumber);
        return result;
    }
    
    public int getSnum(){
        return stNumber;
    }
    
}
