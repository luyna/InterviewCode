package leetcode;

public class JumpGame {
	/**
	 * Leetcode No.45
	 * 给定一个非负整数数组，初始指向第一个元素，数组中每个数字表示从当前下标跳跃的最大长度（逐步跳，跳跃的步数可以小于它？）， 找出达到最后
	 * 一个下标所需的最小跳跃步数。 For example: Given array A = [2,3,1,1,4] The minimum
	 * number of jumps to reach the last index is 2. (Jump 1 step from index 0
	 * to 1, then 3 steps to the last index.)
	 * 
	 * @param A
	 * @return
	 */
	/*
	 * 如果数组中元素表示当前下标位置可以跳跃的长度（一次跳该长度，不能小于该长数）
	 * 用minStep[]数组从后往前遍历，minStep[i]保存从i达到最后下标的最大跳跃步数
	 */
	public int jump(int[] A) {
		if (A.length == 1)
			return 0;
		int[] minStep = new int[A.length];
		int last = A.length - 1;
		minStep[last] = 0;
		for (int i = last - 1; i >= 0; i--) {
			if (i + A[i] >= last)
				minStep[i] = 1;
			else if (minStep[i + A[i]] < minStep[i + 1])
				minStep[i] = minStep[i + A[i]] + 1;
			else
				minStep[i] = minStep[i + 1] + 1;
		}
		return minStep[0];
	}

	/**
	 * Leetcode NO.55 给定一个非负整形数组，初始指向第一个元素。数组中每个元素表示可以从当前位置跳跃的最大长度。
	 * 判断是否可以达到最后一个下标。 For example: A = [2,3,1,1,4], return true. A =
	 * [3,2,1,0,4], return false. 思路：记录i之前的下标能跳跃的最远距离，如果该最远距离不能达到i,则不能到达i
	 * 
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max)
				return false;
			if (max < (A[i] + i))
				max = A[i] + i;
		}
		return true;
	}

}
