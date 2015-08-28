import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Multiplies two matrices using multithreading
 * @author ayush
 *
 */
public class MatrixMultiply {

	/**
	 * The first matrix to be multiplied
	 */
	int arr[][];
	
	/**
	 * The second matrix to be multiplied
	 */
	int arr2[][];
	
	/**
	 * The dimensions of 1st matrix : m * n
	 * The dimensions of 2nd matrix : n * l
	 */
	int m,n,l;
	
	/**
	 * The resultant matrix. Dimensions : m * l
	 */
	int result[][];
	
	
	public MatrixMultiply() throws FileNotFoundException {
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileReader("input.txt"));
		
		System.out.println("Enter 1st matrix's m (rows): ");
		m = sc.nextInt();
		
		System.out.println("Enter 1st matrix's n (columns): ");
		n = sc.nextInt();
		
		arr = new int[m][n];
		
		// Get the first matrix
		for(int i=0; i< m; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter 2nd matrix's l (columns): ");
		l = sc.nextInt();
		
		arr2 = new int[n][l];
		
		//Get the second matrix
		for(int i=0; i< n; i++){
			for(int j=0; j<l; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		
		//Initialize result matrix with proper dimensions
		result = new int[m][l];
	}
	
	/**
	 * Print the matrices entered
	 */
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
	
	/**
	 * Print resultant matrix after multiplication
	 */
	public void printResult(){
		System.out.println("\n\nMultiplication result matrix : ");

		for(int i=0; i<m; i++){
			System.out.println();
			for(int j=0; j<l; j++){
				System.out.print(result[i][j] + " ");
			}
		}
	}
	
	/**
	 * Calculate the matrix multiplication using multiple threads
	 * A thread is created for each row of the 1st matrix.
	 * @throws InterruptedException
	 */
	public void calculate() throws InterruptedException{
		
		
		// Hold all threads in one structure
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i=0; i<m; i++){
			
			// Create thread
			MultiplierThread mul = new MultiplierThread(i, arr, arr2, m, n, l, result[i]);
			Thread t = new Thread(mul);
			
			// Add thread to ArrayList
			threads.add(t);
			
			// Start the thread
			t.start();
			Util.println(t.getName() + " is starting!");
		}
		
		// Wait for all threads to finish
		for(Thread t: threads){
			t.join();
		}
		
		printResult();		

	}
	
}
