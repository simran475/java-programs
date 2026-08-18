import java.util.Scanner;
public class IfElseStatement
{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
System.out.print("enter age:");
int age =sc.nextInt();
if(age>=18)
{
System.out.print("you are eligible for voting if your age is:"+age);
}
else
{
System.out.print("you are eligible for voting if your age is:"+age);
}
sc.close();
}
}