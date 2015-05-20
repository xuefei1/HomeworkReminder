package com.homeworkreminder;

public enum TaskType {
	
	HOMEWORK("Homework"),
	LAB("Lab"),
	EXAM("Exam"),
	OTHER("Other");
	
	String label;
	
	TaskType(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public static int getTypeCount(){
		return 4;
	}
	
}
