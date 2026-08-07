class Solution {

    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {

        int[] freq = new int[10];

        solve(root, freq);

        return count;
    }

    public void solve(TreeNode root, int[] freq) {

        if (root == null)
            return;

        // Include current node
        freq[root.val]++;

        // Leaf node
        if (root.left == null && root.right == null) {

            int odd = 0;

            for (int i = 1; i <= 9; i++) {
                if (freq[i] % 2 != 0)
                    odd++;
            }

            if (odd <= 1)
                count++;

        } else {

            solve(root.left, freq);
            solve(root.right, freq);
        }

        // Backtrack
        freq[root.val]--;
    }
}