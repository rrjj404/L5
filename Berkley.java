import java.util.* ; 
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Berkley{

    public static void balgo(String m, String s1, String s2, String s3){
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Initial values");
        System.out.println("Master : "+m);
        System.out.println("Slave s1 : "+s1);
        System.out.println("Slave s2 : "+s2);
        System.out.println("Slave s3 : "+s3);
        System.out.println("--------------------------------------------------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

        try{
        //Convert values 
        long mog = sdf.parse(m).getTime()/1000;
        long s1og =  sdf.parse(s1).getTime()/1000;
        long s2og = sdf.parse(s2).getTime()/1000;
        long s3og = sdf.parse(s3).getTime()/1000;

        // difference between master and slaves 
        long s1diff = s1og - mog;
        long s2diff = s2og - mog;
        long s3diff = s3og - mog;

        System.out.println("--------------------------------------------------------------");
        System.out.println("Difference between master and slaves");
        System.out.println("Master : "+"0");
        System.out.println("Slave s1diff : "+s1diff);
        System.out.println("Slave s2diff : "+s2diff);
        System.out.println("Slave s3diff : "+s3diff);
        System.out.println("--------------------------------------------------------------");

        //fault tolerance calculations
        long ft = (0 + s1diff + s2diff + s3diff)/4;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Average Fault Tolerance = " + ft);
        System.out.println("--------------------------------------------------------------");

        //Calculate adjustment time
        long madj = ft - 0;
        long s1adj = ft - s1diff;
        long s2adj = ft - s2diff;
        long s3adj = ft - s3diff;

        System.out.println("--------------------------------------------------------------");
        System.out.println("Adjustment Time");
        System.out.println("Master : "+madj);
        System.out.println("Slave s1adj : "+s1adj );
        System.out.println("Slave s2adj : "+s2adj);
        System.out.println("Slave s3adj : "+s3adj);
        System.out.println("--------------------------------------------------------------");

        //Adjust the times now
        long nm = mog + madj;
        long ns1 = s1og + s1adj;
        long ns2 = s2og + s2adj;
        long ns3 = s3og + s3adj;

        //Convert these to date format
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("New Time");
        System.out.println("Master : "+sdf.format(new Date(nm*1000)));
        System.out.println("Slave : "+sdf.format(new Date(ns1*1000)));
        System.out.println("Slave : "+sdf.format(new Date(ns2 *1000)));
        System.out.println("Slave : "+sdf.format(new Date(ns3*1000)));
        System.out.println("--------------------------------------------------------------");
        }

        catch(ParseException e){
            e.printStackTrace();
        }

    }

    public static void main (String[] args){
        balgo("3:00","3:10","2:50","3:20");
    }
}

