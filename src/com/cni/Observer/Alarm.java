﻿package com.cni.Observer;

import java.util.Observable;
import java.util.Observer;

public class Alarm implements Observer {

	public void makeAlarm(){
		System.out.println("嘀嘀嘀... 水已经烧开了");
	}
	public void update(Observable o, Object arg) {
		makeAlarm();
	}
}
