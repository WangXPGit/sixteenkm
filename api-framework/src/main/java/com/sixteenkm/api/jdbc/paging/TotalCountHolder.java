/** 
 * TotalCountHolder.java Create on 2017年12月21日
 */

package com.sixteenkm.api.jdbc.paging;

/**
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017年12月21日
 */
public class TotalCountHolder {

	private static ThreadLocal<Integer> holder = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static void set(int value) {
		holder.set(value);
	}

	public static int get() {
		return holder.get();
	}

	public static void remove() {
		holder.remove();
	}
}
