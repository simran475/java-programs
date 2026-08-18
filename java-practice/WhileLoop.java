import java.util.Scanner;
public class WhileLoop{
public static void main(String[]args){
Scanner sc= new Scanner(System.in);
System.out.print("enter a number:");
int num =sc.nextInt();
int sum=0;
while(num!=0){
int digit= num%10;
sum =sum +digit;
num =num/10;
}
System.out.print("Sum of digit="+sum);
sc.close();
}
}