package com.axisrooms;


/**
 * This class represents the Rectangular frame, the rover will
 * traverse 
 */
public class RoverFrame {
	
	private int topRightX;
	private int topRightY;

	public RoverFrame(int topRightX, int topRightY){
		this.topRightX = topRightX;
		this.topRightY = topRightY;
	}
	
	public int getTopRightX() {
		return topRightX;
	}

	public void setTopRightX(int topRightX) {
		this.topRightX = topRightX;
	}

	public int getTopRightY() {
		return topRightY;
	}

	public void setTopRightY(int topRightY) {
		this.topRightY = topRightY;
	}
}
