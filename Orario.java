public class Orario {
    private String citta;
    private String nazione;
    private int ore;
    private int minuti;
    private int secondi;
    private Boolean is_solare;

    public Orario(String citta, String nazione, int ore, int minuti, int secondi, Boolean is_solare) {
        this.citta = citta;
        this.nazione = nazione;
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
        this.is_solare = is_solare;
    }

    public void solare(){
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

    public void legale(){
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

    public void visualizzaOrario(int numOrario){
        System.out.println("orario "+numOrario+": "+this.ore+":"+this.minuti+":"+this.secondi+", citta' = "+this.citta+", nazione = "+this.nazione+", e' solare = "+this.is_solare);
    }

    public String getTime(){
        return this.ore+":"+this.minuti+":"+this.secondi;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public Boolean getIs_solare() {
        return is_solare;
    }

    public void setIs_solare(Boolean is_solare) {
        this.is_solare = is_solare;
    }
}
