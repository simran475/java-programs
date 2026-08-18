class Person{
void role()
{
System.out.println("A person have different role");
}
}
class teacher extends Person
{
void role()
{
System.out.println("Teacher tech");
}
}
class parent extends Person
{
 void role()
{
System.out.println("take care of children");
}
}
public class Role
{
public static void main(String[]args)
{
Person t, p ;
Person Person ;
Person=new Person();
Person.role();
t=new teacher();
t.role();
p= new parent();
p.role();

}
}