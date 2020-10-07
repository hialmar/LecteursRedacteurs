package lr;

public class Texte {
	private int nombreDeLectureEnCours = 0;
	private boolean ecritureEnCours = false;

	public synchronized void debutLecture() {
		while(ecritureEnCours) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		nombreDeLectureEnCours++;
	}

	public synchronized void finLecture() {
		nombreDeLectureEnCours--;
		if(nombreDeLectureEnCours==0) {
			this.notify();
		}
	}

	public synchronized void debutEcriture() {
		while(ecritureEnCours || nombreDeLectureEnCours>0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ecritureEnCours = true;
	}

	public synchronized void finEcriture() {
		ecritureEnCours = false;
		this.notifyAll();
	}

}
