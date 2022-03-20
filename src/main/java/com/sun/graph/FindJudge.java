package com.sun.graph;

public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            inDegrees[trust[i][1]] += 1;
            outDegrees[trust[i][0]] += 1;
        }
        for (int i = 1; i < n +1; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindJudge findJudge = new FindJudge();
        System.out.println(findJudge.findJudge(2,new int[][]{{1,2}}));
    }
}
