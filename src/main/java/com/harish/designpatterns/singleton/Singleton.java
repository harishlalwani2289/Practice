package com.harish.designpatterns.singleton;

public class Singleton {
	private static Singleton instance;
	
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					return new Singleton();
				}
			}
		}
		return instance;
	}

}
