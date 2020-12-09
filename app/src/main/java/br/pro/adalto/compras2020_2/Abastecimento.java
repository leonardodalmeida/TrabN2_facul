package br.pro.adalto.compras2020_2;

public class Abastecimento {

    private int id;
    private String nome;
    private date KM_abastecimento;
    private double tanque;
    private double litrosA;
    private double mediaKM;

    public Abastecimento() {

    }

//    public Produto(String nome, double KM_atual) {
//        this.nome = nome;
//        this.KM_atual = KM_atual;
//    }

    public Abastecimento(int id, String veiculo_id, double KM_atual, double tanque, double mediaKM) {
        this.id = id;
        this.veiculo_id = veiculo_id;
        this.Dt_Abastecimento = Dt_Abastecimento;
        this.kmAbastecimento_veiculo = kmAbastecimento_veiculo;
        this.precoGas = precoGas;
        this.precoEta = precoEta;
        this.capacidade_tanque = capacidade_tanque;
        this.Combs_indicado = Combs_indicado;
        this.Combs_selecionado = Combs_selecionado;
        this.L_abastecidos = L_abastecidos;
    }
//              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
//            " veiculo_id INTEGER NOT NULL , " +
//            " Dt_Abastecimento DATETIME NOT NULL , " +
//            " kmAbastecimento_veiculo INTEGER NOT NULL , " +
//            " precoGas DOUBLE NOT NULL, " +
//            " precoEta DOUBLE NOT NULL, " +
//            " capacidade_tanque DOUBLE NOT NULL, " +
//            " Combs_indicado TEXT NOT NULL , " +
//            " Combs_selecionado TEXT NOT NULL , " +
//            " L_abastecidos DOUBLE

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getKM_atual() {
        return KM_atual;
    }

    public void setKM_atual(double KM_atual) {
        this.KM_atual = KM_atual;
    }

    public double getKM_abastecimento() {
        return KM_abastecimento;
    }

    public void setKM_abastecimento(double KM_abastecimento) {
        this.KM_abastecimento = KM_abastecimento;
    }


    public double getTanque() {
        return tanque;
    }

    public void setTanque(double tanque) {
        this.tanque = tanque;
    }

    public double getmediaKM() {
        return mediaKM;
    }

    public void setmediaKM(double mediaKM) {
        this.mediaKM = mediaKM;
    }


    public double getLitrosAbastecidos() {
        return litrosA;
    }

    public void setLitrosAbastecidos(double litrosA) {
        this.litrosA = litrosA;
    }


    public static double calcular(double vGas, double vEta){
        return vEta/vGas;
    }

    public static  double calculaMedia(double kmL, double vGas){
        return kmL/vGas;
    }


}

