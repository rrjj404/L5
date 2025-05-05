import java.rmi.Naming;
import java.util.Scanner;

public class client {
    public client() {
    }

    public static void main(String args[]) throws Exception {
        int radius;
        Scanner sc = new Scanner(System.in);
        System.out.println("-|-|-|-|-|-|");
        System.out.println("Enter the radius :");
        radius = sc.nextInt();
        circleinterface c = (circleinterface) Naming.lookup("rmi://localhost:3000/circle");
        System.out.println("the area of the circle is : " + c.area(radius));
        System.out.println("the cicumference of circle is : " + c.perimeter(radius));
        System.out.println("--------------");
    }

}
