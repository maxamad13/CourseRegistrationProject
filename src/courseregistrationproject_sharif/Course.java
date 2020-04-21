/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.io.Serializable;

/**
 *
 * @author Maxamad13
 */
//<editor-fold defaultstate="collapsed" desc="class Course">
/*Req 01: The school shall store the following information about each course:
Course name, course id, maximum number of students registered in the course, current number of
registered students, a list of names of students being registered in the given course, cours e instructor,
course section number, course location.
*/

class Course implements Serializable
{
    private String courseId;   //get, not set, not allowed to change after created
    private String courseName; //Computer Programming II
    private String courseNum;  //COMP 2240
    private int maxNumStudents; //get, set
    private String instructor; //get, set
    private String sectionNum; //get, set
    private int currentStudent = 0; //get, set
    private String room;       //get, set
    
    public Course(String id, String name, String cNum)
    {
        this.courseId = id;
        this.courseName = name;
        this.courseNum = cNum;
    }
    
    //default course
    public Course(){}
    //region
    public String getCourseId()
    {
        return courseId;
    }
    
    public String getCourseName()
    {
        return courseName;
    }

    public void setMaxNumStudents(int m)
    {
        maxNumStudents = m;
    }
    
    public int getMaxNumStudents()
    {
        return maxNumStudents;
    }
    
    
    public void setInstructor(String i)
    {
        instructor = i;
    }
    
    public String getInstructor()
    {
        return instructor;
    }
    
    public void setSectionNum(String s)
    {
        sectionNum = s;
    }
    
    public String getSectionNum()
    {
        return sectionNum;
    }
    public void setCurrentStud(int s)
    {
        currentStudent = currentStudent + s;
    }
    public void remCurrentStud()
    {
        currentStudent--;
    }
     public int getCurrentStud()
    {
       return currentStudent;
    }
    public void setRoom(String r)
    {
        room = r;
    }
    
    public String getRoom()
    {
        return room;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-35s%-12s%-12s%-6s%-8s%-10s%-15s%-20s", courseName,courseNum, courseId, 
                sectionNum, maxNumStudents, currentStudent,  instructor,  room);
    }
}
//</editor-fold>