package com.revature.minimumMutation.java.core;

public class minimumMutation {

	public static int minimumMutation(String start, String end, String[] bank) {
		StringBuilder strBuilderStart = new StringBuilder(start);
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		System.out.println("Bank: " + bank);
		System.out.println("SBS original: " + strBuilderStart);

		// Check the length of the sequences
		if (start.length() == 8 && end.length() == 8) {
			// if the start sequence equals the stop sequence, return 0
			if (start == end) {
				System.out.println("0");
				return 0;
			} else {
				// sets a counter with a value of 0
				int counter = 0;
				// runs through each index of strBuilderStart
				for (int i = 0; i < strBuilderStart.length(); i++) {
					// if the character at the index in the start equals the character at the same
					// index in stop, do nothing
					if (strBuilderStart.charAt(i) == end.charAt(i)) {
					} else {
						// if the character at the index in stop equals the same index in any of the
						// cases, replace
						// the character in strBuilderStart
						if (end.charAt(i) == bank[0].charAt(i)) {
							strBuilderStart.setCharAt(i, bank[0].charAt(i));
							System.out.println(strBuilderStart);
							// add one two the counter
							counter++;
						} else if (end.charAt(i) == bank[1].charAt(i)) {
							strBuilderStart.setCharAt(i, bank[1].charAt(i));
							System.out.println(strBuilderStart);
							// add one two the counter
							counter++;
						} else if (end.charAt(i) == bank[2].charAt(i)) {
							strBuilderStart.setCharAt(i, bank[2].charAt(i));
							System.out.println(strBuilderStart);
							// add one two the counter
							counter++;
						} else {
							// if there are no matches
							System.out.println("No Such Mutation: -1");
							return -1;
						}
					}
				}
				System.out.println("SBS final: " + strBuilderStart);
				System.out.println("Counter:" + counter);
				return counter;
			}
		} else {
			//If there is invalid input
			System.out.println("Invalid Input");
			return 0;
		}
	}
}
