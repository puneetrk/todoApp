package com.pumakuki.rest.webservices.restfulwebservices;
import java.io.*;
import java.util.*;


public class TestGoodRange {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        String input1 = br.readLine().trim();
	        String[] input = input1.split(" ");
	        long N = Long.parseLong(input[0]);
	        int M = Integer.parseInt(input[1]);
	        long [] X = new long[M];
	        for(int i=0;i<M;i++){
	            X[i] = Long.parseLong(br.readLine().trim());
	        }
	        
	        long[] out_ = getOutput(N,M,X);
	        
	        wr.close();
	        br.close();
	    }
	    static long[] getOutput(long N, int M,long[] X){
	        // Write your code here
	    	long[] out_ = new long[M];
	    	for(int i=0;i<M;i++) {
	    		
	    	}
	    	
	    	return out_;
	    }
	}


/*
 * 
10 10
2 
7
5
9
6
1
8
10
3
4
 * */
