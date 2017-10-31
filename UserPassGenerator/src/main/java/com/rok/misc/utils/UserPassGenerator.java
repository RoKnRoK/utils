package com.rok.misc.utils;

import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class UserPassGenerator {

    public static Iterator<UserPassPair> generatePairIterator(final int count) {
        return new Iterator<UserPassPair>() {
            {
                setTotalCount(count);
            }
            private int totalCount = -1;
            private int currentCount = 0;

            public boolean hasNext() {

                return currentCount < totalCount;
            }

            public UserPassPair next() {
                currentCount++;
                return UserPassGenerator.generatePair();
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }
        };
    }

    public static Iterator<String[]> generatePairAsArrayIterator(final int count) {
        return new Iterator<String[]> () {
            private int totalCount = -1;
            private int currentCount = 0;

            {
                setTotalCount(count);
            }

            public boolean hasNext() {

                return currentCount < totalCount;
            }

            public String[] next() {
                currentCount++;
                UserPassPair userPassPair = UserPassGenerator.generatePair();
                return new String[]{userPassPair.getUsername(), userPassPair.getPassword()};
            }

            public void setTotalCount(int totalCount){
                this.totalCount = totalCount;
            }
        };
    }


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
