/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseregistrationproject_sharif;

import java.util.Comparator;


public class CourseSortByCurrentNum implements Comparator<Course>
{
    int type;

    public CourseSortByCurrentNum(int num)
    {
        type = num;
    }
    
    @Override
   public int compare(Course c1, Course c2)   //? : conditional operator
   {    if(type == 1) 
          return (c2.getCurrentStud() > c1.getCurrentStud()? -1 :  (c2.getCurrentStud()== c1.getCurrentStud()? 0 : 1));
        else
           return (c2.getCurrentStud() < c1.getCurrentStud()? -1 :  (c2.getCurrentStud()== c1.getCurrentStud()? 0 : 1));
   }
}
