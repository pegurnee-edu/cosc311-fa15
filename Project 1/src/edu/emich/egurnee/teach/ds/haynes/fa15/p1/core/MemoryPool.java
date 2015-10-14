package edu.emich.egurnee.teach.ds.haynes.fa15.p1.core;

public interface MemoryPool {

	boolean contains(int i);

	boolean isEmpty();

	int pop();

	void push(int i);

	boolean remove(int i);

}
