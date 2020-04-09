package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: swh
 * @Date: 2020/4/9 21:40
 * @Description:
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = bakcTrace(s, 0, 3, "");
        return list;
    }

    private List<String> bakcTrace(String s, int start,int length, String ip) {

        List<String> list = new ArrayList<>();
        if (length == 0 ) {
            String numStr = s.substring(start);
            if (numStr.length()<=3 &&(Integer.parseInt(numStr) <= 255 && !numStr.startsWith("0")) ||numStr.equals("0")) {
                list.add(ip+"."+s.substring(start));
            }
        }else{
            for (int i = start+1; i < s.length() && i < start + 4; i++) {
                String numStr = s.substring(start, i);
                if (numStr.length()<=3 &&(Integer.parseInt(numStr) <= 255 && !numStr.startsWith("0")) ||numStr.equals("0")) {
                    String tempIp = ip.equals("") ? numStr: ip + "." + numStr;
                    list.addAll(bakcTrace(s, i , length - 1, tempIp));
                }
            }
        }

        return  list;
    }
}
