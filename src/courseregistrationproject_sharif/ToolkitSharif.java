/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maxamad13
 */
//<editor-fold defaultstate="collapsed" desc="class ToolkitShao">
class ToolkitSharif implements Serializable
{
    public static Scanner kb =new Scanner(System.in);
    

        public static void SerializationFullCourses(ArrayList<Course> cAL) throws IOException
    {
        
         FileOutputStream outStream = new FileOutputStream("fullcourses.dat");
         ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream); 
            // Write the serialized objects to the file.
        try
        {
            
                    
            for (Course course : cAL)
            {
                objectOutputFile.writeObject(course); 
            }
                    
                    objectOutputFile.close();
                    outStream.close();
                    System.out.println("The courses that are full successfully written to .dat ");
                    System.out.println("Please enter any key to go back to main menue");
                     kb.nextLine();
            
        } catch (Exception e)
        {
        }
    }
    public static void SerializationcAL(ArrayList<Course> cAL) throws IOException
    {
        // serialize cAl to Courses.dat
        
        //first save the number of courses, then each course
        
        //......
        

         FileOutputStream outStream = new FileOutputStream("Courses.dat");
         ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream); 
            // Write the serialized objects to the file.
        
            
        try
        {
            
                    
            for (Course course : cAL)
            {
                objectOutputFile.writeObject(course); 
            }
                    
                    objectOutputFile.close();
                    outStream.close();
            
        } catch (Exception e)
        {
        }
    }
    
    public static void SerializaionsAL(ArrayList<Student> sAL) throws IOException
    {
        //......
        
        //first save the number of students
        
        
        //......
         FileOutputStream outStream = new FileOutputStream("Students.dat");
         ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream); 
            // Write the serialized objects to the file.
        
            
        try
        {
            
                    
            for (Student student : sAL)
            {
                objectOutputFile.writeObject(student); 
            }
                    
                    objectOutputFile.close();
                    outStream.close();
            
        } catch (Exception e)
        {
        }
    }
    
    public static void PopulateStudentArrayList(ArrayList<Student> sAL) throws Exception
    {
        //if file Students.dat exits, populate sAL
        //......
        Student s;
        FileInputStream fis;
        ObjectInputStream  ois;
        //if file Courses.dat exits, populate cAL, otherwise in catch clause, call ReadcALFromCSV;
        File studentFile = new File("Students.dat");
        if (studentFile.exists())
        {    fis = new FileInputStream("Students.dat");
             ois = new ObjectInputStream(fis);

            try
            {
                //open this file "Courses.dat"                
                System.out.println("Student are from .dat file. ");         

              
                while (true)
                {
                    s = (Student) ois.readObject();
                    sAL.add(s);

                }
              
                //fis.close();
               // ois.close();

            }catch(Exception e)
            {
               // e.getCause();
                System.out.println("Cant read student object");
                //System.out.println(e.getCause());
                //e.printStackTrace();

            }    
            fis.close();
            ois.close();
        }
    }
    
    public static void PopulateCourseArrayList(ArrayList<Course> cAL) throws Exception
    {
        Course c;
        FileInputStream fis;
        ObjectInputStream  ois;
        //if file Courses.dat exits, populate cAL, otherwise in catch clause, call ReadcALFromCSV;
        File courseFile = new File("Courses.dat");
        if (courseFile.exists())
        {    fis = new FileInputStream("Courses.dat");
             ois = new ObjectInputStream(fis);

            try
            {
                //open this file "Courses.dat"                
                System.out.println("Courses are from .dat file. ");         

              
                while (true)
                {
                    c = (Course) ois.readObject();
                    cAL.add(c);

                }
              
                //fis.close();
               // ois.close();

            }catch(Exception e)
            {
                //e.printStackTrace();

            }    
            fis.close();
            ois.close();
        }else{
          
                try
                {                    
                    ReadcALFromCSV(cAL);
                }
                catch(Exception i)
                {
                    i.printStackTrace();
                }
        //otherwise read in from MyUniversityCourses.csv
        }
        
    } 
        
    public static void ReadcALFromCSV(ArrayList<Course> cAL) throws IOException
    {        
        Course c;
        String[] lineArray;
        //open a file for reading
        File f = new File("CSCourses.csv");
        Scanner sf = new Scanner(f); 
        
        System.out.println("output from the first method");
        //read the first line
        String line = sf.nextLine();
        System.out.println(line);
        while(sf.hasNext())
        {
            line = sf.nextLine();
            System.out.println(line);
            lineArray = line.split(",");
//            System.out.printf("%-42s%-15s%-4s%-25s%-6s%-20s\n", lineArray[0],
//                        lineArray[1], lineArray[2], lineArray[5], lineArray[6], lineArray[7]);
            
            //use lineArray's data to create an object of Course, add to Arraylist cAL
            c = new Course(lineArray[2], lineArray[0], lineArray[1]);
            c.setMaxNumStudents(Integer.parseInt(lineArray[4]));
            c.setInstructor(lineArray[6]);
            c.setSectionNum(lineArray[3]);
            //c.setCurrentStud(Integer.parseInt(lineArray[5]));
            c.setCurrentStud(0);
            c.setRoom(lineArray[7]);
            cAL.add(c);
        } 
        System.out.println();
        System.out.println("output from the enhanced for loop");
        for(Course cc: cAL)
            System.out.println(cc);
        sf.close();
    } 

    public static int Get1_2_N1(String prompt)//returns 1 or 2 or 1-1
    {
        //......
        System.out.print(prompt);
        int user = Integer.parseInt(kb.nextLine());     
        
        return user;
    }
         

    public static Student getStudent(String id, String pw, ArrayList<Student> sAL)
    {
        for (Student student : sAL)
        {
            if(student.userName.toLowerCase().equals(id) && student.password.equals(pw))
                return student;
            
        }
        
        return null;
    }    
}

//</editor-fold>
