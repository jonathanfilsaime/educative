package com.company;

import java.util.*;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {

        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        backspaceRemove(str1, stringBuilder1);
        backspaceRemove(str2, stringBuilder2);

        return stringBuilder1.toString().equalsIgnoreCase(stringBuilder2.toString());
    }

    public static void backspaceRemove(String str, StringBuilder strBuilder) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            strBuilder.append(stack.pop());
        }
        strBuilder.reverse();
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
