import java.util.Scanner;
public class NaturalNumber{
public static void main(String[]args){
Scanner sc =new Scanner(System.in);
System.out.print("enter a numbers:");
int n= sc.nextInt();
System.out.println("Natural numbers from 1 to " + n + " are:");
for(int i=1;i<=n;i++){
System.out.print(i + "\n");
}
sc.close();
}
}