package br.com.gustavo.reservaSalas.models.models;

public enum SalaStatus {
    RESERVADO("reservado"),
    DISPONIVEL("disponivel"),
    INATIVO("inativo");

    private String status;

    SalaStatus(String status){
        this.status = status;
    }

    public static SalaStatus fromString(String text){
        for(SalaStatus s : SalaStatus.values()){
            if(s.status.equalsIgnoreCase(text)){
                return s;
            }
        }
        throw new IllegalArgumentException("Nenhum status encontrado para a string fornecida: " + text);
    }
}
