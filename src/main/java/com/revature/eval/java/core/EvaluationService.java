package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String s1 = string;
		String s2 = "";
		
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			s2 = String.valueOf(c) + s2;
		}
		
		return s2;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// Any letter immediately following a space or hyphen will be added
		// to the acronym.
		String acronym = "";
		boolean whiteSpaceFlag = true; // to detect spaces and hyphens
		
		for (int i = 0; i < phrase.length(); i++) {
			char c = phrase.charAt(i);
			
			if (whiteSpaceFlag == true) {
				acronym = acronym + Character.toUpperCase(c) + "";
				whiteSpaceFlag = false;
			}
			else {
				if (c == ' ' || c == '-') {
					whiteSpaceFlag = true;
				}
			}
		}
		
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if (isEquilateral() == true) {
				return false;
			}
			if (this.sideOne == this.sideTwo) {
				return true;
			}
			if (this.sideOne == this.sideThree) {
				return true;
			}
			if (this.sideTwo == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			if (isEquilateral() == true) {
				return false;
			}
			if (isIsosceles() == true) {
				return false;
			}
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		char[] letters = {'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't', 'd', 'g',
				'b', 'c', 'm', 'p', 'f', 'h', 'v', 'w', 'y', 'k', 'j', 'x', 'q', 'z'};
		int[] scores = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4,
				5, 8, 8, 10, 10};
		int score = 0;
		
		for (int i = 0; i < string.length(); i++) {
			char c = Character.toLowerCase(string.charAt(i));
			
			for (int j = 0; j < letters.length; j++) {
				if (c == letters[j]) {
					score += scores[j];
				}
			}
			
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
		String formattedNumber = "";
		
		// Remove all punctuation from phone number.
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			
			if (Character.isDigit(c)) {
				formattedNumber = formattedNumber + String.valueOf(c);
			}
		}
		
		// Determine if the phone number is valid.
		// A phone number must be exactly 10 digits long.
		int phoneLength = 10;
		if (formattedNumber.length() != phoneLength) {
			throw new IllegalArgumentException();
		}
		
		return formattedNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordcount = new HashMap<>();
		String word = ""; // a temporary word holder
		
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			
			if (c == ' ' || c == ',' || c == '\n') {
				if (word != "") {
					if (wordcount.containsKey(word)) {
						wordcount.put(word, wordcount.get(word) + 1);
					} else {
						wordcount.put(word, 1);
					}
					
					word = "";
				}
			} else {
				word = word + Character.toString(c);
			}
			
		}
		
		// Adding final word. I would put this paste in a function, but then I didn't.
		if (wordcount.containsKey(word)) {
			wordcount.put(word, wordcount.get(word) + 1);
		} else {
			wordcount.put(word, 1);
		}
		
		return wordcount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		public int indexOf(T t) {
			// Implement binary search method. Assumes element is present in list.
			int min = 0;
			int max = sortedList.size() - 1;
			int mid = (min + max)/2;
			
			T num = t;
			T val = sortedList.get(mid);
			
			while (true) {
				val = sortedList.get(mid);
				int numCompare = num.hashCode() - val.hashCode();
				if (numCompare < 0) {
					max = mid - 1;
					mid = (min + max)/2;
				}
				else if (numCompare > 0) {
					min = mid + 1;
					mid = (min + max)/2;
				}
				else {
					return mid;
				}
			}
			
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] words = string.split(" ");
		String[] vowels = {"a", "e", "i", "o", "u"};
		String answer = "";
		String translation = "";
		char prev = 'a';
		
		for (String word: words) {
			boolean vowelFlag = false;
			
			for (int i = 0; i < word.length(); i++) {
				if (vowelFlag == false) { 
					for (String vowel: vowels) {
						// Special case "qu" (treat u as consonant if after q"
						if (word.charAt(i) == 'u') {
							if (prev == 'q') {
								vowelFlag = true;
								translation = word.substring(i+1) + word.substring(0, i+1);
								answer = answer + translation + "ay ";
							}
						}
						if (vowel.charAt(0) == word.charAt(i) && vowelFlag == false) { // detects vowel
							vowelFlag = true;
							translation = word.substring(i) + word.substring(0, i);
							answer = answer + translation + "ay ";
						}
						prev = word.charAt(i);
					}
				}
			}
		}
		
		// Remove the extra whitespace at the end.
		answer = answer.substring(0, answer.length() - 1);
		
		return answer;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// Store digits, determine number of digits.
		int origInput = input;
		int digitCount = 0;
		ArrayList<Integer> digits = new ArrayList<>();
		while (input != 0) {
			digits.add(input % 10);
			digitCount += 1;
			input = input / 10;
		}
		
		int sum = 0;
		for (int i = 0; i < digits.size(); i++) {
			sum = (int) (sum + Math.pow(digits.get(i), digitCount));
		}
		return sum == origInput;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		int num = (int) l;
		List<Long> factors = new ArrayList<Long>();
		int factor = 2;
		
		while (true) {
			if (isPrime(factor)) {
				if (num % factor == 0) { // is factor and prime
					factors.add((long) factor);
					if (num == factor) {
						break;
					}
					else {
						num = num / factor;
						factor = 1; // takes increment into account.
					}
				}
			}
			factor++;
		}

		return factors;
	}
	
	public boolean isPrime(int num) { // Code taken from isPrime google search.
		boolean isPrime = true;
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                isPrime = false;
                break;
            }
        }
		return isPrime;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String cipheredWord = "";
			char[] lowerAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
								 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
								 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
								 'y', 'z'};
			char[] upperAlphabet = {'A', 'B', 'C', 'D', 'E', 'F',
					 			 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
					 			 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					 			 'W', 'X', 'Y', 'Z'};
			int index = 0;
			char[] chars = string.toCharArray();

			for (char ch : chars) {
				if (ch == ' ' || ch == '!' || ch == ',' || ch == '\'' || ch == '.' || Character.isDigit(ch)) {
					cipheredWord = cipheredWord + Character.toString(ch);
					}
				else {
					for (int i = 0; i < lowerAlphabet.length; i++) {
						if (ch == lowerAlphabet[i]) {
							index = i;
							index = (index + this.key) % 26;
							cipheredWord = cipheredWord + Character.toString(lowerAlphabet[index]);
							break;
						}
						else if (ch == upperAlphabet[i]) {
							index = i;
							index = (index + this.key) % 26;
							cipheredWord = cipheredWord + Character.toString(upperAlphabet[index]);
							break;
						}
					}
				}
			}
			
			return cipheredWord;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		int n = i; // Code from college, go tartans.
		if (n == 0) {
			throw new IllegalArgumentException("Bad argument.");
		}
		
		int found = 0;
		int guess = 0;
		while (found <= n) {
			guess += 1;
			if (isPrime(guess)) {
				found += 1;
			}
		}
		return guess;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String ciphered = "";
			char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
								 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
								 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
								 'y', 'z'};
			char[] backwardsAlphabet = {'z', 'y', 'x', 'w', 'v', 'u', 't',
										's', 'r', 'q', 'p', 'o', 'n', 'm',
										'l', 'k', 'j', 'i', 'h', 'g', 'f', 
										'e', 'd', 'c', 'b', 'a'};
			string = string.toLowerCase();
			char[] characters = string.toCharArray();
			int count = 1;
			
			for (char ch: characters) {
				for (int i = 0; i < alphabet.length; i++) {
					if (ch == alphabet[i]) {
						ciphered = ciphered + Character.toString(backwardsAlphabet[i]);
						if (count == 5) {
							ciphered = ciphered + " ";
							count = 1;
						}
						else {
							count++;
						}
						break;
					}
				}
				if (Character.isDigit(ch)) {
					ciphered = ciphered + Character.toString(ch);
					if (count == 5) {
						ciphered = ciphered + " ";
						count = 1;
					}
					else {
						count++;
					}
				}
			}
			
			// Fix trailing whitespaces.
			if (ciphered.toCharArray()[ciphered.length() - 1] == ' ') {
				ciphered = ciphered.substring(0, ciphered.length() - 1);
			}
			
			return ciphered;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String ciphered = "";
			char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
								 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
								 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
								 'y', 'z'};
			char[] backwardsAlphabet = {'z', 'y', 'x', 'w', 'v', 'u', 't',
										's', 'r', 'q', 'p', 'o', 'n', 'm',
										'l', 'k', 'j', 'i', 'h', 'g', 'f', 
										'e', 'd', 'c', 'b', 'a'};
			char[] characters = string.toCharArray();
			
			for (char ch: characters) {
				for (int i = 0; i < backwardsAlphabet.length; i++) {
					if (ch == backwardsAlphabet[i]) {
						ciphered = ciphered + Character.toString(alphabet[i]);
					}
				}
				if (Character.isDigit(ch)) {
					ciphered = ciphered + Character.toString(ch);
				}
			}
			return ciphered;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		char[] characters = string.toCharArray();
		String cleanString = "";
		int x1; int x2; int x3; int x4; int x5; int x6; int x7; int x8; int x9; int x10;
		
		// Clean out hyphens.
		for (char c: characters) {
			if (c != '-') {
				cleanString = cleanString + Character.toString(c);
			}
		}
		
		char[] cleanChars = cleanString.toCharArray();
		
		// Check index 9 for validity.
		char ind9 = cleanChars[9];
		if (Character.isDigit(ind9) || ind9 == 'X') { // If last digit is X or number, calculate formula.
			x1 = Character.getNumericValue(cleanChars[0]);
			x2 = Character.getNumericValue(cleanChars[1]);
			x3 = Character.getNumericValue(cleanChars[2]);
			x4 = Character.getNumericValue(cleanChars[3]);
			x5 = Character.getNumericValue(cleanChars[4]);
			x6 = Character.getNumericValue(cleanChars[5]);
			x7 = Character.getNumericValue(cleanChars[6]);
			x8 = Character.getNumericValue(cleanChars[7]);
			x9 = Character.getNumericValue(cleanChars[8]);
			
			if (ind9 == 'X') {
				x10 = 10;
			} else {
				x10 = Character.getNumericValue(cleanChars[9]);
			}
		}
		else {
			return false;
		}
		
		int validation = (x1*10 + x2*9 + x3*8 + x4*7 + x5*6 + x6*5
				+ x7*4 + x8*3 + x9*2 + x10*1) % 11;

		return validation == 0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				 'y', 'z'};
		char[] characters = string.toCharArray();
		int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		// Keep a count of all the letters that appear.
		for (char ch: characters) {
			for (int i = 0; i < alphabet.length; i++) {
				if (ch == alphabet[i]) {
					count[i] = count[i] + 1;
				}
			}
		}
		
		// Check if all letters have appeared at least once.
		for (int score: count) {
			if (score == 0) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40)
		// LocalDateTime.of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
		// LocalDateTime plusDays(long days)
		int gigasecond = 1000000000;
//		given.plus(Period.ofDays());
		Temporal updatedTime = given.plus(gigasecond, ChronoUnit.SECONDS);
		return updatedTime;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int multipleSum = 0;
		ArrayList<Integer> existingMultiples = new ArrayList<Integer>();
		
		for (int multiple: set) {
			int factor = multiple;
			while (factor < i) {
				if (!existingMultiples.contains(factor)) {
					existingMultiples.add(factor);
					multipleSum += factor;
				}
				factor += multiple;
			}
		}
		
		return multipleSum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		char[] characters = string.toCharArray();
		String cleanString = "";
		
		// Punctuation is invalid. Extract numbers.
		for (char c: characters) {
			if (Character.isWhitespace(c)) { continue; }
			else if (!Character.isDigit(c)) {
				return false;
			}
			else {
				cleanString = cleanString + Character.toString(c);
			}
		}
		
		System.out.println(cleanString);
		char[] cleanChars = cleanString.toCharArray();
		
		// 1 (odd length) 0 (even length)
		int sum = 0;
		for (int i = 0; i < cleanChars.length; i++) {
			int num = Integer.parseInt(Character.toString(cleanChars[i]));
			if (cleanChars.length % 2 == 1) {
				if (i % 2 == 1) {
					num = 2*num;
					if (num > 9) { num -= 9; }
				}
			}
			else {
				if (i % 2 == 0) {
					num = 2*num;
					if (num > 9) { num -= 9; }
				}
			}
			sum += num;
		}
		
		System.out.println(sum);
		return sum % 10 == 0;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
