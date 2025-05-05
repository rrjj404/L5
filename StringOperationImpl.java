import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import SimpleString.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.DataInputStream;

public class StringOperationImpl extends _StringOperationImplBase
{
    public String get_String(String symbol)
    {
        Scanner sc = new Scanner(System.in);
        DataInputStream din=new DataInputStream(System.in);
        System.out.println("1.Get Length");
        System.out.println("2.Join Two Java Strings");
        System.out.println("3.Compare two Strings");
        System.out.println("4.Replace the character");
        System.out.println("5.Reverse the String");
        System.out.println("\nEnter your choice : ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:

            {
                int length = symbol.length();
                String len = String.valueOf(length);
                return len;
            }
            case 2:

            {
                try
                {
                    System.out.println("\nEnter the String to concat : ");
                    String str =din.readLine();
                    String joinedString = symbol.concat(str);
                    return joinedString;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            case 3:

            {
                try
                {
                    System.out.println("\nEnter the String to compare : ");
                    String str2 =din.readLine();
                    boolean result1 = symbol.equals(str2);
                    return String.valueOf(result1);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            case 4:
            {
                System.out.print("Input a character to be replaced : ");
                char c = sc.next().charAt(0);
                System.out.print("Input a character to be replaced with : ");
                char c1 = sc.next().charAt(0);
                return symbol.replace(c, c1);
            }

            case 5:
            {
                StringBuilder input1 = new StringBuilder();
                input1.append(symbol);
                input1.reverse();
                return input1.toString();
            }

            default:
            {
                System.out.println("Invalid choice");
                return "0";
            }
        }
    }
    public StringOperationImpl()
    {
        super();
    }
}
