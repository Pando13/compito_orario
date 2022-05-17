import java.util.*;

class TestOrario{
	public static void main(String arg[]){
	Scanner input=new Scanner(System.in);
	String nome, vuota, nome_temp;
	int ore, minuti, secondi, scelta, i=0, temp, cont;
	Boolean is_solare;
	Orario orari[]=new Orario[100];

	do{
		System.out.println("premi 0 per uscire");
		System.out.println("premi 1 per inserire un orario");
		System.out.println("premi 2 per visualizzare un orario");
		System.out.println("premi 3 per visualizzare gli orari inseriti");
		System.out.println("premi 4 per visualizzare l'orario di una citta' presa in input");
		scelta=input.nextInt();
		vuota=input.nextLine();

		switch (scelta) {
			case 0:
				break;

			case 1:
				if(i<1000){
					System.out.println("dammi il nome");
					nome=input.nextLine();
					System.out.println("dammi le ore");
					ore=input.nextInt();
					System.out.println("dammi i minuti");
					minuti=input.nextInt();
					System.out.println("dammi i secondi");
					secondi=input.nextInt();
					vuota=input.nextLine();	
					orario1 = new orario(nome,ore,minuti,secondi);
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
					System.out.println("orario "+temp+": "+orari[i].ore+":"+orari[i].minuti+":"+orari[i].secondi+", citta' = "+orari[i].nome+", e' solare = "+orari[i].is_solare);
				}else{
					System.out.println("errore");
				}
				break;

            case 3:
				for(cont=0; cont<i;cont++){
					System.out.println("orario "+temp+": "+orari[cont].ore+":"+orari[cont].minuti+":"+orari[cont].secondi+", citta' = "+orari[cont].nome+", e' solare = "+orari[cont].is_solare);
				}
				break;

			case 4:
				trovato=false;
				System.out.println("dammi il nome");
				nome_temp=input.nextLine();
				for(cont=0;cont<i;cont++){
					if(nome_temp.equals(orari[cont].nome)){
						trovato=true;
						System.out.println("orario "+temp+": "+orari[cont].ore+":"+orari[cont].minuti+":"+orari[cont].secondi+", citta' = "+orari[cont].nome+", e' solare = "+orari[cont].is_solare);
					}
				}
				if (!trovato) {
					System.out.println("orario non trovato");
				}
				break;
