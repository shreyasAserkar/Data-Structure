import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class customSort {

	// main class begins
	public static void main(String[] args) throws Exception {
		quickSort quick = new quickSort();
		radixSort radix = new radixSort();
		input ip = new input();

		try {
		String fileName = args[0];
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int i;
		String input = br.readLine();
		BufferedWriter bw = new BufferedWriter(new FileWriter(input + ".txt"));
		System.out.println("Number of records : "+input);
		do {
			i = br.read();

			if (i != -1) {
				bw.write((char) i);
			}
		} while (i != -1);
		br.close();
		bw.close();

		fileName = input + ".txt";
		long overallStartTime = System.nanoTime();

		// Sort by Last name using quicksort
		String[] elementList1 = ip.inputArray("sortByLastName", fileName); // Gets
																			// the
																			// array
																			// of
																			// Lastname
		int low = 0;
		int high = elementList1.length;
		PrintStream fileStream = new PrintStream(new File("name_" + (high) + ".txt"));
		PrintStream fileStream1 = new PrintStream(new File("address_" + (high) + ".txt"));
		PrintStream fileStream2 = new PrintStream(new File("address_" + (high) + ".txt"));
		long startTime1 = System.nanoTime();
		quick.mainQuick(elementList1, low, high, "sortByLastName", fileStream); // Quick
																				// sort
																				// called
		long endTime1 = System.nanoTime();
		long duration1 = endTime1 - startTime1;
		System.out.println("\nTime taken by QuickSort to sort by Lastname : " + duration1 + " ns\n");

		// Sort by First name using quicksort
		String[] elementList = ip.inputArray("sortByFirstName", fileName); // Gets
																			// the
																			// array
																			// of
																			// Firstname
		long startTime = System.nanoTime();
		quick.mainQuick(elementList, low, high, "sortByFirstName", fileStream); // Quick
																				// sort
																				// called
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("\nTime taken by QuickSort to sort by Firstname : " + duration + " ns\n");

		// Sort by State using quicksort
		String[] elementList2 = ip.inputArray("sortByState", fileName); // Gets
																		// the
																		// array
																		// of
																		// State
		long startTime2 = System.nanoTime();
		quick.mainQuick(elementList2, low, high, "sortByState", fileStream1); // Quick
																				// sort
																				// called
		long endTime2 = System.nanoTime();
		long duration2 = endTime2 - startTime2;
		System.out.println("\nTime taken by QuickSort to sort by State : " + duration2 + " ns\n");

		// Sort by City using quicksort
		String[] elementList3 = ip.inputArray("sortByCity", fileName); // Gets
																		// the
																		// array
																		// of
																		// City
		long startTime3 = System.nanoTime();
		quick.mainQuick(elementList3, low, high, "sortByCity", fileStream1); // Quick
																				// sort
																				// called
		long endTime3 = System.nanoTime();
		long duration3 = endTime3 - startTime3;
		System.out.println("\nTime taken by QuickSort to sort by City : " + duration3 + " ns\n");

		// Sort by Zip Code using Radix Sort
		String[] elementList6 = ip.inputArray("sortByZipCode", fileName); // Gets
																			// the
																			// array
																			// of
																			// Zip
																			// code
		long startTime6 = System.nanoTime();
		radix.radixSort(elementList6); // Radix Sort called
		long endTime6 = System.nanoTime();
		long duration6 = endTime6 - startTime6;
		System.out.println("\nTime taken by RadixSort to sort by Zip Code : " + duration6 + " ns\n");
		fileStream1.close();

		// Sort by Street Address using quicksort
		String[] elementList5 = ip.inputArray("sortByAddress", fileName); // Gets
																			// the
																			// array
																			// of
																			// Street
																			// Address
		long startTime5 = System.nanoTime();
		quick.mainQuick(elementList5, low, high, "sortByAddress", fileStream2); // Quick
																				// sort
																				// called
		long endTime5 = System.nanoTime();
		long duration5 = endTime5 - startTime5;
		System.out.println("\nTime taken by QuickSort to sort by Street Address : " + duration5 + " ns\n");

		// Overall sorting time in micro seconds
		long overallEndTime = System.nanoTime();
		long totalDuration = overallEndTime - overallStartTime;
		long durationInus = TimeUnit.MICROSECONDS.convert(totalDuration, TimeUnit.NANOSECONDS);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("\nTOTAL TIME taken to sort all the records in the input : " + totalDuration + " ns or "
				+ durationInus + " us\n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("For more detailed reports, please check the output files.");

		
		 } catch (Exception e) {
		 System.out.println("Please enter correct file and try again....");
		 System.exit(0);
		 

		 }
	}
} // Main class ends
