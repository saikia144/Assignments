package com.impl;

import com.model.IWorkOut;
import com.model.WorkOut;

public class WorkoutImpl implements IWorkOut {
	private WorkOut[] workout;
	
	public WorkoutImpl(){
		workout = new WorkOut[5];
		
		for(int i=0; i<5; i++) {
			workout[i] = new WorkOut();
		}
	}

	@Override
	public void addWorkout(WorkOut wout, int index) {
		if(workout == null || index < 0) {
			System.out.println("Cannot add workout");
		}
		
		if(workout[index].getType() != null) {
			System.out.println("Enter a different index");
		}
		
		workout[index] = wout;
		
	}

	@Override
	public WorkOut[] displayMyWorkouts() {
		
		return workout;
	}
	
}
