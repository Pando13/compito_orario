import java.util.*;

public class TestOrario{
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);

		//variabili array
		int LIMIT = 100, size=0;

		//variabili input utente
		int scelta, sceltaInt;
		String sceltaString;

		//variabili orari
		String citta, nazione, orario;
		Orario orari[]=new Orario[LIMIT];

		int trovati;
		Boolean trovato;

		do{
			System.out.println("[1] per inserire un orario");
			System.out.println("[2] per visualizzare un orario");
			System.out.println("[3] per visualizzare gli orari inseriti");
			System.out.println("[4] per visualizzare l'orario di una citta'");
			System.out.println("[5] per impostare l'ora SOLARE di una città");
			System.out.println("[6] per impostare l'ora LEGALE di una città");
			System.out.println("[7] per vedere i diversi fusi orari di una nazione");
			System.out.println("[8] per vedere diversi nomi di una nazione");
			System.out.println("[0] per uscire");
			System.out.print("> ");
			scelta=Integer.parseInt(input.nextLine());

			switch (scelta) {
				case 0:
					break;

				case 1:
					if(size<LIMIT){
						System.out.print("Inserisci la città: ");
						citta=input.nextLine();
						System.out.print("Inserisci la nazione: ");
						nazione=input.nextLine();
						System.out.print("Inserisci l'orario (hh:mm:ss): ");
						orario=input.nextLine();
						String[] tempo = orario.split(":");
						orari[size] = new Orario(citta,
								nazione,
								Integer.parseInt(tempo[0]),
								Integer.parseInt(tempo[1]),
								Integer.parseInt(tempo[2]),
								true);
						size++;
					}else{
						System.out.println("Limite massimo di orari inseriti");
					}
					break;

				case 2:
					System.out.print("Inserisci l'orario che vuoi visualizzare: ");
					sceltaInt = Integer.parseInt(input.nextLine());
					if (sceltaInt >= 0 && sceltaInt <= size){
						orari[sceltaInt].visualizzaOrario(sceltaInt);
					}else{
						System.err.print("ERRORE! Inserisci un numero valido");
					}
					break;

				case 3:
					for(int i=0; i<size;i++){
						orari[i].visualizzaOrario(i);
					}
					break;

				case 4:
					setFusoOrario(input, size, orari, "STAMPA");
					break;

				case 5:
					setFusoOrario(input, size, orari, "IMPOSTA_SOLARE");
					break;

				case 6:
					setFusoOrario(input, size, orari, "IMPOSTA_LEGALE");
					break;

				case 7:
					System.out.println("Inserisci il nome di una nazione: ");
					sceltaString=input.nextLine();
					sceltaInt = 0;
					trovati=0;
					//conto quanti orari della nazione in input
					for(int i = 0; i < size; i++){
						if(orari[i].getNazione().equals(sceltaString)){
							sceltaInt++;
						}
					}
					//inizializzo e riempio il vettore con gli orari della nazione in input
					String subOrari[]=new String[sceltaInt];
					sceltaInt=0;
					for(int i = 0; i < size; i++){
						if(orari[i].getNazione().equals(sceltaString)){
							subOrari[sceltaInt] = orari[i].getTime();
							sceltaInt++;
						}
					}

					if(subOrari.length == 0){
						System.out.println("Non ci sono fusi orari");
						break;
					}
					for(int i = 0; i < subOrari.length; i++){
						if (subOrari[i]==null){
							continue;
						}
						for(sceltaInt = i+1; sceltaInt<subOrari.length; sceltaInt++){
							if(subOrari[i].equals(subOrari[sceltaInt]))
								subOrari[sceltaInt] = null;

						}
						trovati++;
					}
					if(trovati == 1){
						System.out.println("è presente 1 fuso orario");
					}else{
						System.out.println("sono presenti " + trovati + " fusi orari");
					}
					break;

				case 8:
					System.out.println("Inserisci la Nazione: ");
					sceltaString=input.nextLine();
					sceltaInt = 0;
					trovati=0;
					//conto quanti orari della nazione in input
					for(int i = 0; i < size; i++){
						if(orari[i].getNazione().equals(sceltaString)){
							sceltaInt++;
						}
					}
					//inizializzo e riempio il vettore con gli orari della nazione in input
					String subNomi[]=new String[sceltaInt];
					sceltaInt=0;
					for(int i = 0; i < size; i++){
						if(orari[i].getNazione().equals(sceltaString)){
							subNomi[sceltaInt] = orari[i].getCitta();
							sceltaInt++;
						}
					}

					if(subNomi.length == 0){
						System.out.println("Non ci sono orari di quella nazione");
						break;
					}
					for(int i = 0; i < subNomi.length; i++){
						if (subNomi[i]==null){
							continue;
						}
						for(sceltaInt = i+1; sceltaInt<subNomi.length; sceltaInt++){
							if(subNomi[i].equals(subNomi[sceltaInt]))
								subNomi[sceltaInt] = null;

						}
						trovati++;
					}
					if(trovati == 1){
						System.out.println("è presente 1 orario della nazione "+sceltaString);
					}else{
						System.out.println("sono presenti " + trovati + " orari della nazione "+sceltaString);
					}
					break;

				default:
					break;
			}
			System.out.println();
		}while(scelta!=0);
	}

	private static void setFusoOrario(Scanner input, int size, Orario[] orari, String azione) {
		Boolean trovato = false;
		System.out.print("Inserisci il nome di una citta: ");
		String sceltaString = input.nextLine();
		for(int i = 0; i< size; i++){
			if(sceltaString.equals(orari[i].getCitta())){

				switch (azione){
					case "STAMPA":
						orari[i].visualizzaOrario(i);
						trovato=true;
						break;
					case "IMPOSTA_SOLARE":
						orari[i].solare();
						trovato=true;
						break;
					case "IMPOSTA_LEGALE":
						orari[i].legale();
						trovato=true;
						break;
				}
			}
		}
		if (!trovato) {
			System.out.println("Mi dispiace, non sono stati trovati orari per questa citta");
		}
	}
}
