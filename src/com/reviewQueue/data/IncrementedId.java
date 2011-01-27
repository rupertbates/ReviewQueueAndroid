package com.reviewQueue.data;

public class IncrementedId {
	
	public int id;

	public IncrementedId() {
		this.id = 0;
	}

	// end IncrementedId

	public int getNextID() {
		return ++id;
	}

	public void resetId(){
		id = 0;
	}
}
