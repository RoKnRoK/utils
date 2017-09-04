package com.rok.misc.utils;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class UserPassGenerator {

    public static UserPassPair generatePair() {
        int randomNameLength = (int) (Math.random() * 100) % 3 + 2;
        int randomPassLength = (int) (Math.random() * 100) % 3 + 3;
        String userName = "", userPass = "";
        for (int i = 0; i < randomNameLength; i++) {
             userName += SyllableGenerator.nextSyllable();
        }
        for (int i = 0; i < randomPassLength; i++) {
            userPass += SyllableGenerator.nextSyllable();
        }
        return new UserPassPair(userName, userPass);
    }
}
