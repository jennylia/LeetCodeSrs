package dataStructures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void inOrderTraverse(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val);
        inOrderTraverse(root.left);
        inOrderTraverse(root.right);

    }
}
