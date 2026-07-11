package com.kikhot.codetrain.lc.hot100;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 */
public class LC234 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public boolean isPalindrome(ListNode head) {
		// 找到中间的指针，然后将前面的进行反转
		ListNode slow = head, fast = head, pre = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			ListNode temp = slow.next;
			slow.next = pre;
			pre = slow;
			slow = temp;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (pre != null && slow != null) {
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}
		return true;
	}

}
