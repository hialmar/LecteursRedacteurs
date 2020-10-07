package lr;

public class Main {
	public static void main(String[] args) {
		Texte texte = new Texte();
		
		for(int i = 0; i<5; i++) {
			Lecteur l = new Lecteur(i, texte);
			Thread t = new Thread(l);
			t.start();
		}
		for(int i = 0; i<5; i++) {
			Redacteur r = new Redacteur(i, texte);
			Thread t = new Thread(r);
			t.start();
		}

	}

}
