import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class input {

	static Map<String, String> hmapFN = new HashMap<String, String>();
	static Map<String, String> hmapLN = new HashMap<String, String>();
	static Map<String, String> hmapAD = new HashMap<String, String>();
	static Map<String, String> hmapCT = new HashMap<String, String>();
	static Map<String, String> hmapST = new HashMap<String, String>();
	static Map<String, String> hmapZC = new HashMap<String, String>();

	// inputArray class which returns entity array
	public static String[] inputArray(String element, String fileName) throws IOException {

		String token = " ";
		String firstName = null;
		String lastName = null;
		String[] name = null;
		String address = null;
		String city = null;
		String state = null;
		String zipCode = null;
		BufferedReader in;
		int count = 0;

		if (element.equals("sortByFirstName") || element.equals("sortByLastName")) {
			in = new BufferedReader(new FileReader(fileName)); // Writes in name file
																
		} else {
			in = new BufferedReader(new FileReader("name_" + fileName)); // Writes in address file
		}

		List<String> first = new ArrayList<String>();
		List<String> last = new ArrayList<String>();
		List<String> addr = new ArrayList<String>();
		List<String> cities = new ArrayList<String>();
		List<String> st = new ArrayList<String>();
		List<String> zip = new ArrayList<String>();
		while ((token = in.readLine()) != null) {

			// Record split by | delimted
			String[] information = token.split("\\|");
			if (information[0] != null || !information.equals("") || !information[0].equals("")
					|| !information[0].equals(null)) {
				name = information[0].split(" ");
				firstName = name[0];
				lastName = name[1];
				address = information[1];
				city = information[2];
				state = information[3];
				zipCode = information[4];
				hmapFN.put(firstName + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				hmapLN.put(lastName + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				hmapAD.put(address + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				hmapCT.put(city + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				hmapST.put(state + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				hmapZC.put(zipCode + "_" + count,
						firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode);
				first.add(firstName + "_" + count);
				last.add(lastName + "_" + count);
				addr.add(address + "_" + count);
				cities.add(city + "_" + count);
				st.add(state + "_" + count);
				zip.add(zipCode + "_" + count);
				count++;

			}
		}
		// Returns array from the element type
		if (element == "sortByFirstName") {
			String[] firstArrayList = first.toArray(new String[0]);
			return firstArrayList;
		} else {
			if (element == "sortByLastName") {
				String[] lastArrayList = last.toArray(new String[0]);
				return lastArrayList;
			} else {
				if (element == "sortByAddress") {
					String[] addrArrayList = addr.toArray(new String[0]);
					return addrArrayList;
				} else {
					if (element == "sortByCity") {
						String[] cityArrayList = cities.toArray(new String[0]);
						return cityArrayList;
					} else {
						if (element == "sortByState") {
							String[] stateArrayList = st.toArray(new String[0]);
							return stateArrayList;
						} else {
							if (element == "sortByZipCode") {
								String[] zipArrayList = zip.toArray(new String[0]);
								return zipArrayList;
							} else {
								return null;
							}
						}
					}
				}
			}
		}

	}
}
