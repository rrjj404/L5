import java.io.*;
import java.util.Scanner;
 
public class ring{
    static int n;
    static int pro[] = new int[100];
    static int sta[] = new int[100];
    static int prio[] = new int[100];
    static int co;
     
    public static void main(String args[])throws IOException
    {
    	System.out.println("----------------------------------------------------------");
        System.out.print("Enter the number of process : ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        System.out.println("----------------------------------------------------------");
        
        int i,j,k,l,m;
         
        for(i=0;i<n;i++)
        {
        	System.out.println("**For process "+(i+1)+" :");
            System.out.print("---> Status : ");
            sta[i]=in.nextInt();
            System.out.print("---> Priority : ");
            pro[i] = in.nextInt();
            System.out.println("===============");
        }
        
        System.out.println("The ring formed is: ");
        for (i=1;i<=n;i++) {
        	System.out.print(i + " ->");
        }
        System.out.println("1");
        
        System.out.println("----------------------------------------------------------");
        System.out.print("Which process will initiate election? : ");
        int ele = in.nextInt();
        System.out.println("----------------------------------------------------------");
        
        elect(ele);
        System.out.println("Final coordinator is : "+co);
        System.out.println("----------------------------------------------------------");
    }

    static void elect(int ele)
    {
        
        int i;
        int index = 0;
        int max = 0;
        for(i=(ele-1);i<=n;i++) {
        	if(sta[i]==1) {
        		prio[index] = pro[i];
        		index = index + 1;
        	}
        }
        for(i=0;i<=ele;i++) {
        	if(sta[i] == 1) {
        		prio[index] = pro[i];
        		index = index + 1;
        	}
        }
        
        for(i=0;i<=index;i++) {
        	if(prio[i]>max) {
        		max = prio[i];
        	}
        }
        co = max;
    }
}
