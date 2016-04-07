package com.meng.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedIterator {
	
	class Pointer {
		List parent;
		int idx;
		Pointer(List parent, int idx) {
			this.parent = parent;
			this.idx = idx;
		}
	}

	public static void main(String[] args) {
		List nest = new ArrayList<>();
		nest.add(1);
		List nest2 = new ArrayList<>();
		List nest3 = new ArrayList<>();
		List nest4 = new ArrayList<>();
		nest.add(nest2);
		nest2.add(nest3);
		nest3.add(3);
		nest2.add(2);
		nest2.add(nest4);
		nest2.add(100);
		NestedIterator niter = new NestedIterator(nest);
		while(niter.hasNext()) {
			System.out.println(niter.next().toString());
		}
	}
	
	Stack<Pointer> st = new Stack<>();
	
	public NestedIterator(List nest){
		st.push(new Pointer(nest, 0));
	}
	
	public boolean hasNext() {
		if (st.isEmpty()) return false;
		Pointer p = st.pop();
		if (p.idx >= p.parent.size()) return hasNext();
		if (p.parent.get(p.idx) instanceof List) {
			st.push(new Pointer(p.parent, p.idx + 1));
			st.push(new Pointer((List) p.parent.get(p.idx), 0));
			return hasNext();
		}
		st.push(p);
		return true;
	}
	
	public Object next(){
		hasNext();
		Pointer p = st.pop();
		Object obj = p.parent.get(p.idx);
		st.push(new Pointer(p.parent, p.idx + 1));
		return obj;
	}

	
	
	

}
