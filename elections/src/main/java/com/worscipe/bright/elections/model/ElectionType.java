package com.worscipe.bright.elections.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Entity;

/**
 *   The Election Types are common social voting options, and voting systems documented 
 *   https://www.idea.int/data-tools/data/electoral-system-design
 */

public enum ElectionType {	
	UP_VOTE,
	REACTION_VOTE,
	UP_DOWN_VOTE,
	FIRST_PAST_THE_POST,
	BLOCK_VOTE,
	PARTY_BLOCK_VOTE,
	ALTERNATIVE_VOTE,
	TWO_ROUND_SYSTEM,
	LIST_PROPORTIONAL_REPRESENTATION,
	SINGLE_TRANSFERABLE_VOTE,
	MIXED_MEMBER_PROPORTIONAL_SYSTEM,
	PARALLEL_SYSTEM,
	SINGLE_NON_TRONSFERABLE_VOTE,
	LIMITED_VOTE,
	BORDA_COUNT;
	
	// https://stackoverflow.com/questions/1509614/check-valid-enum-values-before-using-enum/2546726#2546726 charlb answered Mar 28 '17 at 7:38
	public static boolean isValid(final String stringType) {
	    return Arrays.stream(ElectionType.values())
	        .map(ElectionType::name)
	        .collect(Collectors.toSet())
	        .contains(stringType);
	}
}
