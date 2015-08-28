/**
 * Thread to multiply one row of a matrix with all columns of another matrix
 * and store the result in a result matrix (1D array)
 * @author ayush
 *
 */
public class MultiplierThread implements Runnable {

	public int rowNumber;
	int arr[][];
	int arr2[][];
	int m,n,l;
	int result[];

	/**
	 * Constructor
	 * @param rowNumber Operate on this row of the 1st matrix
	 * @param arr First matrix
	 * @param arr2 Second matrix
	 * @param m 1st matrix's rows
	 * @param n 1st matrix's columns
	 * @param l 2nd matrix's columns
	 * @param result rowNumber'th row of result matrix
	 */
	public MultiplierThread(int rowNumber, int[][] arr, int[][] arr2, int m, int n, int l, int result[]) {
		super();
		this.rowNumber = rowNumber;
		this.arr = arr;
		this.arr2 = arr2;
		this.m = m;
		this.n = n;
		this.l = l;
		this.result = result;

	}


	@Override
	public void run() {
		
		// Initialize matrix to zero
		for(int i=0; i<l; i++){
			result[i] = 0;
		}

		// Perform actual multiplication of row of 1st matrix with columns of 2nd matrix
		// Store results in corresponding row of result matrix
		for(int i=0; i<l; i++){
			for(int j=0; j<n; j++){
				Util.println("Thread " + rowNumber + ", Loop : " + i + " " + j);
				Util.println("Thread " + rowNumber + ", Prev result " + result[i]);

				Util.println("Thread " + rowNumber + ", " + arr[rowNumber][j]);
				Util.println("Thread " + rowNumber + ", " + arr2[j][i]);

				Util.println("Thread " + rowNumber + ", " + arr[rowNumber][j]*arr2[j][i]);
				
				result[i] += arr[rowNumber][j]*arr2[j][i];

				Util.println("Thread " + rowNumber + ", Final result : " + result[i]);
			}

		}
		
		// Display results (for debugging only)
		for(int i=0; i<l; i++){
			Util.println("Thread " + rowNumber);
			Util.print(result[i] + " ");
		}
	}

}
