import java.util.Scanner;
public class IfStatement
{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
System.out.print("enter age:");
int age =sc.nextInt();
if(18<=age)
{
System.out.print("you are eligible for voting:"+age);
}
sc.close();
}
}