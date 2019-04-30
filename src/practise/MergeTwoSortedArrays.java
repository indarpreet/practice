package practise;

public class MergeTwoSortedArrays {
	
	public static void main(String[] args) {
		

	int a[] = new int [5];
	
	 a[0]= 1;
			 a[1]= 3;
					 a[2]= 5;
							 a[3]= 7;
									 a[4]= 9;
									 
	int b[] = { 2, 3 , 6 , 8, 10};
	
	int c[] = new int [a.length + b.length];
	int i= 0 , j = 0 , k=0;
	
	while(i < a.length){
		if( j < b.length){
		if(a[i] < b[j] ){
			c[k] = a[i];
			i++;
			k++;
		}else if(a[i]>b[j]){
			c[k] = b[j];
			j++;
			k++;
		}else{
			c[k] = a[i];
			c[k+1] = a[i];
			k += 2;
			i++;
			j++;
		}
		}else{
			c[k] = a[i];
			i++;
		}
	}
	while(j<b.length){
		c[k] = b[j];
		j++;
		k++;
	}
	
	for(int z : c){
		System.out.println(z);
	}
	
	}
	
	
}
