package com.sun.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Description TODO
 * @Author sunwenhong
 * @Date 2020/12/12 23:10
 */
@RunWith(Parameterized.class)
public class AddTwoNumbersTest {
    private ListNode l1;
    private ListNode l2;
    private ListNode sum;

    public AddTwoNumbersTest(ListNode l1, ListNode l2, ListNode node) {
        this.l1 = l1;
        this.l2 = l2;
        this.sum = node;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> init() {
        return Arrays.asList(new Object[][]{
                {getListNode("243"), getListNode("564"), getListNode("708")},
                {getListNode("111"), getListNode("111"), getListNode("222")},
                {getListNode("0"), getListNode("0"), getListNode("0")},
                {getListNode("1"), getListNode("0"), getListNode("1")},
                {getListNode("9999"), getListNode("1"), getListNode("00001")}
          });
    }

    private static ListNode getListNode(String num) {
        ListNode head =null;
        ListNode last = null;
        for (int i = 0; i < num.length(); i++) {
            ListNode node = new ListNode(Integer.valueOf(String.valueOf(num.charAt(i))), null);
            if (head == null) {
                head = node;
            }else {
                last.next = node;
            }
            last = node;
        }
        return head;
    }

    private static boolean isEquals(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                return false;
            }
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        return true;
    }
    @Test
    public void test() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        Assert.assertTrue(isEquals(node, sum));
    }

}
