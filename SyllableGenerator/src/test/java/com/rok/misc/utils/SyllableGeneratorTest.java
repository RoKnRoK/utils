package com.rok.misc.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class SyllableGeneratorTest {

    @Test
    public void testGenerate() {
        String syllable = SyllableGenerator.nextSyllable();
        Assert.assertNotEquals(syllable, "");
    }

    @Test
    public void testGenerateSet() {

        for (int i = 0; i < 20; i++) {
            System.out.println(SyllableGenerator.nextSyllable());
        }

    }
}
