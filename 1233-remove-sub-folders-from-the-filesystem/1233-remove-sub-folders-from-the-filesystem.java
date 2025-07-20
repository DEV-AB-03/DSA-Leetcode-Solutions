class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the folders
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        for (String current : folder) {
            if (result.isEmpty()) {
                result.add(current);
            } else {
                String prev = result.get(result.size() - 1);
                if (!isSubfolder(current, prev)) {
                    result.add(current);
                }
            }
        }

        return result;
    }

    // Helper function to check if current is a subfolder of prev using pointer-based comparison
    private boolean isSubfolder(String current, String prev) {
        int n = prev.length();

        // If current is shorter, it can't be a subfolder
        if (current.length() <= n)
            return false;

        // Compare character by character
        for (int i = 0; i < n; i++) {
            if (current.charAt(i) != prev.charAt(i)) {
                return false;
            }
        }

        // After prev, the next character must be '/'
        return current.charAt(n) == '/';
    }
}