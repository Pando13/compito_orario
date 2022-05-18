import java.util.*;

class TestOrario{
	public static void main(String arg[]){
	Scanner input=new Scanner(System.in);
	String nome, vuota, nome_temp, nazione;
	int ore, minuti, secondi, scelta, i=0, temp, cont;
	Boolean is_solare, trovato;
	Orario orari[]=new Orario[100];

	do{
		System.out.println("premi 0 per uscire");
		System.out.println("premi 1 per inserire un orario");
		System.out.println("premi 2 per visualizzare un orario");
		System.out.println("premi 3 per visualizzare gli orari inseriti");
		System.out.println("premi 4 per visualizzare l'orario di una citta' presa in input");
		System.out.println("premi 5 per impostare l'ora solare di una città il cui nome è preso in input");
		System.out.println("premi 6 per impostare l'ora legale di una città il cui nome è preso in input");
		System.out.println("premi 7 per vedere se per una nazione presa in input ci sono diversi fusi orari");
		scelta=input.nextInt();
		vuota=input.nextLine();

		switch (scelta) {
			case 0:
				break;

			case 1:
				if(i<100){
					System.out.println("dammi il nome");
					nome=input.nextLine();
					System.out.println("dammi la nazione");
					nazione=input.nextLine();
					System.out.println("dammi le ore");
					ore=input.nextInt();
					System.out.println("dammi i minuti");
					minuti=input.nextInt();
					System.out.println("dammi i secondi");
					secondi=input.nextInt();
					vuota=input.nextLine();	
					orari[i] = new Orario(nome,ore,minuti,secondi,nazione);
					i++;
				}else{
					System.out.println("orari pieni");
				}
				break;
            
			case 2:
				System.out.println("quale orario vuoi visualizzare?");
				temp=input.nextInt();
				vuota=input.nextLine();
				if (temp >= 0 && temp <= i){
					orari[temp].visualizza(temp);
				}else{
					System.out.println("errore");
				}
				break;

            		case 3:
				for(cont=0; cont<i;cont++){
					orari[cont].visualizza(cont);
				}
				break;

			case 4:
				trovato=false;
				System.out.println("dammi il nome");
				nome_temp=input.nextLine();
				for(cont=0;cont<i;cont++){
					if(nome_temp.equals(orari[cont].nome)){
						trovato=true;
						orari[cont].visualizza(cont);
					}
				}
				if (!trovato) {
					System.out.println("orario non trovato");
				}
				break;
			
			case 5:
				trovato=false;
				System.out.println("dammi il nome");
				nome_temp=input.nextLine();
				for(cont=0;cont<i;cont++){
					if(nome_temp.equals(orari[cont].nome)){
						orari[cont].solare();
						trovato=true;
					}
				}
				if (!trovato) {
					System.out.println("orario non trovato");
				}
				break;
			
			case 6:
				trovato=false;
				System.out.println("dammi il nome");
				nome_temp=input.nextLine();
				for(cont=0;cont<i;cont++){
					if(nome_temp.equals(orari[cont].nome)){
						orari[cont].legale();
						trovato=true;
					}
				}
				if (!trovato) {
					System.out.println("orario non trovato");
				}
				break;
			
			case 7:
				break;

			default:
				break;
		}
	}while(scelta!=0);
}
}
