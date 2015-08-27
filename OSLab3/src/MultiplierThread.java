
public class MultiplierThread implements Runnable {

	public int rowNumber;
	int arr[][];
	int arr2[][];
	int m,n,l,k;
	int result[];
	
	public MultiplierThread(int rowNumber, int[][] arr, int[][] arr2, int m, int n, int l, int k,int result[]) {
		super();
		this.rowNumber = rowNumber;
		this.arr = arr;
		this.arr2 = arr2;
		this.m = m;
		this.n = n;
		this.l = l;
		this.k = k;
		this.result = result;
		
	}

	
	@Override
	public void run() {
		
		for(int i=0; i<l; i++){
			result[i] = 0;
		}
		System.out.println("\n" + result.length);
		
		for(int i=0; i<l; i++){
			for(int j=0; j<n; j++){
				System.out.println("Loop : " + i + " " + j);
				System.out.println("Prev result " + result[i]);
				
				System.out.println(arr[rowNumber][j]);
				System.out.println(arr2[j][i]);
				
				System.out.println(arr[rowNumber][j]*arr2[j][i]);
				result[i] += arr[rowNumber][j]*arr2[j][i];
				
				System.out.println("Final result : " + result[i]);
			}

		}
		
		for(int i=0; i<l; i++){
			System.out.print(result[i] + " ");
		}
	}
	
}
