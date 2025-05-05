
import java.util.*;

public class Tokenringksh  {
    public static void main(String args[]) throws Throwable {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of nodes:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(i + " ");
        }
        System.out.println("0");

        int token = 0;
        int choice = 1;

        do {
            System.out.println("Enter the sender no.:");
            int sender = sc.nextInt();
            System.out.println("Enter the receiver no.");
            int receiver = sc.nextInt();
            System.out.println("Enter the data to process: ");
            int data = sc.nextInt();

            int i = token;

System.out.print("token passing");
System.out.println("--------------------");

while (i != sender) {
    System.out.println(i + "->");
    i = (i + 1) % n;
}
System.out.println(sender);

System.out.println("Sender" + sender + "Sending data" + data);

i = sender + 1; //index hai shayad?

while (i != receiver) {
    System.out.println("node" + i + "fwd data" + data);
    i = (i + 1) % n;
}

System.out.println("Receiver " + receiver + "Received the data" + data);

token = sender;
System.out.println("press 1 to continue, 0 to stop");
choice = sc.nextInt();

} while (choice == 1);
    }
}