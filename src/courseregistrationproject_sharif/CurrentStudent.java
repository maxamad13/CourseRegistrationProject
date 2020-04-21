/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.util.ArrayList;
import java.util.Scanner;


public class CurrentStudent
{
    private String userName;
    private String password;
    private int courseNotFull = 0;
    private Scanner kb = new Scanner(System.in);

    public CurrentStudent(String un, String pw)
    {
        userName =  un;
        password = pw;
    }
    
    //View all courses
    public void ViewAllCourses(ArrayList<Course> cAL)// from super class User
    {
        Scanner in = new Scanner(System.in);
        int count = 0;
        System.out.println("   CourseName                         CourseNum   CourseID SecNum MaxStud CurStudNum  Instructor     Room ");
        for (Course course : cAL)
        { count++;
            System.out.printf("%3s-%s\n",count, course);
        }
        
        
    }
    
    //View courses that are not full    
    public void ViewCoursesNotFull(ArrayList<Course> cAL)
    {
        int courseNotFull = 0;
        
        ArrayList<Course> notFull = new ArrayList<>();
        
        for (Course course : cAL)
        {
            if (course.getMaxNumStudents() != course.getCurrentStud())
            {
                courseNotFull++;
                notFull.add(course);                
            }          
            
        }
        
        if(courseNotFull == 0)
        {
            System.out.println("All Courses are full");
            kb.nextLine();
        }
        else  
        {
            ViewAllCourses(notFull);    
            System.out.println("Please hit Enter any key to go back to main menue");
             String temp = kb.nextLine();
        }
    }
    
    //The couress that current user is registered to
    public void CurrentlyRegisteredCourse(ArrayList<Course> cAL, ArrayList<Student> sAL)
    {
        int count = 0;
        ArrayList<Course> registered = new ArrayList<>();
         int studIndex =  getStudentArrID(sAL);
         
         for (String temp : sAL.get(studIndex).getCAlStudentR())
        {
            for (Course course : cAL)
            {
                if (course.getCourseId().equals(temp))
                {
                    registered.add(course);
                    count++;
                }
                
            }
        }
         if (count != 0)
        {
             ViewAllCourses(registered);
             System.out.println("Please enter any key to go back to main menue ");
             kb.nextLine();
        }
        
         
         if (count == 0)
        {
            System.out.println("Currently you are not registered in any course\n Please enter any key to go back to main menue ");
            kb.nextLine();
        }   
    
    }
    
    //Withdraw course
    public void WithdrawCourse(ArrayList<Course> cAL, ArrayList<Student> sAL)
    {
        boolean deleted = false;
        int studIndex =  getStudentArrID(sAL);
        //CurrentlyRegisteredCourse(cAL, sAL);
        System.out.println("To withdraw a course, please enter correct Course ID");
        System.out.println("Please enter Course ID: " );
       String cId = kb.nextLine();
    
       
        for (int i = 0; i < sAL.get(studIndex).getCAlStudentR().size(); i++)
        {
            if (sAL.get(studIndex).getCAlStudentR().get(i).equals(cId))
            {
                for (Course course : cAL)
                {
                    if (course.getCourseId().equals(cId))
                    {
                        course.remCurrentStud();
                        sAL.get(studIndex).getCAlStudentR().remove(cId);
                        deleted = true;
                        System.out.println("Course Successfully withdrawn");
                        break;
                    }
                    
                }
                
            }
        }
        
        if (!deleted)
        {
            System.out.println("Course not withdrawn. ");
        }
        System.out.println("Please enter any key to go back to previous menue");
        kb.nextLine();
    }
    
    //Register a course
   public void  RegisterCourse(ArrayList<Course> cAL, ArrayList<Student> sAL)
   {
       int studId =  getStudentArrID(sAL);
       System.out.println("-------------- Course To Register--------------");
       ViewAllCourses(cAL);
       System.out.println("Please enter Course ID below:  ");
       String cId = kb.nextLine();
      
       int courseIndex = Verifycourse(cId, cAL);
       
       if (Verifycourse(cId, cAL) != -1 && !AlreadyRegistered(sAL, cId))
       {
           sAL.get(studId).AddCourseId(cId);
           cAL.get(courseIndex).setCurrentStud(1); 
           System.out.println("Course Registered Successful");           
       }else
           System.out.println("Course was not regiestered please try again");
       
       
       
   }
   
   //check if course is in list and not full
   private int Verifycourse(String id, ArrayList<Course> cAL )
   {

       for (int i = 0; i < cAL.size(); i++)
       {
           if (cAL.get(i).getCourseId().equals(id) && cAL.get(i).getMaxNumStudents() != cAL.get(i).getCurrentStud())
           {
               
               return i;
           }
           
       }
       return -1;
   
   
   }
   
   //check if alrady registered
   private boolean AlreadyRegistered(ArrayList<Student> sAL, String id)
   {
       boolean registered = false;
       int index = getStudentArrID(sAL);
       if (sAL.get(index).getCAlStudentR().size() != 0)
       {
            for (int i = 0; i < sAL.get(index).getCAlStudentR().size(); i++)
            {
                if (sAL.get(index).getCAlStudentR().get(i).equals(id))
                {
                    System.out.println("Already registered in this course");
                    registered = true;
                }
            }
           
       }
     
       return registered;
   }
   private int getStudentArrID(ArrayList<Student> sAL )
   {
       for (int i = 0; i < sAL.size(); i++)
       {
           if(sAL.get(i).userName.equals(userName) && sAL.get(i).password.equals(password) )
               return i;
           
       }
       
       return -1;
   
   }
    
    
    
}
