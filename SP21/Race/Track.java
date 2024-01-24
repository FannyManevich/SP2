package Race;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * 
 */
public class Track {

	int finishedRacers = 0;
	
	public synchronized void Finished(Racer racer) {
		
		finishedRacers++;
		
		switch(finishedRacers) {
			case 1:
				System.out.printf("Runner %s finished %d st! \n", racer.getId());
				break;
				
			case 2:
				System.out.printf("Runner %s finished %d nd! \n", racer.getId());
				break;
				
			case 3:
				System.out.printf("Runner %s finished %d rd! \n", racer.getId());
				break;
			
			default:
				System.out.printf("Runner %s finished %d-th \n", racer.getId(), finishedRacers);
		}
		
		
	}
	
}
