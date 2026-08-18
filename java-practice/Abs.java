abstract class Vehical
{
abstract void start();
}

class Car extends Vehical {
void start(){
System.out.println ("Car starts with a key or button.");
}
}
public class Abs{
public static void main (String[]args){
Vehical v =new Car();
v.start();
}
}