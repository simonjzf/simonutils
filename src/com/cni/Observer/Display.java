package com.cni.Observer;

import java.util.Observable;
import java.util.Observer;

public class Display extends Observable implements Observer {

	private String status ="未开";

	public void setStatue(String status) {
		this.status = status;
	}
	
	public void displayTemperature(int temperature){
		if(temperature>95){
			this.setStatue("沸腾");
			this.setChanged();
			this.notifyObservers();
		}
		System.out.println("status: "+status+" Now Temperature: "+temperature);
	}
	public void update(Observable o,Object arg){
		displayTemperature(((Heater)o).getTemperature());
	}

}
