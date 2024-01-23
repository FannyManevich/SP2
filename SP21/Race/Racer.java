package Race;

import java.util.Scanner;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * 
 */

public class Racer implements Runnable{
	
	private static int globalId;
	private int id;
	private int speed;
	private int distanse;
	public Track trackdistanse;
	public FinishLine finish;
	
	//-------Get&Set----------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	//------Functions-------
	public Racer(int speed, Track track) {
		
		globalId = 1;
		id = globalId;
		
		if(speed < 1 || speed > 10) {
			System.out.println("Wrong speed");
		}
		
		track = new Track(); 
	}
	
	public void go() {
		
		while( distanse > 0) {
			try{
				Thread.currentThread();
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
					
			System.out.printf("Runner  %d ran  %d meters \n", id, distanse);
		
			if(distanse == 100 ) {
			
				System.out.printf("Runner  %d ran  100 meters \n", id);
				finish.Finished(this);
				
			}
		}
		
		
	}
	
	public void run() {
	
		
	}
	

}
