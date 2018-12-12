package com.company.medium.trees;

import dataStructures.TreeNode;

public class TreeExcercise {
    public static void main(String[] args) {
        System.out.println("Create a BST from an array");
        int[] input = {3, 1, 2, 4, 5};
        TreeNode treeNode = createATree(input);
//        traverseAndPrint(treeNode);
//        inOrderTraverse(treeNode);
        postOrderTraverse(treeNode);
        preOrderTraverse(treeNode);
    }

    private static void preOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println("Val: " + treeNode.val);

        inOrderTraverse(treeNode.left);
        inOrderTraverse(treeNode.right);
    }

    private static void postOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrderTraverse(treeNode.left);
        inOrderTraverse(treeNode.right);
        System.out.println("Val: " + treeNode.val);

    }

    private static void inOrderTraverse(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrderTraverse(treeNode.left);
        System.out.println("Val: " + treeNode.val);
        inOrderTraverse(treeNode.right);

    }

    //    private static void
    private static void traverseAndPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
//        String nodeString = treeNode.toString();
        System.out.println(treeNode.val + "\n left:" + treeNode.left + "right: " + treeNode.right);
        traverseAndPrint(treeNode.left);
        traverseAndPrint(treeNode.right);
    }

    private static TreeNode createATree(int[] input) {
        if (input.length == 0) {
            return null;
        }
        int rootVal = input[0];
        TreeNode root = new TreeNode(input[0]);
        for (int i = 1; i < input.length; i++) {
            TreeNode curNode = new TreeNode(input[i]);
            if (i < rootVal) {
                insertLeft(root, curNode);
            } else {
                insertRight(root, curNode);
            }
        }
        return root;
    }

    private static void insertLeft(TreeNode root, TreeNode curNode) {
        if (root.left == null) {
            root.left = curNode;
            return;
        }
        root = root.left;
        if (root.val > curNode.val) {
            insertLeft(root, curNode);
        } else {
            insertRight(root, curNode);
        }
    }

    private static void insertRight(TreeNode root, TreeNode curNode) {
        if (root.right == null) {
            root.right = curNode;
            return;
        }
        root = root.right;
        if (root.val > curNode.val) {
            insertLeft(root, curNode);
        } else {
            insertRight(root, curNode);
        }
    }
}
