class Solution {

    long maxProduct = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long totalSum = treeSum(root);
        computeMax(root, totalSum);
        return (int) (maxProduct % MOD);
    }

    // Step 1: Total sum of tree
    public long treeSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    // Step 2: Postorder to compute subtree sums + max product
    public long computeMax(TreeNode root, long totalSum) {
        if (root == null)
            return 0;

        long left = computeMax(root.left, totalSum);
        long right = computeMax(root.right, totalSum);

        long currSum = root.val + left + right;

        // simulate cutting above this subtree
        long product = currSum * (totalSum - currSum);
        maxProduct = Math.max(maxProduct, product);

        return currSum;
    }
}