package smtcodan.multithreadanalysis;

import java.util.ArrayList;

public class ThreadStates extends ArrayList<ThreadState> {

	public ThreadStates cloneElements() {
		ThreadStates clones = new ThreadStates();
		for (ThreadState state : this) {
			clones.add(state.clone());
		}
		return clones;
	}
	
}
