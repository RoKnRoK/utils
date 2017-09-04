package com.rok.misc.utils;

import org.junit.Test;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class UserPassGeneratorTest {

    @Test
    public void testGenerate(){
        for (int i =0; i< 20; i++) {
            System.out.println(UserPassGenerator.generatePair());
        }
    }
}
