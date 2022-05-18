class Orario {
    String nome, nazione;
    int ore, minuti, secondi;
    Boolean is_solare;

    public Orario(String nome, int ore, int minuti, int secondi, String nazione){
        this.nome=nome;
        this.is_solare=true;
        this.ore=ore;
        this.minuti=minuti;
        this.secondi=secondi;
        this.nazione=nazione;
    }

    void solare(){
        if (!this.is_solare) {
            if (this.ore==0) {
                this.ore=23;
            } else {
                this.ore-=1;
            }
            this.is_solare=true;
            System.out.println("ora solare impostata");
        }else{
            System.out.println("l'orario e' gia' solare");
        }
    }

    void legale(){
        if (this.is_solare) {
            if (this.ore==23) {
                this.ore=0;
            } else {
                this.ore+=1;
            }
            this.is_solare=false;
            System.out.println("ora legale impostata");
        }else{
            System.out.println("l'orario e' gia' legale");
        }
    }

    void visualizza(int temp){
        System.out.println("orario "+temp+": "+this.ore+":"+this.minuti+":"+this.secondi+", citta' = "+this.nome+", nazione = "+this.nazione+", e' solare = "+this.is_solare);
    }
}
