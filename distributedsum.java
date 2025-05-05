import mpi.*;

public class distributedsum {
    public static void main(String args[])throws MPIException{
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int n = array.length;
        int local_n = n/size;
        int remainder = n%size;

        int[] local_array = new [local_n +(rank<remainder? 1:0)];

        int offset = rank*local_n + Math.min(rank,remainder);

        for (int i=0;i<local_array.length;i++){
            local_array[i] = array[i+offset];
        }
        int local_sum = 0;
        for(int i=o;i<local_array.length;i++){
            local_sum+=local_array[i];
        }

        int[] global_array = new int[size];
        MPI.COMM_WORLD.Allgather(new int[]{local_sum},0,1,MPI.INT,global_array,0,1,MPI.INT);

        if (rank==0){
            System.out.println("Number of precesses present :"+ size);
            System.out.println("Intermediate sums: ");
            int sum = 0;
            for (int i=0;i<size;i++){
                sum+=global_array[i];
                System.out.println("Process"+i+":"+global_array[i]);
            }
            System.out.println("Total sum"+ sum);

        }
        MPI.Finalize();


    }

}