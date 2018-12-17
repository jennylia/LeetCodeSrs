package com.company.easy.trees;

import dataStructures.TreeNode;

public class Q538_ConverBstToGreater {
    public static void main(String[] args) {

        //Sample Tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        TreeNode ans1 = convertBST(root);

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
//        root.right = new TreeNode(8, new TreeNode(6), new TreeNode(9));
//        TreeNode ans = convertBST(root);

        TreeNode.inOrderTraverse(root);

    }

    static int lastCompute = 0;

    class Solution {
        private int sum = 0; // Watch out this has to be private

        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }


    public static TreeNode convertBSTMine(TreeNode root) {
        if (root == null) {
            return null;
        }

//        convertBST(root.right);
        lastCompute += root.val;
        root.val = lastCompute;
//        convertBST(root.left);

        return root;
    }


//    private static void updateAndReturn(TreeNode root) {
//        getRightSum(root.val, root);
////        root.val += updateRight;
////        getRightSum(root.val, root.left);
//    }
//
//    private static int getRightSum(int parentVal, TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int rightSum = getRightSum(root.val, root.right);
//
//        if (parentVal > root.val) {
//            root.val += parentVal;
//        }
//        root.val += rightSum;
//
//        //TODO: verify
//        int leftSum = getRightSum(root.val, root.left);
//        return root.val + leftSum;
//    }
}
