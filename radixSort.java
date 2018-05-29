import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class radixSort {

	private static final int Alpha = 256;
	private static final int Beta = 0;
	private static final int BitsInInt = 32;
	private static final int Bits = 8;
	private static final int no = 0;

	
	//Radix Method main class begins
	public static void radixSort(String[] radixArray) throws FileNotFoundException {
		PrintStream fileStream1 = new PrintStream(new File("address_" + (radixArray.length) + ".txt"));
		int arraySize = radixArray.length;
		String[] radArr = new String[arraySize];
		sort(radixArray, 0, arraySize - 1, 0, radArr);						//Sort method called
		for (int i = 0; i < radixArray.length; i++) {
			fileStream1.println(input.hmapZC.get(radixArray[i]));
		}
		fileStream1.close();
		return;

	}//Radix Method main class ends

	
	//digit method begins
	private static int digit(String d1, int d2) {
		assert d2 >= 0 && d2 <= d1.length();
		if (d2 == d1.length())
			return -1;
		return d1.charAt(d2);
	}//digit method ends

	//Insert method begins
	private static void insert(String[] arr, int low, int high, int p) {
		for (int i = low; i <= high; i++)
			for (int j = i; j > low && low(arr[j], arr[j - 1], p); j--)
				interChange(arr, j, j - 1);						//Interchange called
	}//Insert method ends

	
	//Interchange method begins
	private static void interChange(String[] a, int i, int j) {
		String k = a[i];
		a[i] = a[j];
		a[j] = k;
	}//Interchange method ends

	//Low method begins
	private static boolean low(String a, String b, int c) {
		for (int i = c; i < Math.min(a.length(), b.length()); i++) {		//comparison at ith position done 
			if (a.charAt(i) < b.charAt(i))
				return true;
			if (a.charAt(i) > b.charAt(i))
				return false;
		}
		return a.length() < b.length();
	}//Low method ends

	
	
	//sort method begins
	private static void sort(String[] radixArray1, int lower, int higher, int m, String[] radArr1) {

		if (higher <= lower + Beta) {
			insert(radixArray1, lower, higher, m);				//Insert method called
			return;
		}

		int[] count = new int[Alpha + 2];
		for (int i = lower; i <= higher; i++) {
			int c = digit(radixArray1[i], m);					//digit method called
			count[c + 2]++;
		}

		for (int r = 0; r < Alpha + 1; r++)
			count[r + 1] += count[r];

		for (int i = lower; i <= higher; i++) {
			int c = digit(radixArray1[i], m);				//digit method called
			radArr1[count[c + 1]++] = radixArray1[i];
		}

		for (int i = lower; i <= higher; i++)
			radixArray1[i] = radArr1[i - lower];

		for (int k = 0; k < Alpha; k++)
			sort(radixArray1, lower + count[k], lower + count[k + 1] - 1, m + 1, radArr1); //sort method called again
	} //sort method ends

	
}
