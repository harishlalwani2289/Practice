package harish.array;

public class ReversalAlgorithmArrayRotation {
	
	int[] reverseArray(int a[]){
		int temp,i;
		for(i=0;i<(a.length/2);i++)
		{
			temp = a[i];
			a[i] = a[a.length - (i +1)];
			a[a.length - (i +1)] = a[i];
		}
		
		return a;
		
	}
	
	public static void main(String[] args){
		ReversalAlgorithmArrayRotation rar = new ReversalAlgorithmArrayRotation();
		int a[] = {1,2,3,4,5,6};
		int b[] = rar.reverseArray(a);
	}

}
