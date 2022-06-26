package in.mediumone.hackerrank;

import java.util.*;

/**
 * This code works for smaller input. For input string of length 10 and above it results in OOME.
 */
public class BiggerIsGreater {

    private static Map<String, List<String>> anagramStore = new HashMap<>();

    public static void main(String args[]) {
        System.out.println("Next is: " + biggerIsGreater("aaaab"));
        System.out.println("Next is: " + biggerIsGreater("dcba"));
        System.out.println("Next is: " + biggerIsGreater("dcbb"));
        System.out.println("Next is: " + biggerIsGreater("abdc"));
        System.out.println("Next is: " + biggerIsGreater("abcd"));
        System.out.println("Next is: " + biggerIsGreater("fedcbabcdijidjidjijcdij"));
    }

    public static String biggerIsGreater(String input) {

        char[] inputChars = input.toCharArray();

        System.out.println("Before sort: " + new String(inputChars));

        Arrays.sort(inputChars);

        System.out.println("After sort: " + new String(inputChars));


        List<String> anagrams = getAnagrams(inputChars);

//        for(String eachAna : anagrams) {
//            System.out.println(eachAna);
//        }

        int lastIndex = anagrams.lastIndexOf(input);

//        System.out.println("Last index: " + lastIndex);

        String result;

        if(lastIndex == (anagrams.size()-1)) {
            result = "no answer";
        } else {
            result =  anagrams.get(lastIndex + 1);
        }

//        System.out.println("Last index: " + lastIndex + " , result: " + result);

        return result;
    }

    //lmno -> lmno, lmon, lomn, lonm, lnmo, lnom
    private static List<String> getAnagrams(char[] inputChars) {

        System.out.println("Get Anagram called for: " + new String(inputChars));

        String inputString = new String(inputChars);

        if(anagramStore.containsKey(inputString)){

            System.out.println("Getting from cache for : " + inputString);

            return anagramStore.get(inputString);
        }

        List<String> anagrams = new ArrayList<>();

        if(inputChars.length == 1) {
            anagrams.add(String.valueOf(inputChars[0]));
            return anagrams;
        }

        for(int i = 0; i < inputChars.length; i++) {
            char thisChar = inputChars[i];

            char[] charsWithoutThisChar = getCharsWithoutThisChar(inputChars, i);

            List<String> subAnagrams = getAnagrams(charsWithoutThisChar);

            for(String eachSubAnagram : subAnagrams) {
                anagrams.add(thisChar + eachSubAnagram);
            }
        }

//        for(String anas : anagrams) {
//            System.out.println("For input: " + new String(inputChars) + ", anagram is: " + anas);
//        }

        anagramStore.put(inputString, anagrams);

        return anagrams;
    }

    private static char[] getCharsWithoutThisChar(char[] inputChars, int indexToSkip) {

        char[] subCharArray = new char[inputChars.length - 1];

        for(int i = 0, j = 0; i < inputChars.length; i++) {

            if(i == indexToSkip) {
                continue;
            } else {
                subCharArray[j] = inputChars[i];
                j++;
            }
        }

        return subCharArray;
    }

}
