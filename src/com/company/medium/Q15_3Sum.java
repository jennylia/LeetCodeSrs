package com.company.medium;

import java.util.*;

public class Q15_3Sum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {7,-13,-1,1,-6,14,10,-2,1,9,11,-10,8,-10,14,13,-1,4,-6,-3,-5,3,3,12,-5,11,5,-6,-2,0,-6,12,3,0,-2,12,-1,-7,-5,8,10,13,13,3,10,12,-7,-6,-7,-5,-1,3,5,-13,-8,-15,13,13,-14,-12,-2,-5,-15,8,11,-1,6,-13,-1,8,10,-14,-1,0,-4,-6,-3,5,-4,-2,7,10,8,-3,12,-14,-10,3,14,-9,-2,-11,-6,-9,13,12,-3,4,14,3,-11,2,5,-5,-13,-14,-3,-8};

        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
        System.out.println("hey");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int target = nums[i] * -1;

            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {

                    if (k == i || k == j) {
                        continue;
                    }

                    if ((nums[j] + nums[k]) == target) {
                        List<Integer> candidates = new ArrayList<>();
                        candidates.add(nums[i]);
                        candidates.add(nums[j]);
                        candidates.add(nums[k]);
                        Collections.sort(candidates);
                        ans.add(candidates);
                    }
                }
            }
        }
        // remove duplicates next
        Set<List<Integer>> cache = new HashSet<>();

        for (int i = 0; i < ans.size(); i++){
            List<Integer> integers = ans.get(i);
            cache.add(integers);
        }
        ArrayList<List<Integer>> ans2 = new ArrayList<>();

        ans2.addAll(cache);
        return ans2;
    }
}
