class Pair {
    String seq;
    int steps;

    public Pair(String seq, int steps) {
        this.seq = seq;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        // Start BFS Approach
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair pair = pq.poll();
                String seq = pair.seq;
                int steps = pair.steps;
                if (seq.equals(endWord)) {
                    return steps;
                }
                // Replace every character present in seq and try to add words if present in wordlist
                for (int j = 0; j < seq.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] replacedCharArray = seq.toCharArray();
                        replacedCharArray[j] = ch;
                        String newWord = new String(replacedCharArray);
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            pq.offer(new Pair(newWord, steps + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }
}