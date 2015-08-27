import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixMultiply {

	int arr[][];
	int arr2[][];
	int m,n,l,k;
	int result[];
	
	
	public MatrixMultiply() throws FileNotFoundException {
		
//		System.out.println("Enter the number of threads to be created: ");
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileReader("input1.txt"));
//		k = sc.nextInt();
		
		System.out.println("Enter m:");
		m = sc.nextInt();
		
		System.out.println("enter n: ");
		n = sc.nextInt();
		
		arr = new int[m][n];
		
		for(int i=0; i< m; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter l: ");
		l = sc.nextInt();
		
		arr2 = new int[n][l];
		
		for(int i=0; i< n; i++){
			for(int j=0; j<l; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		
		result = new int[l];
		
	}
	
	public void print(){
		
		for(int i=0; i<m; i++){
			System.out.println();
			for(int j=0; j<n; j++){
				System.out.print(arr[i][j] + " ");
			}
		}
		
		System.out.println("\nSecond array");
		for(int i=0; i<n; i++){
			System.out.println();
			for(int j=0; j<l; j++){
				System.out.print(arr2[i][j] + " ");
			}
		}
		
	}
	
	public void printResult(){
		System.out.println("Result length " + result.length);
		
		for(int i=0; i<l; i++){
			System.out.print( result[i] + " ");
		}
	}
	
	public void calculate(){
		MultiplierThread mul = new MultiplierThread(0, arr, arr2, m, n, l, k, result);
		Thread realThread = new Thread(mul);
		realThread.start();
		try {
			realThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printResult();
	}
	
}
