
import java.util.*;
import java.io.*;

public class bully {

    //define static values
    static int n;
    static int pro[] = new int[10];
    static int sta[] = new int[10];
    static int co;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        //Details of the bumber of processes, their id and status
        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();
        System.out.println("------------------------------------------");
        int i ;
        for(i = 0; i<n; i++){
            System.out.println("Enter the priority ID for " +(i+1)+" :" );
            System.out.println("Priority ID => ");
            pro[i] = sc.nextInt();
            System.out.println("Enter status of process => ");
            sta[i] = sc.nextInt();
        }
        // who will lead?
        System.out.println("------------------------------------------");

        System.out.println("Which process should initiate : ");
        int ele = sc.nextInt();

        System.out.println("------------------------------------------");
        // call elect
        elect(ele);
        System.out.println("Coordinator is : "+ co);

    }

    static void elect(int ele){
        ele = ele - 1;
        co = ele + 1;
        for( int i = 0; i<n; i++){
            if(pro[ele] < pro[i])
                {
                    System.out.println("Message is sent form "+ (ele+1) + " to "+ (i+1));
                    if(sta[i] == 1)
                    {
                        elect(i+1);
                    }
                }
        }    
    }
}

