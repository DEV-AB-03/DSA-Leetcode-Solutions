class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Greedy
        // Sort the arrays
        // Since its a 1-1 mapping, alloting a smaller rated player to a smaller rated coach makes sense, because we should save the bigger ones for future.
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;
        int match = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                // Allocate a match
                match++;
                i++;
                j++;
            } else {
                // Find a suitable trainer
                while (j < trainers.length && players[i] > trainers[j]) {
                    j++;
                }

                if (j < trainers.length) {
                    // Found a trainer
                    match++;
                    i++;
                    j++;
                }
            }
        }

        return match;
    }
}