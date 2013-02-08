package com.interview.lectures.unionfind;

public class EnhancedQuickUnion extends UnionFindBase {
	/**
	 * Use a integer array to store the forest created by connectivity.
	 * the value in index[i] is the parent of i;
	 * union operation: weight the subtree, put the small tree under the big tree to avoid tail tree
	 * 		assign the parent of big tree to the parent of small tree
	 * find operation: in one connectivity if the parent of a and b is same 
	 * quickunion:
	 * 	initialize: N
	 * 	union: lgN
	 * 	find: lgN
	 */
	
	public int[] treesize;
	
	public EnhancedQuickUnion(int N){
		super(N);
		this.treesize = new int[N];
		for(int i = 0; i < N; i ++){
			this.treesize[i] = 1;
		}
	}

	@Override
	public void union(int a, int b) {
		int parent_a = this.getParent(a);
		int parent_b = this.getParent(b);
		if(this.treesize[parent_a] > this.treesize[parent_b]){
			this.index[parent_b] = parent_a;
			this.treesize[parent_a] += this.treesize[parent_b];
		} else {
			this.index[parent_a] = parent_b;
			this.treesize[parent_b] += this.treesize[parent_a];
		}
		
	}

	@Override
	public boolean connected(int a, int b) {
		if(this.getParent(a) == this.getParent(b)){
			return true;
		} else {
			return false;
		}
	}
	
	public int getParent(int index){
		while(this.index[index] != index){
			index = this.index[index];
		}
		return index;
	}

	public boolean checkIndex(int index){
		if(index >= 0 && index < N){
			return true;
		} else {
			return false;
		}
	}
	

}
