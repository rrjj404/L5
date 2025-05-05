
		import mpi.*;

        public class DistributedSum{
            public static void main(String args[]) throws MPIException{
                MPI.Init(args);
                int rank = MPI.COMM_WORLD.Rank();  // 0 1 2
                int size= MPI.COMM_WORLD.Size();  //3
                
                int[] array= {1,2,3,4,5,6,7,8,9,10};
                int n= array.length;     //n=10
                int local_n = n/size;   //3
                int remainder = n%size;   //1
                
                int[] local_array = new int[local_n + (rank< remainder ? 1:0)];
                // p0     3+1=4
                //p1     3+0=3
                //p2     3+0=3
                
                
                int offset= rank*local_n + Math.min(rank, remainder);
                //p0    0*3+0=0     0 1 2 3
                //p1    1*3+1=4     4 5 6
                //p2    2*3+1=7     7 8 9
                
                
        
		for(int i=0; i<local_array.length; i++){
			local_array[i]=array[i+offset];
		}
		
		int local_sum=0;
		for(int i=0; i<local_array.length; i++){
			local_sum+=local_array[i];
		}
		
		int[] global_array = new int[size];
		MPI.COMM_WORLD.Allgather(new int[]{local_sum}, 0,1, MPI.INT, global_array, 0, 1, MPI.INT);
		if(rank==0){
		System.out.println("Number of Processes present : "+size);
		int global_sum=0;
		for(int i=0; i<size; i++){
			global_sum+=global_array[i];
			System.out.println("The local sum by process "+i+" : "+global_array[i]);
		}
		
		System.out.println("Final Global Sum : "+global_sum);}
		MPI.Finalize();
		
		
	}

}


/*

*Steps to run assignment no 3*

1. Download & extract jar file in home directory from below link

https://sourceforge.net/projects/mpjexpress/

2. Open terminal in home directory & type below command

sudo gedit ~/.bashrc

3. Add below 2 lines in opened bash rc

export MPJ_HOME="/home/pvg/mpj-v0_44"

export PATH=$MPJ_HOME/bin: $PATH

4. Compile and run assignment 3 using below commands

javac -cp "/home/pvg/mpj-v0_44/lib/mpj.jar" DistributedSum.java

mpjrun.sh -np 6 DistributedSum
	*/
