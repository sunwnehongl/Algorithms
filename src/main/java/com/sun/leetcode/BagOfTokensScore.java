package com.sun.leetcode;

import java.util.Arrays;

/**
 * @Auther: swh
 * @Date: 2020/3/29 16:15
 * @Description:
 */
public class BagOfTokensScore {
    public static void main(String[] args) {
        BagOfTokensScore bagOfTokensScore = new BagOfTokensScore();
        int[] data = {100,200,300,400};
        System.out.println(bagOfTokensScore.bagOfTokensScore(data,200));
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int points = 0, ans = 0;
        while (lo <= hi && (P >= tokens[lo] || points > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                points++;
            }

            ans = Math.max(ans, points);
            if (lo <= hi && points > 0) {
                P += tokens[hi--];
                points--;
            }
        }
        return ans;
    }
}
