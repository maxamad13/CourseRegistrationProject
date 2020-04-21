/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maxamad13
 */
//<editor-fold defaultstate="collapsed" desc="abstract class User">
abstract class User implements Serializable
{
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    
    public User(String firstName, String lastName)
    {
        this.userName = firstName.toLowerCase() + lastName.toLowerCase();
        this.password = firstName + lastName + "001";
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //get
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getPassword()
    {
        return password;
    }
    @Override
    public String toString()
    {
        return String.format("%-18s%-18s", firstName + " " + lastName, userName + "   " + password);
    }
    
    public abstract void ViewAllCourses(ArrayList<Course> cAL);
}
//</editor-fold>

