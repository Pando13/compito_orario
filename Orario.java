class orario {
    String nome;
    int ore, minuti, secondi;
    Boolean is_solare;

    public orario(String nome, int ore, int minuti, int secondi){
        this.nome=nome;
        this.is_solare=true;
        this.ore=ore;
        this.minuti=minuti;
        this.secondi=secondi;
    }
}
