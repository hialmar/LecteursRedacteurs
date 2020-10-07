package lr;

public class Lecteur implements Runnable {
	private int id;
	private Texte texte;
	
	public Lecteur(int id, Texte texte) {
		this.id = id;
		this.texte = texte;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Le lecteur "+id+" se repose");
				Thread.sleep(500);
				lire();
			} catch (InterruptedException e) {
				
			}
		}
	}

	private void lire() throws InterruptedException {
		texte.debutLecture();
		System.out.println("Le lecteur "+id+" commence la lecture");
		Thread.sleep(500);
		System.out.println("Le lecteur "+id+" a fini sa lecture");
		texte.finLecture();
	}

}
