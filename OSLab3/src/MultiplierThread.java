
public class MultiplierThread implements Runnable {

	public int rowNumber;
	int arr[][];
	int arr2[][];
	int m,n,l;
	int result[];

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
		
		for(int i=0; i<l; i++){
			result[i] = 0;
		}

		for(int i=0; i<l; i++){
			for(int j=0; j<n; j++){
				Util.println("Loop : " + i + " " + j);
				Util.println("Prev result " + result[i]);

				Util.println(arr[rowNumber][j]);
				Util.println(arr2[j][i]);

				Util.println(arr[rowNumber][j]*arr2[j][i]);
				result[i] += arr[rowNumber][j]*arr2[j][i];

				Util.println("Final result : " + result[i]);
			}

		}

		for(int i=0; i<l; i++){
			Util.print(result[i] + " ");
		}
	}

}
