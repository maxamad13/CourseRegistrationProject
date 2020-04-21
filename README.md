Course Management

1. Create a new course
2. Delete a course
3. Edit a course (this will allow the admin to edit any information on the
   course except forcourse ID, course number and name)
4. Display information for a given course (by course ID)
5. Registera student (this option will allow the admin to add a student without
   assigning to a course check Req 11 for student’s information–Hint: You
   might need to have an ArrayList of Students where you store Student
   objects)
6. Exit
   Reports
7. View all courses(for every course the admin should be able to see the list
   of enrolled student’s names, enrolled student’s ids, number of students
   registered, and the maximum number of students allowed to be registered)
8. View all courses that are FULL (reached the maximum number of
   students)
9. Write to a file the list of course that are full
10. View the names of the students that are registered in a specific course
11. View the list of courses that a given student is registered in (given a
    student first name and last name the system shall display all the courses
    that student is registered in)
12. Sort the courses based on the current number of students registered
13. Exit
     Req 04: The system shall allow the student to perform the following tasks:
    Course Management
14. View all courses
15. View all courses that are not full
16. Register in a course (in this case the student must enter the course
    number, section, and student full name, the name will be added to the
    appropriate course)
    COMP 2240
17. Withdraw from a course (in this case the student will be asked to enter
    her/his name and the course name, then the name of the student will be
    taken off from the given course’s list)
18. View all courses that the current student is registered in
19. Exit
     Req 05: Define an Interface for adminclassthat will have the signaturesof the methods
    that will be used by the admin.
     Req 06: Define an Interface for a student class that will have the signatures of the
    methods that will be used by the student.
     Req 07: Both classes Admin and Student inherit from a class named User.
    A user should have at least the following class members: username, password, first
    name, and last name. (You will need to decide on the methods of a User class. These
    methods can then be inherited or overridden by the Student and/or the Admin class.)
     Req 08: At the beginning of launching the program, you will need to read all the
    courses’information from the comma delimited file CSCourses.csv into an ArrayList
    of Course Objects.
    Notice that initially the number of students registered is zero.
    The student list is initially null (there are not students registered in the class at the
    beginning).
     Req 09: For simplicity assume that there is one Admin in the program.
    The username and password for the admin is: Adminand Admin001
     Req 10: You do not need to follow this requirement, you can come up with your
    own design and this is just one possible solution. At the start of the program, the
    user is asked to check if they are a student or an admin then if the user is admin,
    she/he will be asked to enter the username and password. Same applies for student.
     Req 11: A student class should at least have a username, password, first name and
    last name.
    COMP 2240
    You will need to decide on how to keep track on the students’courses if needed. You
    might need to decide on how to store a list of students.
     Important Note: A student can only be registered into the course system by an
    admin. Furthermore, every student should have a unique username and a password
    as defined by the admin. One such example would be the student named “First
    Second” with a username and password: StudentName and StudentName001.
     Req 12: Serialization
    Serializing an object allows the programmer to convert the state of that object into a
    byte stream that can be reverted back into a copy of the object. A Java object is
    serializable if its class or any of its superclasses implements either the
    java.io.Serializable interface or its subinterface, java.io.Externalizable. Deserialization
    is the process of converting the serialized form of an object back into a copy of the
    object. You will need to use Serialization to store an object permanently (in this project’s
    case it could be used to store the ArrayLists of Student object and the ArrayList of the
    courses object). Deserialization will be used to read the files where you stored the
    objects, so you can use them again in your program. When the program exits, you will
    need to write the latest copy of the ArrayLists or the object you are using in your program
    into the serialized binary file. The moment you launch your program, you will need to
    read the files to initialize your objects in your program
