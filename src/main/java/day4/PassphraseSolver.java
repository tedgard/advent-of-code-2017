package day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassphraseSolver {

    public int solveOnWordFrequencyBasis(List<String> passphrases) {
        int nbValidPassphrases = 0;
        for (String passphrase : passphrases) {
            if (getMaxWordFrequency(passphrase) == 1) nbValidPassphrases++;
        }
        return nbValidPassphrases;
    }


    public int solveOnWordFrequencyAndOnAnagramBasis(List<String> passphrases) {
        int nbValidPassphrases = 0;
        for (String passphrase : passphrases) {
            if (getMaxWordFrequency(passphrase) == 1) {
                if(!areThereAnagramsInThePassphrase(passphrase)) nbValidPassphrases++;
            }
        }
        return nbValidPassphrases;
    }

    private int getMaxWordFrequency(String passphrase) {

        int maxFrequency = 0;
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : passphrase.split(" ")) {
            Integer wordFrequency = wordFrequencyMap.get(word);

            if (wordFrequency == null) wordFrequency = 1;
            else wordFrequency++;

            wordFrequencyMap.put(word, wordFrequency);
            if (wordFrequency > maxFrequency) maxFrequency = wordFrequency;
        }
        return maxFrequency;
    }

    private boolean areThereAnagramsInThePassphrase(String passphrase) {

        Map<String, String> wordMap = new HashMap<>();
        for (String word : passphrase.split(" ")) {
            String sortedWord = getSortedWord(word);
            if (wordMap.get(sortedWord) != null) {
                return true;
            }
            wordMap.put(sortedWord, word);
        }
        return false;
    }

    private String getSortedWord(String word) {
        char[] wordToSort = word.toCharArray();
        Arrays.sort(wordToSort);
        return new String(wordToSort);
    }
}
