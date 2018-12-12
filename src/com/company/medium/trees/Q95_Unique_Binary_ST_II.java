/*
package com.company.medium.trees;

import dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q95_Unique_Binary_ST_II {
//    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.


    public static void main(String[] args) {
        System.out.println("hi this is a ");


    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            List<TreeNode> listTreeNode = formTreeNodeHelper(i, n);
            ans.addAll(listTreeNode);
        }

        return ans;
    }

    private List<TreeNode> formTreeNodeHelper(int start, int n) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i < start) {
                left.add(i);
            } else {
                right.add(n);
            }
        }

        Integer startVal = new Integer(start);
        List<TreeNode> listTreeNode = formTreeNodeHelper(startVal, left, right);
        return listTreeNode;
    }

    private List<TreeNode> formTreeNodeHelper(Integer start, List<Integer> left, List<Integer> right) {
        List<TreeNode> ans = new ArrayList<>();

        if (start == null) {
            return null;
        }

        TreeNode tn = new TreeNode(start);

        List<TreeNode> validLeftSubTrees = generateSubTrees(left);
//        List<TreeNode> validLeftSubTrees = generateSubTrees(right);

        return ans;
    }

    private List<TreeNode> generateSubTrees(List<Integer> peers) {
        List<TreeNode> tnAns = new ArrayList<>();
        for (Integer i : peers){
            TreeNode tn = generateTrees(i, peers);
            tnAns.add(tn);
        }
        return tnAns;

    }

//    private TreeNode generateTrees(Integer i, List<Integer> peers) {
//        if (i == null){
//            return null;
//        }
//        TreeNode root = new TreeNode(i);
//        for (Integer p: peers){
//            if (p < i){
//                add_to_tree
//            }
//        }
//
//        return root;
//    }

    private List<Integer> getBiggerThanList(Integer s, List<Integer> right) {
        List<Integer> bigger = new ArrayList<>();
        for (Integer i : right){
            if (i > s){
                bigger.add(s);
            }
        }
        return bigger;
    }

    private List<Integer> getSmallerThanList(Integer s, List<Integer> left) {
        List<Integer> smaller = new ArrayList<>();
        for (Integer i : left){
            if (i < s){
                smaller.add(s);
            }
        }
        return smaller;
    }
}
*/
