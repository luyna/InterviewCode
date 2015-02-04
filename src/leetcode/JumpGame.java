package leetcode;

public class JumpGame {
	/**
	 * Leetcode No.45
	 * ����һ���Ǹ��������飬��ʼָ���һ��Ԫ�أ�������ÿ�����ֱ�ʾ�ӵ�ǰ�±���Ծ����󳤶ȣ���������Ծ�Ĳ�������С���������� �ҳ��ﵽ���
	 * һ���±��������С��Ծ������ For example: Given array A = [2,3,1,1,4] The minimum
	 * number of jumps to reach the last index is 2. (Jump 1 step from index 0
	 * to 1, then 3 steps to the last index.)
	 * 
	 * @param A
	 * @return
	 */
	/*
	 * ���������Ԫ�ر�ʾ��ǰ�±�λ�ÿ�����Ծ�ĳ��ȣ�һ�����ó��ȣ�����С�ڸó�����
	 * ��minStep[]����Ӻ���ǰ������minStep[i]�����i�ﵽ����±�������Ծ����
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
	 * Leetcode NO.55 ����һ���Ǹ��������飬��ʼָ���һ��Ԫ�ء�������ÿ��Ԫ�ر�ʾ���Դӵ�ǰλ����Ծ����󳤶ȡ�
	 * �ж��Ƿ���Դﵽ���һ���±ꡣ For example: A = [2,3,1,1,4], return true. A =
	 * [3,2,1,0,4], return false. ˼·����¼i֮ǰ���±�����Ծ����Զ���룬�������Զ���벻�ܴﵽi,���ܵ���i
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
