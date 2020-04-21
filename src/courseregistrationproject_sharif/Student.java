/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maxamad13
 */
//<editor-fold defaultstate="collapsed" desc="class Student">
class Student extends User implements Serializable
{
    public static Scanner kb =new Scanner(System.in);
    private ArrayList<String> cALStudentR; //hold all courses' ids the student registered
    public Student(String firstName, String lastName)
    {
        super(firstName, lastName);
        cALStudentR = new ArrayList<>();
    }
    
    
    @Override
    public void ViewAllCourses(ArrayList<Course> cAL) //from super class User
    {
      
    }
    public ArrayList<String> getCAlStudentR()
    {
        return cALStudentR;
    }
    public void AddCourseId(String cId)
    {
        cALStudentR.add(cId);
    }
            
    public static int ShowMenuStudent(String name)
    {
        System.out.println("\n-------------- Course Management for " +name + "--------------");
        System.out.println("    1 View all courses");
        System.out.println("    2 View all course that are not FULL");
        System.out.println("    3 Register in a course");
        System.out.println("    4 Withdraw");
        System.out.println("    5 View all course that the current student registered in"); 
        System.out.println("------------------------------------------------------------\n    type 0 to Main Menu");
        System.out.print("    Enter your choice: ");
        return kb.nextInt();            
    }
}