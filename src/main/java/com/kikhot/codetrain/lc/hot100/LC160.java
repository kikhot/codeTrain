package com.kikhot.codetrain.lc.hot100;

public class LC160 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// A遍历完，重新从B头开始遍历
		// B遍历完，重新从A头开始遍历
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}

		return pA;

	}


	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
