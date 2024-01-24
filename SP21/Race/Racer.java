package Race;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * 
 */

public class Racer implements Runnable{
	
	private static int globalId = 1;
	private int id;
	private int speed;
	private int distanse;
	public Track track;
	
	public int getId() {
		return id;
	}

	
	public Racer(int speed, Track track) {
		
		id = globalId;
		globalId ++;
		distanse = 1;
		
		if(speed < 1 || speed > 10) {
			System.out.println("Wrong speed");
		}else {
			this.speed = speed;
		}
		
		track = new Track(); 
	}
	
	public void go() throws InterruptedException {
		
		while( distanse > 0 && distanse < 100){
			try{
				Thread.currentThread();
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			
			if( distanse < 100) {
				
				distanse += speed;
			}
			
			
			System.out.printf("Runner  %d ran  %d meters \n", id, distanse);
			
			if(distanse == 100 ) {
			
				System.out.printf("Runner  %d ran  100 meters \n", id);
				track.Finished(this);
				
			}
			
		}
		
		
	}
	
	public void run() {
	
		Thread.currentThread().setPriority(this.speed);
		try {
			go();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
