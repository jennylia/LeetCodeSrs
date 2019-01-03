package com.company.medium;

import java.util.*;

public class Q916_WordSubset {
    public static void main(String[] args) {
        System.out.println("hello");
//        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] A = {"leetcode"};

        String[] B = {"e","oo"};

        List<String> ex1 = wordSubsets(A, B);
        System.out.println(ex1);

    }

    private static List<String> wordSubsets(String[] a, String[] b) {
        //reduce b to a single word, because each count of the letter in a has to be bigger than letters in b.
        Map<String, Integer> bSet = makeBIntoMaxMap(b);
        return getSuperWords(a, bSet);
    }

    public static List<String> getSuperWords(String[] a, Map<String, Integer> bSet) {
        List<String> superWords = new ArrayList<>();
        for (String s : a) {
            if (getsAllOfb(s, bSet)) {
                superWords.add(s);
            }
        }
        return superWords;

    }

    public static boolean getsAllOfb(String s, Map<String, Integer> bSet) {

        Map<String, Integer> wordCount = getWordCount(s);

        for (String bLetter : bSet.keySet()) {
            if (wordCount.containsKey(bLetter)) {
                Integer bCount = wordCount.get(bLetter);
                if (bCount == 0) {
                    return false;
                } else {
                    wordCount.put(bLetter, bCount - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static Map<String, Integer> makeBIntoMaxMap(String[] b) {
        Map<String, Integer> globalMaxMap = new HashMap<>();
        for (String s : b) {
            Map<String, Integer> wordCount = getWordCount(s);
            modifyglobalMaxMap(globalMaxMap, wordCount);
        }
        return globalMaxMap;
    }

    public static void modifyglobalMaxMap(Map<String, Integer> globalMaxMap, Map<String, Integer> wordCount) {
        for (String s : wordCount.keySet()) {
            int currentCount = wordCount.get(s);
            if (globalMaxMap.containsKey(s)) {
                int globalCount = globalMaxMap.get(s);
                if (globalCount > currentCount) {
                    globalMaxMap.put(s, currentCount);
                }
            } else {
                globalMaxMap.put(s, currentCount);
            }
        }
    }

    public static List<String> wordSubsetsOld(String[] A, String[] B) {
        List<String> superWords = new ArrayList<>();
        for (String w : A) {
            if (isSuperWord(w, B)) {
                superWords.add(w);
            }
        }
        return superWords;
    }

    private static boolean isSuperWord(String w, String[] b) {
        // turn w into a set.

        Map<String, Integer> wordCount = getWordCount(w);
        for (String candidate : b) {
            for (int i = 0; i < candidate.length(); i++) {
                String s = candidate.substring(i, i + 1);
                if (wordCount.containsKey(s)) {
                    int count = wordCount.get(s);
                    if (count == 0) {
                        return false;
                    }
                    wordCount.put(s, count - 1);
                } else {
                    return false;
                }
            }
            wordCount = getWordCount(w);
        }


        return true;
    }

    public static Map<String, Integer> getWordCount(String w) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            String s = w.substring(i, i + 1);
            if (wordCount.containsKey(s)) {
                int count = wordCount.get(s);
                wordCount.put(s, count + 1);
            } else {
                wordCount.put(s, 1);
            }
        }
        return wordCount;
    }
}
