package com.revature.minimumMutation.java.core;

import com.revature.minimumMutation.java.core.minimumMutation.*;

public class MinimumMutationDriver {

	public static void main(String[] args) {
		String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		minimumMutation.minimumMutation("AACCGGTT", "AAACGGTA", bank);
		
	}
}
