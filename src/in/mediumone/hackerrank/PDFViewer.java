package in.mediumone.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PDFViewer {

    public static void main(String[] args) {

    }

    public static int designerPdfViewer(String word) {
        // Write your code here
        List<Integer> heightsForCharsInWord = new ArrayList<>();

        for(int i=0; i < word.length(); i++) {
            char eachChar = word.charAt(i);

            int charIndex = eachChar - 'a';

            int charHeight = heightsForCharsInWord.get(charIndex);

            heightsForCharsInWord.add(charHeight);
        }

        int maxHeight = Collections.max(heightsForCharsInWord);

        return maxHeight * word.length();
    }
}
