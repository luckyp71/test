package no_1;

import java.util.Scanner;

public class Solution {
	
	public static void main(String... args) {
		
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number: ");
        int n = in.nextInt();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<n-1-i){
                    System.out.print(" ");
                }else{
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
	}
}
