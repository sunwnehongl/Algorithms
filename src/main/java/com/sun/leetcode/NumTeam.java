package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/4/4 17:45
 * @Description:
 */
public class NumTeam {

    public static void main(String[] args) {
        NumTeam numTeam = new NumTeam();
        int[] rating = new int[]{2,5,3};
        System.out.println(numTeam.numTeams(rating));

    }
    public int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int numTeams =0;
        for (int i = 0; i < rating.length -2; i++) {
            numTeams += backTrace(rating,i,2,-1);
            numTeams += backTrace(rating,i,2,1);
        }
        return numTeams;
    }

    public int backTrace(int[] rating, int index, int length, int falg) {
        int numTeams = 0;
        if (length == 1) {
            for (int i = index + 1; i < rating.length; i++) {
                if (-1 == falg && rating[index]>rating[i]) {
                    numTeams += 1;
                }
                if (1 == falg && rating[index]<rating[i]) {
                    numTeams +=1;
                }
            }

        }else{
            for (int i = index + 1; i < rating.length; i++) {
                if (-1 == falg && rating[index]>rating[i]) {
                    numTeams += backTrace(rating,i,length-1,-1);
                }
                if (1 == falg && rating[index]<rating[i]) {
                    numTeams += backTrace(rating,i,length-1,1);
                }
            }
        }
        return numTeams;
    }
}
