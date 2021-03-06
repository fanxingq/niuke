package com.nk.test3;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 对应每个测试案例，输出两个数，小的先输出.
 * 
 * @author zheng
 * 
 * 数列满足递增，设两个头尾两个指针i和j，
 * 若ai + aj == sum，就是答案（相差越远乘积越小）
 * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
 * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
 * O(n)
 */
public class FindNumbersWithSumArrayTest {

	public static void main(String[] args) {

		
	}

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length<2) {   //先做预判
			return list;
		}
		int low = 0,high = array.length-1;
		while (low<high) {
			int cur = array[low] + array[high];
			if (cur == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			}else if (cur>sum) {
				high--;
			}else {
				low++;
			}
		}
		
		return list;
    }
	
	
}
