package com.rok.misc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class SyllableGenerator {
    private static final List<LetterType[]> patterns = new ArrayList<LetterType[]>();

    static {
        patterns.add(new LetterType[]{LetterType.VOWEL, LetterType.CONSONANT});
        patterns.add(new LetterType[]{LetterType.CONSONANT, LetterType.VOWEL});
        patterns.add(new LetterType[]{LetterType.VOWEL, LetterType.CONSONANT, LetterType.VOWEL});
        patterns.add(new LetterType[]{LetterType.CONSONANT, LetterType.VOWEL, LetterType.CONSONANT});
    }

    private static char[] VOWELS = new char[]{'a', 'o', 'e', 'i', 'y', 'u'};
    private static int VOWELS_COUNT = 6;
    private static char[] CONSONANTS = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z',};
    private static int CONSONANTS_COUNT = 18;

    public static String nextSyllable() {
        String result = "";
        int randomPatternIx = (int) (Math.random() * 100) % 4;
        LetterType[] pattern = patterns.get(randomPatternIx);
        int letterCount; char[] letterSet;
        for (LetterType letterType : pattern) {
            letterCount = (letterType == LetterType.VOWEL) ? VOWELS_COUNT : CONSONANTS_COUNT;
            letterSet = (letterType == LetterType.VOWEL) ? VOWELS : CONSONANTS;

            int letterIndex = (int)(Math.random()* 100) % letterCount;
            result += letterSet[letterIndex];
        }
        return result;
    }
}
