package com.pondit.b4.leetcode.weekly_339;

public class LongestBalancedSubstringOfBinaryString {
    public static void main(String[] args) {
        String s = "0111100010";
        System.out.println(findTheLongestBalancedSubstring(s));
        s = "01000111";
        System.out.println(findTheLongestBalancedSubstring(s));
        s = "00111";
        System.out.println(findTheLongestBalancedSubstring(s));
        s = "001001010";
        System.out.println(findTheLongestBalancedSubstring(s));
        s = "111";
        System.out.println(findTheLongestBalancedSubstring(s));
    }

    private static int findTheLongestBalancedSubstring(String s) {
        int p1 = 0, c0 = 0, c1 = 0, maxLen = 0;
        while (p1 < s.length()) {
            for (int j = p1; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    c0++;
                } else if (s.charAt(j) == '1') {
                    c1++;
                }
                if (c0 < c1) {
                    p1 = ++j;
                    c0 = c1 = 0;
                    maxLen = Math.max(maxLen, Math.min(c0, c1) * 2);
                    break;
                }

                if (j+1 < s.length() && s.charAt(j) == '1' && s.charAt(j + 1) == '0') {
                    if (c0 == c1)
                        maxLen = Math.max(maxLen, c0 + c1);
                    else if (c0 > 0 && c1 > 0)
                        maxLen = Math.max(maxLen, Math.min(c0, c1) * 2);
                    p1 = ++j;
                    c0 = c1 = 0;
                    break;
                }

                if (j == s.length() && c0 > 0 && c1 > 0) {
                    maxLen = Math.max(maxLen, Math.min(c0, c1) * 2);
                    p1 = ++j;
                    c0 = c1 = 0;
                    break;
                }
            }
        }
        return maxLen;
    }

}
