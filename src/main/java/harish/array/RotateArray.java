package harish.array;

public class RotateArray {
	
	public void leftRotateArray(int arr[],int d,int n)
	{
		while(d>0){
			leftRotateArrayByOne(arr, n);
			d--;
		}
	}
	
	void leftRotateArrayByOne(int arr[],int n)
	{
		int i, temp;
		temp = arr[0];
		for(i=0;i<n-1;i++){
			arr[i] = arr[i+1];
		}
		arr[i] = temp;
		
	}
	
	void printArray(int arr[])
	{
		int i;
		for(i=0;i<arr.length;i++)
		{
			System.out.println(arr[i] + " ");
		}
	}
	
	public static void main(String args[])
	{
		RotateArray rotate = new RotateArray();
		int arr[] = {1,2,3,4,5,6,7};
		rotate.leftRotateArray(arr, 2, arr.length);
		rotate.printArray(arr);
	
	}

}
