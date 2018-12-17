package com.company.easy.graph;

public class Q743_NetworkDelay {
    public static void main(String[] args) {
        System.out.println("network delay");

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int ans= Solution.networkDelayTime(times, 4, 2);
        System.out.println(ans);
    }

    static class Solution {
        public static int networkDelayTime(int[][] times, int N, int K) {
            int[] visited = new int[N + 1];
            int acc = 0;
            boolean going = true;
            while (going) {
                for (int i = 1; i <= N; i++) {
                    if (visited[i] == 0) {
                        if (times[i][0] == K) {
                            acc += times[i][2];
                            visited[i] = 1;
                            K = times[i][1];
                            i = 1;
                        } else if (times[i][1] == K) {
                            acc += times[i][2];
                            visited[i] = 1;
                            K = times[i][0];
                            i = 1;
                        }
                    }
                }
                going = false;
            }
            return acc;
        }
    }
}
