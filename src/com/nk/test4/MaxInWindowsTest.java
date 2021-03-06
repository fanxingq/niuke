package com.nk.test4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author zheng
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 *     原则：
 *     对新来的元素k，将其与双端队列中的元素相比较
 *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
 */
public class MaxInWindowsTest {

	public static void main(String[] args) {

		
		
		
	}

	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || num.length == 0 || size<=0 || num.length<size) {
			return new ArrayList<Integer>();
		}
        ArrayList<Integer> result = new ArrayList<Integer>();
        //双端队列，用来记录每个窗口的最大值
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i++) {
			while (!qmax.isEmpty() && num[qmax.peekLast()]<num[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			//判断队首元素是否过期
			if (qmax.peekFirst() == i-size) {
				qmax.pollFirst();
			}
			//向result列表中加入元素
			if (i>=size-1) {
				result.add(num[qmax.peekFirst()]);
			}
		}
		
		return result;
    }
	
	
}
