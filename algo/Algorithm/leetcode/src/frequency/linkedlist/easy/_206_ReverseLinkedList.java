package frequency.linkedlist.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目描述：反转一个链表
 *
 * 示例
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶
 *
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * <pre>
 *  Definition for singly-linked list.
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *   }
 *  </pre>
 *
 * @author Rotor
 * @since 2019/8/22 22:37
 */
public class _206_ReverseLinkedList {
    /**
     * 迭代解法
     *
     * 思路：在遍历链表时，为了反转链表，我们需要将当前结点的 next 指针指向它的前驱结点，但要注意，因为在单链表中，当前结点没有直接
     * 指向（引用）它的前驱结点，所以在反转之前我们需要先记录当前结点的前驱结点。同时，为了不让链表断掉，还需记录当前节点的后继结点
     * （下一个结点）。
     *
     * 时间复杂度：O()
     * 空间复杂度：O()
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // 前驱结点
        ListNode curr = head; // 当前结点（指向头结点）
        ListNode next = null; // 后继节点，初始化为 null
        while (curr != null) {
            next = curr.next; // 保存当前结点的后继结点
            curr.next = prev; // 反转当前结点的 next 指针
            prev = curr; // 继续遍历，前驱结点指向下一个结点
            curr = next;
        }
        // curr == null 时，prev 指向链表的最后一个元素，即新链表的第一个元素
        return prev;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(10);
        System.out.println("链表只有一个结点时，输出为：" + reverseList(list).val);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
