package com.pumakuki.rest.webservices.restfulwebservices;
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter wr = new PrintWriter(System.out);
         int t = Integer.parseInt(br.readLine().trim());
         long[][] arr = new long[t][3];
         for(int i_arr=0; i_arr<t; i_arr++)
         {  String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr=0; j_arr<arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = Long.parseLong(arr_arr[j_arr]);
         	}
         }
         int[] out_ = Solution(arr,t);
         for (int i_out_=0; i_out_<t; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }
         wr.close();
         br.close();
    }
    static long check(long n){
        
       for(int i=1;Math.pow(3, i)<=n;i++)
       {
    	   if(Math.pow(3, i) == n)
    		   return i;
    	   
       }
       return -1;
    }
    static long minDist(long u,long v){
        
        long diff = v-u;
        long cr = check(diff);
        if(cr!=-1)
        {
        	return cr;
        }
        else
        {
        		return (1+minDist(u+3,v));
        	
        }
    }
    static int[] Solution(long[][] arr,int n){
        // Write your code here
        long d=0;
        long u,v;
        long temp;
        int[] out = new int[n];
        for(int i=0;i<n;i++)
        {
            
             d = arr[i][0];
             u = arr[i][1];
             v = arr[i][2];
             
             if(u>d || v>d)
            {
                out[i]=-1;
                continue;
            
            }
            // u is small number v is big number
            if(u>v){ 
                temp = u;
                u =v;
                v=temp;
                
            }
            
            out[i] = (int) minDist(u,v);
            
        }
		return out;
        
    }
}