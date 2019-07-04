package com.pumakuki.rest.webservices.restfulwebservices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class TestClass2 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter wr = new PrintWriter(System.out);
         String[] N_Q = br.readLine().split(" ");
         int N = Integer.parseInt(N_Q[0]);
         int Q = Integer.parseInt(N_Q[1]);
         int[] T = new int[Q];
         int[] V = new int[Q];
         int Type1 = 0 ;
         //Type1 denotes the number of Type 1 queries.
         for(int i_T=0; i_T<Q; i_T++)
         {  String[] arr_T = br.readLine().split(" ");
         	T[i_T] = Integer.parseInt(arr_T[0]);
         	V[i_T] = Integer.parseInt(arr_T[1]);
         	if(T[i_T]==1) Type1++ ; 
         	
         }
         
         int[] out_ = ColoringTree(N, T, V, Q, Type1);
         System.out.print(out_[0]+"\n");
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(out_[i_out_]+"\n");
         }

         wr.close();
         br.close();
    }
    static int[] ColoringTree(int N, int[] T, int[] V,int Q, int Type1){
        // Write your code here
        
        int[] color_v = new int[N+1];
         int[] out_ = new int[Type1];
         int col_indx=0;
         int start=0;
        for(int i=1;i<=N;i++){
            color_v[i]=0;
        }
        for(int i=0;i<Q;i++){
            if(T[i]==1)
            {
                out_[col_indx++]=color_v[V[i]];
            }
            if(T[i]==2)
            {
                
                for(start = V[i];start<=N;){
                	if(2*start<N)
                		color_v[2*start]=color_v[2*start]+1;
                	if(2*start+1<N)
                	{
                		color_v[(2*start+1)]=color_v[(2*start+1)]+1;
                	}
                    start = start+1;
                }
            }
        }
       return out_;
    }
}