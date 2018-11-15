package com.yatop.lambda.base.utils;


/**
 * MyBatis分页
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
public class Page {
	
	// 分页查询开始记录位置
	private int begin;
	// 分页查看下结束位置
	private int end;
	// 每页显示记录数
	private int length;
	// 查询结果总记录数
	private int count;
	// 当前页码
	private int current;
	// 总共页数
	private int total;
	
	public Page() {
		super();
	}

	public Page(final int begin, final int length) {
		this.begin = begin;
		this.length = length;
		this.end = this.begin + this.length;
		this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
	}

    public Page(final String begin, final String length) {
        this.begin = Integer.parseInt(begin);
        this.length = Integer.parseInt(length);
        this.end = this.begin + this.length;
        this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
    }

	public Page(final int begin, final int length, final int count) {
		this(begin, length);
		this.count = count;
	}
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(final int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(final int end) {
		this.end = end;
	}
	public int getLength() {
		return length;
	}
	public void setLength(final int length) {
		this.length = length;
	}
	public int getCount() {
		return count;
	}
	public void setCount(final int count) {
		this.count = count;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(final int current) {
		this.current = current;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(final int total) {
		this.total = total;
	}
}