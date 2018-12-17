package com.company.easy.trees;

import dataStructures.TreeNode;

public class Q108_ConcertIntoBinaraySearch {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {};
        TreeNode root = s.sortedArrayToBST(input);
        System.out.println(root.toString());
    }


    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // find th middle
            if (nums.length == 0){
                return null;
            }
            int midIndex = nums.length / 2;
            TreeNode root = new TreeNode(nums[midIndex]);

            //Left subarray
            int[] leftSub = subArray(0, midIndex, nums);
            int[] rightSub = subArray(midIndex + 1, nums.length, nums);

            root.left = sortedArrayToBST(leftSub);
            root.right = sortedArrayToBST(rightSub);

            return root;
        }

        private int[] subArray(int start, int endExclusive, int[] nums) {
            int length = endExclusive - start;
            if (length == 0){
                return new int[0];
            }
            int[] ans = new int[length];
            for (int i = 0; i <length ; i ++){
                ans[i] = nums[start];
                start ++;
            }
            return ans;
        }
    }
}
