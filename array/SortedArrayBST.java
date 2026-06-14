class sortedArrayBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    private TreeNode f(int[] a, int l, int r) {
        if (l > r) return null;

        int m = l + (r - l) / 2;

        TreeNode n = new TreeNode(a[m]);
        n.left = f(a, l, m - 1);
        n.right = f(a, m + 1, r);

        return n;
    }
}