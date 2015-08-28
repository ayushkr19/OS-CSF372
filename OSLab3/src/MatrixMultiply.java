import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrixMultiply {

	int arr[][];
	int arr2[][];
	int m,n,l;
	int result[][];
	
	
	public MatrixMultiply() throws FileNotFoundException {
		
//		System.out.println("Enter the number of threads to be created: ");
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileReader("input.txt"));
//		k = sc.nextInt();
		
		System.out.println("Enter 1st matrix's m (rows): ");
		m = sc.nextInt();
		
		System.out.println("Enter 1st matrix's n (columns): ");
		n = sc.nextInt();
		
		arr = new int[m][n];
		
		for(int i=0; i< m; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter 2nd matrix's l (columns): ");
		l = sc.nextInt();
		
		arr2 = new int[n][l];
		
		for(int i=0; i< n; i++){
			for(int j=0; j<l; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		
		result = new int[m][l];
	}
	
	public void print(){
		
		System.out.println("First matrix entered : ");
		for(int i=0; i<m; i++){
			System.out.println();
			for(int j=0; j<n; j++){
				System.out.print(arr[i][j] + " ");
			}
		}
		
		System.out.println("\n\nSecond matrix entered : ");
		for(int i=0; i<n; i++){
			System.out.println();
			for(int j=0; j<l; j++){
				System.out.print(arr2[i][j] + " ");
			}
		}
		
	}
	
	public void printResult(){
		System.out.println("\n\nMultiplication result matrix : ");

		for(int i=0; i<m; i++){
			System.out.println();
			for(int j=0; j<l; j++){
				System.out.print(result[i][j] + " ");
			}
		}
	}
	
	public void calculate() throws InterruptedException{
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<m; i++){
			MultiplierThread mul = new MultiplierThread(i, arr, arr2, m, n, l, result[i]);
			Thread t = new Thread(mul);
			threads.add(t);
			t.start();
			Util.println(t.getName() + " is starting!");
		}
		
		for(Thread t: threads){
			t.join();
		}
		
		printResult();		

	}
	
}
