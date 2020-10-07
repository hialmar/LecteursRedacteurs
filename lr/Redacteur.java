package lr;

public class Redacteur implements Runnable {
	private int id;
	private Texte texte;
	
	public Redacteur(int id, Texte texte) {
		this.id = id;
		this.texte = texte;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Le redacteur "+id+" se repose");
				Thread.sleep(500);
				ecrire();
			} catch (InterruptedException e) {
				
			}
		}
	}

	private void ecrire() throws InterruptedException {
		texte.debutEcriture();
		System.out.println("Le redacteur "+id+" commence sa redaction");
		Thread.sleep(50);
		System.out.println("Le redacteur "+id+" a fini sa redaction");
		texte.finEcriture();
	}

}
