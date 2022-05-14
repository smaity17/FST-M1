package activities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    public Plane(int maxPassenger){
    	this.maxPassengers = maxPassenger;
    	this.passengers = new ArrayList<String>();
    }
    public void onBoard(String passengerName) {
    	this.passengers.add(passengerName);
    }
    public Date takeOff() {
    	return new Date();   
    }
    
    public void land() {
        Date date = new Date(); 
    	this.lastTimeLanded = date;
    	this.passengers.clear();
    }
    
    public Date getLastTimeLanded() {
    	return this.lastTimeLanded;
    }
    
    public List<String> getPassengers() {
    	return this.passengers;
    }
}

public class Activity6 {
	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		plane.onBoard("Itachi");
        plane.onBoard("Levi");
        plane.onBoard("Luffy");
        System.out.println("TakeOff time: "+plane.takeOff());
        System.out.println("List of Passengers: "+plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Time of Landing: "+plane.getLastTimeLanded());
        System.out.println("Passengers after landing: "+plane.getPassengers());
	}
}
