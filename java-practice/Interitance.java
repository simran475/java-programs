class Person{
String name="Ram";
int age= 20;
void displayPerson(){
System.out.println("Name:"+name);
System.out.println("Age:"+age);
}
}
class Student extends Person{
int rollNo =101;
void displayStudent(){
System.out.println("Roll No:"+rollNo);
}
}
public class Interitance{
public static void main(String[]args){
Student s= new Student();
s.displayPerson ();
s.displayStudent();
}
}