package com.twu.biblioteca;

import java.util.List;

/**
 * Created by ashleycampo on 6/23/14.
 */
public class LengthFinder {

    public int findLongestString(List<String> strings){
        int maxLen = 0;
        for (String string : strings){
            if(string.length() > maxLen){
                maxLen = string.length();
            }
        }
        return maxLen;
    }
}
