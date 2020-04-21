
package courseregistrationproject_sharif;

import static courseregistrationproject_sharif.Student.kb;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class CourseRegistrationProject_Sharif implements Serializable
{

    public static void main(String[] args) throws Exception
    {
        ArrayList<Student> sAL = new ArrayList<>();//All students-
        ArrayList<Course> cAL = new ArrayList<>(); //All courses 
        ToolkitSharif.PopulateCourseArrayList(cAL); //Req 08, Req 12 (deserialize)
        ToolkitSharif.PopulateStudentArrayList(sAL); //Req 12 (deserialize)
        
  
        System.out.println("------ Welcome to Course Registration System ------\n");        
        int userType = ToolkitSharif.Get1_2_N1("------ Main Menu ------\n"
                + "   1 Administrator\n   2 Student\n   -1 to quit: ");
        
        while(userType != -1)
        {
            try
            {
                if (userType == 1)
                System.out.println("\nYou are an administrator.");
            else
                System.out.println("\nYou are a student.");
            
            System.out.print( "   Please enter your id: ");
            String id = kb.nextLine();
            System.out.print("   Please enter your password: ");
            String pw = kb.nextLine();

            if (userType == 1)
            {
                if (id.equals("Admin") && pw.equals("Admin001"))
                {
                   //1 Admin user = new Admin();
                    MenuAdmin(cAL, sAL);
                }
                else
                    System.out.println("Admin: Wrong id or password.");
            }
            else //user type is Student, check student's id and pw by looking up ArrayList sAL 
            {   //and returns a Student object which has the id and pw 
                Student user = ToolkitSharif.getStudent(id.toLowerCase(), pw, sAL);
               // sAL.get(4).AddCourseId("6633"); 
                if (user != null)
                    MenuStudent(cAL, sAL, user);
                    //System.out.println("asdf");
                else
                   System.out.println("Student: Wrong id or password. Hint password add 001"); 
            }
            userType = ToolkitSharif.Get1_2_N1("------ Main Menu ------\n   1 Administrator\n   2 Student\n  -1 to quit: ");
            } catch (Exception e)
            {
                System.out.println("OOOPS  something went wrong. Please re-enter Id and password");
               
               
            }
        }
        
        //Req 12: Serializing cAL and sAL (ArrayLists for courses and students)
        ToolkitSharif.SerializationcAL(cAL);
        ToolkitSharif.SerializaionsAL(sAL);
        System.out.println("\nThank you for using. Bye...");
    }
    
    
    public static void MenuStudent(ArrayList<Course> cAL, ArrayList<Student> sAL, Student user)
    {        
     // String name = sAL.get(1).firstName;
        CurrentStudent currStudent = new CurrentStudent(user.userName, user.password);
        
      
       
            int choice;
        String monthString;
        do 
        {
             choice = Student.ShowMenuStudent(user.firstName + " " + user.lastName);
            switch (choice) 
            {
               case 1:  currStudent.ViewAllCourses(cAL);  
                        System.out.print("Please enter any key to go back to main menue");
                          kb.nextLine();
                          kb.nextLine();
                        break;
               case 2:  currStudent.ViewCoursesNotFull(cAL);
                        break;
               case 3:  currStudent.RegisterCourse(cAL, sAL);
                        break;
               case 4:  currStudent.WithdrawCourse(cAL, sAL);
                        break;
               case 5:  currStudent.CurrentlyRegisteredCourse(cAL, sAL);
                        break;           
               default: System.out.println("Please Choose the correct option");
                        break;

           }            
            
        } while (choice != 0);
     
       
       
    }
    
    public static void MenuAdmin(ArrayList<Course> cAL, ArrayList<Student> sAL)
    {      
               
        Admin admin = new Admin();      
      
        int choice;// = Admin.ShowMenuAdmin();
        String monthString;
        do 
        {
             choice = Admin.ShowMenuAdmin();
            switch (choice) 
            {
               case 1: admin.CreateCourse(cAL);                    
                        break;
               case 2:  admin.DeleteCourse(cAL);
                        break;
               case 3:  admin.EditCourse(cAL);
                        break;
               case 4:  admin.DisplayInfoGivenCourse(cAL);
                        break;
               case 5:  admin.RegisterStudent(sAL);
                        break;
               case 11:  admin.ViewAllCourses(cAL);
                        break;
               case 12:  admin.ViewCouresFull(cAL, 1);
                        break;
               case 13:  admin.ViewCouresFull(cAL, 2);
                        break;
               case 14: admin.WhoisRegisteredinThisCourse(cAL, sAL);
                        break;
               case 15: admin.CoursStudenRegistered(cAL, sAL);
                        break;
               case 16: admin.SortListofCourses(cAL);
                        break;
               default: System.out.println("Please Choose the correct option");
                        break;

           }            
            
        } while (choice != 0);
        System.out.println();
    
    
    }
    

    
   
    
    
}
