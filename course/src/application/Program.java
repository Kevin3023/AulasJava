package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int [][] mat = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int x = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x == mat[i][j]) {
					System.out.printf("Position %d,%d:", i, j);
					
					if (j-1 >= 0 && j-1 <= 3) {
						System.out.printf("%nLeft: %d", mat[i][j-1]);
					}
					
					if (j+1 >= 0 && j+1 <= 3) {
						System.out.printf("%nRight: %d", mat[i][j+1]);
					}
					
					if (i-1 >= 0 && i-1 <= 3) {
						System.out.printf("%nUp: %d", mat[i-1][j]);
					}
					
					if (i+1 >= 0 && i+1 <= 3) {
						System.out.printf("%nDown: %d", mat[i+1][j]);
					}
					
					System.out.println();
				}
			}
		}
		
		
		sc.close();
	}

}
