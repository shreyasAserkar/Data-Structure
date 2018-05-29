import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class quickSort {

	private String[] array2;
	private int length1;
	private int lengthOfArray;
	private int low;
	private int high;
	private int count = 1;

	
	//Main method of quicksort class begins
	public void mainQuick(String[] arrays, int lower, int higher, String sortType, PrintStream print)
			throws IOException {
		// TODO Auto-generated method stub
		PrintStream pri;
		if (sortType.equals("sortByFirstName") || sortType.equals("sortByLastName")) {
			pri = new PrintStream(new File("name_" + (higher) + "_time" + ".txt"));

		} else {
			pri = new PrintStream(new File("address_" + (higher) + "_time" + ".txt"));
		}
		quickSort qs = new quickSort();
		String[] arrayToSort = null;
		arrayToSort = arrays;
		this.low = lower;
		this.high = higher;

		String[] sortedList = qs.sort(arrayToSort, low, high, pri);

		for (int i = 0; i < sortedList.length; i++) {
			if (sortType.equals("sortByFirstName")) {
				print.println(input.hmapFN.get(sortedList[i]));
			} else {
				if (sortType.equals("sortByLastName")) {
					print.println(input.hmapLN.get(sortedList[i]));
				} else {
					if (sortType.equals("sortByAddress")) {
						print.println(input.hmapAD.get(sortedList[i]));
					} else {
						if (sortType.equals("sortByCity")) {
							print.println(input.hmapCT.get(sortedList[i]));
						} else {
							if (sortType.equals("sortByState")) {
								print.println(input.hmapST.get(sortedList[i]));
							} else {
								if (sortType.equals("sortByZip")) {
									print.println(input.hmapZC.get(sortedList[i]));
								}
							}
						}
					}
				}
			}
		}

		print.close();
	}//Main method of quicksort class ends

	//Sort method starts
	private String[] sort(String[] arrayToSort, int l, int h, PrintStream pr) throws FileNotFoundException {
		// TODO Auto-generated method stub

		if (arrayToSort == null || arrayToSort.length == 0) {
			return null;
		}
		this.array2 = arrayToSort;
		lengthOfArray = arrayToSort.length;
		if (l < h) {

			long eachTime = System.nanoTime();

			int q = partition(arrayToSort, l, h);					//calls partition method

			sort(arrayToSort, l, q, pr);							//sort method on part 1
			sort(arrayToSort, q + 1, h, pr);						//sort method on part 2 
			
			long eachEndTime = System.nanoTime();
			long eachTotalDuration = eachEndTime - eachTime;
			long durationInus = TimeUnit.MICROSECONDS.convert(eachTotalDuration, TimeUnit.NANOSECONDS);
			pr.println(count + " " + durationInus+" us ");
			count++;
		}

		return arrayToSort;
	}//Sort method ends 

	
	//Partition method begins
	private int partition(String[] partitionArray, int lowerIndex, int higherIndex) {
		// TODO Auto-generated method stub
		int i = lowerIndex; // 0
		int j = higherIndex; // 9
		String pivot;
		int calc = lowerIndex + (higherIndex - lowerIndex) / 2; 			//partition
		double pivotPosition = Math.ceil((double) calc);
		int size = ((int) pivotPosition);
		pivot = array2[size];

		String x = partitionArray[lowerIndex];
		int ii = lowerIndex;
		int jj = higherIndex;

		while (ii < jj) {
			ii++;
			while (ii < higherIndex && array2[ii].compareTo(x) < 0)
				ii++;
			jj--;
			while (jj > lowerIndex && array2[jj].compareTo(x) > 0)
				jj--;

			if (ii < jj) {
				exchangeWords(ii, jj);
			} else
				return jj;
		}

		// fileStream.close();
		return size;
	}//Partition method ends

	
	//Exchange method to swap beings 
	private void exchangeWords(int i, int j) {
		// TODO Auto-generated method stub
		String swap = array2[i];
		array2[i] = array2[j];
		array2[j] = swap;
	}//Exchange method to swap ends

}
