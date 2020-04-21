
package courseregistrationproject_sharif;


import static courseregistrationproject_sharif.Student.kb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Maxamad13
 */
//<editor-fold defaultstate="collapsed" desc="class Admin">
class Admin extends User 
{
    private Scanner kb;
    public Admin()
    {
        super("Ad", "min");
        firstName = "AdminFirst";
        lastName = "AdminLast";
         kb =new Scanner(System.in);
    }
    
 
    @Override
    public void ViewAllCourses(ArrayList<Course> cAL)// from super class User
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("CourseName                         CourseNum   CourseID SecNum MaxStud CurStudNum  Instructor     Room");
        for (Course course : cAL)
        {
            System.out.println(course);
        }
        
        System.out.println("Please hit Enter any key to go back to main menue");
        in.nextLine();
    }
    
    //View Courses that are full
    public void ViewCouresFull(ArrayList<Course> cAL, int num)
    {
        ArrayList<Course> fullCourses = new ArrayList<>();
        
        for (Course fullCourse : fullCourses)
        {
            
        }
        for (Course course : cAL)
        {
            if (course.getMaxNumStudents() == course.getCurrentStud())
            {
                fullCourses.add(course);
            }
            
        }
        
        if (num == 1)
        {
            ViewAllCourses(fullCourses); 
        }else{
            WriteFullCourseToFile(cAL);
        }
        
        
    
    }
    
    public void WriteFullCourseToFile(ArrayList<Course> cAL)
    {
        try
        {
            ToolkitSharif.SerializationFullCourses(cAL);
        } catch (Exception e)
        {
            e.getCause();
        }
        
    
    }
    //Add new Course
    public void CreateCourse(ArrayList<Course> cAL)
    {
        kb.reset();
        Scanner in = new Scanner(System.in);
        Course c;
       // System.out.println("Please Enter Necessary information to create new course");
        System.out.println("Enter Course Name: ");
        String cName = in.nextLine();
        System.out.println("Enter Course Number: ");
        String cNum = in.nextLine();
       // kb.next();
       
        System.out.println("Enter Course ID: ");
        String cId = in.nextLine();
        System.out.println("Enter course section number: ");
        String sectNum = in.nextLine();
        
        System.out.println("Enter the instructor name: ");
        String instructor = in.nextLine();        
        System.out.println("Enter the course location: ");
        String room = in.nextLine();
        System.out.println("Enter maximum number of students for this course: ");
        int maxStud = in.nextInt();
        //  String id, String name, String courseNum
        //  use lineArray's data to create an object of Course, add to Arraylist cAL
            c = new Course(cId, cName, cNum);
            c.setMaxNumStudents(maxStud);
            c.setInstructor(instructor);
            c.setSectionNum(sectNum);
            c.setCurrentStud(0);
            c.setRoom(room);
            
            cAL.add(c);
            
            kb.reset();
    
    }
     

     //Delete course
    public void DeleteCourse(int num, ArrayList<Course> cAL)
    {
        cAL.remove(num);
    }
    public void DeleteCourse(ArrayList<Course> cAL)
    {
        int course;
        int count = 0;       
        System.out.println("Plese select the the course you want to delete ");
        System.out.println("   Course Name                           CourseID");
        for (int i = 0; i < cAL.size(); i++)
        {
            count = 0;
            count = i + 1;               
            System.out.printf("%2s %-35s%-5s\n", count, cAL.get(i).getCourseName(),cAL.get(i).getCourseId());
        }
        
        System.out.println("To delete a course please Choose number 1-" + count + " that correspons to each courses");
        course = kb.nextInt();
        
        String courName = cAL.get(course -1).getCourseName();
        String courId = cAL.get(course-1).getCourseId();
       cAL.remove(course -1);

        System.out.println("Course: "+ courName + " CId: " + courId + " has been successfully deleted");
        System.out.println("Type  1 to delete another course \n Or 0 to go back to the main menue");
        int choice = kb.nextInt();
        
        if (choice == 1)
            DeleteCourse(cAL);
       
    }
    
    //Edit Course
    public void EditCourse(ArrayList<Course> cAL)
    {
        boolean edited = false;
        int count = 0;
        int course;
        int courseEdit;
      
        Scanner in = new Scanner(System.in);
        
        System.out.println("Plese select the the course you want to edit ");
        for (int i = 0; i < cAL.size(); i++)
        {          
            count = 0;
            count = i + 1;
            System.out.printf("%2s %s\n" ,i+1, cAL.get(i));
        }
         System.out.println("please enter 1-"+ count + " corresponding each course ");
           course = in.nextInt();
         if (course <= cAL.size())
            {
            System.out.println("What would you like to edit? ");
            System.out.println("1. Course Section Num");
            System.out.println("2. Course Max Students");
            System.out.println("3. Course Instructor");
            System.out.println("4. Course Location");
        
            courseEdit =  in.nextInt();
            
       
            if (courseEdit == 1)
            {
                edited = true;
                System.out.print("Enter new Section Num: ");
                String secNum = in.next();
                cAL.get(course -1).setSectionNum(secNum);            
            }else if (courseEdit == 2)
            {
                edited = true;
                System.out.print("Enter new Max Students: ");
                int maxStud =  in.nextInt();
                cAL.get(course -1).setMaxNumStudents(maxStud);   

            }else if (courseEdit == 3)
            {
                edited = true;
                System.out.print("Enter new Instructure First Name: ");
                String ifn = in.next();
                 System.out.print("Enter new Instructure Last Name: ");
                 String iln = in.next();
                 String iFullName = ifn + " " + iln;
                cAL.get(course -1).setInstructor(iFullName);   

            }else if (courseEdit == 4)
            {
                edited = true;
                System.out.println("Enter new Location: ");
                in.nextLine();
                String room = in.nextLine();
                cAL.get(course -1).setRoom(room);   

            }else
            {
                System.out.println("Please select correct option");
            }
        
            
        }else
            System.out.println("You have not selected correct course. Please Choose correct course");
             kb.nextLine();
             
             
          if (edited)
        {
            System.out.println("Cours has been successfully edited. Please hit any key to the main menue");
            kb.nextLine();
        }
    }
    
    //Display given course by ID
    public void DisplayInfoGivenCourse(ArrayList<Course> cAL)
    {
        boolean found = false;
        int pick = 0;
      
        
        System.out.print("Please enter the course Id that you want to display: ");
        //kb.next();
        String cId = kb.next();
        for (int i = 0; i<cAL.size(); i++) 
        {
                if (cAL.get(i).getCourseId().equals(cId)) 
                {
                    found = true;
                    System.out.println(cAL.get(i));

                        break;
                }
        }
        if(!found)
        {
            System.out.println("Course ID not found");
            System.out.print("To search another course please inter 1 or 0 to go back to the main menue: ");
            pick = kb.nextInt();
        }else if (found)
        {
            System.out.println("");
            System.out.print("To search another course please inter 1 or 0 to go back to the main menue: ");
            pick = kb.nextInt();
        }
        if(pick == 1)
            DisplayInfoGivenCourse(cAL);
    }
    
    
    //public sort list
    public void SortListofCourses(ArrayList<Course> cAL)
    {
        System.out.println("Please enter type of sorting 1 for ascending and 2 for descending:");
            int pick = Integer.parseInt(kb.nextLine());
                
            if(pick == 1)
                Collections.sort(cAL, new CourseSortByCurrentNum(1));
            else
                Collections.sort(cAL, new CourseSortByCurrentNum(2));
                
                ViewAllCourses(cAL);
    }
    
    //Who is registered in this course
    public void WhoisRegisteredinThisCourse(ArrayList<Course> cAL, ArrayList<Student> sAL)
    {
        String coursId;
        ArrayList <Student> student = new ArrayList<>();
        
        System.out.println("Please enter courseId that you want to see whos registered: ");
        coursId = kb.nextLine();
        
        for (int i = 0; i < cAL.size(); i++)
        {
            if (cAL.get(i).getCurrentStud() == 0 && cAL.get(i).getCourseId().equals(coursId))
            {
                System.out.println("This course doesn't have any student registered");
                break;
                
            }else if(cAL.get(i).getCurrentStud() != 0 && cAL.get(i).getCourseId().equals(coursId)){
                for (int j = 0; j < sAL.size(); j++)
                {
                    if (sAL.get(j).getCAlStudentR().size() > 0)
                    {
                        for (int k = 0; k < sAL.get(j).getCAlStudentR().size(); k++)
                        {
                            if (sAL.get(j).getCAlStudentR().get(k).equals(coursId))
                            {
                                student.add(sAL.get(j));
                            }
                        }
                        
                    }
                }
            
            }
            
        }
        
        if (student.size() > 0)
        {
             System.out.println("The following students are registered in this course");
            for (Student tempStudent : student)
            {
               
                System.out.println(tempStudent.firstName + " " + tempStudent.lastName);
            }
        }else
            System.out.println("This course doesn't have any student registered");
           System.out.println("Please enter any key to go back to main menue");
           kb.nextLine();
        
    }
    // Courses each students registered to
    public void CoursStudenRegistered(ArrayList<Course> cAL, ArrayList<Student> sAL)
    {
        boolean found = false;
        String fn;
        String ln;
        int sudArrIndex = -1;
        ArrayList<Course> course = new ArrayList<>();
        
        System.out.println("Please enter First Name: ");
        fn= kb.nextLine();
        System.out.println("Please enter Last Name: ");
        ln= kb.nextLine();
        for (int i = 0; i < sAL.size(); i++)
        {
            if (sAL.get(i).firstName.toLowerCase().equals(fn.toLowerCase()) && sAL.get(i).lastName.toLowerCase().equals(ln.toLowerCase()))
            {
                found = true;
                sudArrIndex  = i;
                if (sAL.get(i).getCAlStudentR().size() > 0)
                {
                    
                    for (int j = 0; j < sAL.get(i).getCAlStudentR().size(); j++)
                    {
                        for (Course temp : cAL)
                        {
                            if (temp.getCourseId().equals(sAL.get(i).getCAlStudentR().get(j)))
                            {
                                course.add(temp);
                            }
                        }

                    }
                
                }
                
                
            }
            
        }
     
        if (found && course.size() > 0)
        {
             System.out.println("-------------- Course Registered To"+ sAL.get(sudArrIndex).firstName + " "+sAL.get(sudArrIndex).firstName +" "
                     + " --------------");
            for (Course course1 : course)
            {
                System.out.println(course1);
            }
        }
        
        if(!found)
            System.out.println("No courses found. Please enter any key to go back to main menue");
        else
            System.out.println("Please enter any key to go back to main menue");
        
        kb.nextLine();
    }
    //Register student
    public void RegisterStudent(ArrayList<Student> sAL)
    {
        
        System.out.print("Please enter student's first name: ");
        String firstName = kb.next();
        System.out.print("Please enter student's last name: ");
        String lastName = kb.next();
        
        Student student = new Student(firstName, lastName);
        sAL.add(student);
        
        System.out.println("Student " + firstName + " "+ lastName + " successfully registered");
        System.out.print("To register another student please enter 1 or 0 to go back to main menue: ");
        
        int pick = kb.nextInt();
        
        if(pick == 1)
            RegisterStudent(sAL);
    
    }
    
 
       
    public static int ShowMenuAdmin()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n------------ Course Management Menu for Admin ------------");
        System.out.println("    1 Create a new course");
        System.out.println("    2 Delete a course");
        System.out.println("    3 Edit a course");
        System.out.println("    4 Display information for a given c ourse (by course");
        System.out.println("    5 Register a student"); 
        System.out.println("----------------- Reports Menu for Admin -----------------");
        System.out.println("   11 View all courses");
        System.out.println("   12 View all courses that are Full");
        System.out.println("   13 Write to a file the list of course that are full");
        System.out.println("   14 View the names of the students that are registered in a specific course");
        System.out.println("   15 View the list of courses that a given student is registered in"); 
        System.out.println("   16 Sort the courses based on the current number of students registered");
        System.out.println("---------------------------------------------------------------------------"
                + "\n   type 0 to Main Menu");
        System.out.print("   Enter your choice: ");
        int choice = Integer.parseInt(in.nextLine()); // kb.nextInt();
        return choice;
    }
    
}
//</editor-fold>