class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] highestFrequencyOfCharacters = buildHighestFrequency(words2);

        for (String word : words1) {
            boolean isSubSet = true;
            int[] currentFrequency = getFrequencyOfCharacters(word);
            for (int i = 0; i < 26; i++) {
                if (currentFrequency[i] < highestFrequencyOfCharacters[i]) {
                    isSubSet = false;
                    break;
                }
            }
            if (isSubSet) result.add(word);
        }

        return result;
    }

    private int[] buildHighestFrequency(String[] words2) {
        int[] frequencyOfCharacters = new int[26];
        for (String word : words2) {
            int[] currentFrequencyOfWord = getFrequencyOfCharacters(word);
            for (int i = 0; i < 26; i++)
                frequencyOfCharacters[i] = Math.max(
                        frequencyOfCharacters[i], currentFrequencyOfWord[i]);
        }
        return frequencyOfCharacters;
    }

    private int[] getFrequencyOfCharacters(String word1) {
        int[] frequencyOfCharacters = new int[26];
        for (char c : word1.toCharArray()) frequencyOfCharacters[c - 'a']++;
        return frequencyOfCharacters;
    }
}