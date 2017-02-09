package me.huqiao.algs4.fundamentals.util.impl.stack;

import java.util.Iterator;

import me.huqiao.algs4.fundamentals.util.Stack;
import me.huqiao.algs4.stdlib.StdOut;

/**
 * LIFO stack implement with array
 * @author huqiao
 * @param <Item>
 */
public class ArrayStack<Item> implements Stack<Item> {
	private Item[] items = (Item[])new Object[20];
	private int size = 0;
	
	@Override
	public void push(Item item) {
		if( items.length <= size ){
			resize(items.length*2);
		}
		items[size++] = item;
	}
	
	private void resize(int s) { 
		Item[] newArray = (Item[])new Object[s];
		for(int i = 0; i<s && i<items.length; i++){
			newArray[i] = items[i];
		}
		items = newArray;
		StdOut.println("resize queye array size to " + items.length);
	}

	@Override
	public Item pop() {
		Item item = items[size-1];
		size--;
		if(size<items.length/4){
			resize(items.length/2);
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayQueueInterator();
	}
	
	class ArrayQueueInterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Item next() {
			return pop();
		}

		@Override
		public void remove() {
		}
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		
		for(int i = 1;i<200;i++){
			stack.push(i);
		}
		
		for(Integer s : stack){
			System.out.println(s);
		}
	}
}
