/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println("\n" + preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("\nsilent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		char letter1, letter2;
		boolean isAnAnagram = false;
		for (int i = 0; i < str1.length(); i++) {
			letter1 = str1.charAt(i);
			if (letter1 >= 32 && letter1 <= 47 && letter1 >= 58 && letter1 <= 64) {
				continue;
			}
			for (int j = 0; j < str2.length(); j++) {
				letter2 = str2.charAt(j);
				if (letter1 == letter2 || letter1 == letter2 +32 || letter1 == letter2 -32){
					isAnAnagram = true;

					break;
				} else {
					isAnAnagram = false;
				}
			}
	
			if (!isAnAnagram) break;
		}
		return isAnAnagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		char letter;
		for (int i = 0; i < str.length(); i++) {
			letter = str.charAt(i);
			if (letter >= 65 && letter <= 90) {
				letter += 32;
				newStr = newStr + letter;
			} else if (letter >= 97 && letter <= 122) {
				newStr = newStr + letter;
			} else if (letter == 32) {
				newStr = newStr + letter;
			}
		}

		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char letter1, letter2;
		String newString = "", smallerString = "";
		int randNum = 0;
		while (str.length() != 0) {
			smallerString = "";
			randNum = (int)(Math.random() * str.length());
			letter1 = str.charAt(randNum);
			//System.out.println("TEST:____ " + letter1 + randNum);
			if (letter1 == 32) {
				continue;
			}
			if (letter1 >= 65 && letter1 <= 90) {
				letter1 += 32;
			}
			newString = newString + letter1;
			for (int i = 0; i < str.length(); i++) {
				letter2 = str.charAt(i);
				if (letter1 != letter2) {
					smallerString = smallerString + letter2;
				}
			}
			str = smallerString;
		}
		return newString;
	}
}
