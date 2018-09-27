package com.chaofan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the class to handle Regular expressions
 */
public class RegexHandler {
    /**
     * get all substring that match the pattern into a list of string
     * @param text the origin text to subtract
     * @param pattern the pattern for matching
     * @return a list of matched strings
     */
    public static List<String> matchAll(String text, String pattern) {
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(pattern).matcher(text);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }
}
