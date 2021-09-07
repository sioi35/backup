package practice;

public class Sort {
	
	public static void main(String[] args) {
		
		int[] array = new int[10];
		
		for(int i=0; i<10; i++) {
			array[i] = (int)(Math.random() * 100) + 1;
		}
		
		bubble(array);
		selection(array);
		insertion(array);
		
		
		
	}

	private static void insertion(int[] a) {
		
		for(int i=1; i<a.length; i++) {
			int temp = a[i];
			for(int j=i-1; j>=0 && a[j]>temp; j--) {
				a[j+1] = a[j];
				a[j+1] = temp;
			}
		}
		System.out.println("=======================");
		for(int i=0; i<10; i++) {
			System.out.println(a[i]);
		}
		
	}

	private static void selection(int[] a) {
		
		int minIndex;
		
		for(int i=0; i<a.length-1; i++) {
			minIndex = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}
				
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
				
			}
		}
		System.out.println("=======================");
		for(int i=0; i<10; i++) {
			System.out.println(a[i]);
		}
	}

	private static void bubble(int[] array) {

		for(int i=array.length-1; i>0; i--) {
			
			for(int j=0; j<i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			
		}
		
		
		System.out.println("=======================");
		for(int i=0; i<10; i++) {
			System.out.println(array[i]);
		}
		
	}
	
	
	
	
}
