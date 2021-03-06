package me.huqiao.algs4.fundamentals.unionfind.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import me.huqiao.algs4.fundamentals.unionfind.UF;
import me.huqiao.algs4.fundamentals.util.StopWatch;
import me.huqiao.algs4.stdlib.StdIn;
import me.huqiao.algs4.stdlib.StdOut;

public class QuickUnionUF extends AbstractUF implements UF {

	public QuickUnionUF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		while(p != d[p]) p = d[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot){
			return;
		} 
		d[pRoot] = d[qRoot];
		count--;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./data/largeUF.txt"));
		StopWatch w = new StopWatch();
		int n = StdIn.readInt();
		StdOut.println(n);
		QuickUnionUF uf = new QuickUnionUF(n);
        
        boolean print = false;
		
        if(print){
	        StdOut.print("Init:");
	        for(int i : uf.d){
				StdOut.print(i + "\t");
			}
	        StdOut.println("\r\n-----------------------------------------------------------------------------");
        }
        
		while(!StdIn.isEmpty()){ 
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.isconnected(p, q)){
				uf.union(p, q);
				if(print){
					StdOut.print(p + "->" + q+":");
					
					for(int i : uf.d){
						StdOut.print(i + "\t");
					}
					StdOut.println();
				}
			}
		}
		if(print){
			StdOut.println("-----------------------------------------------------------------------------");
			for(int i : uf.d){
				StdOut.print(i + "\t");
			}
		}
		StdOut.println("\r\ntime:" + w.stop() + "ms");
		StdOut.println("Result:" + uf.count);
	}

}
