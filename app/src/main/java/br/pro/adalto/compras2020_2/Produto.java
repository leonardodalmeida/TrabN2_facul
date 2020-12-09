package br.pro.adalto.compras2020_2;

public class Produto {

    private int id;
    private String nome;
    private double KM_atual;
    private double KM_abstecimento;
    private double tanque;
    private double litrosA;
    private double mediaKM;

    public Produto() {

    }

//    public Produto(String nome, double KM_atual) {
//        this.nome = nome;
//        this.KM_atual = KM_atual;
//    }

    public Produto(int id, String nome, double KM_atual, double tanque, double mediaKM) {
        this.id = id;
        this.nome = nome;
        this.KM_atual = KM_atual;
        this.tanque = tanque;
        this.mediaKM = mediaKM;
    }

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

    public double getKM_abstecimento() {
        return KM_abstecimento;
    }

    public void setKM_abstecimento(double KM_abstecimento) {
        this.KM_abstecimento = KM_abstecimento;
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

    public static  double calculaMediaGasolina(double kmL, double vGas){
        return kmL/vGas;
    }

    public static  double calculaMediaEtanol(double kmL, double vEta){
        return kmL/vEta;
    }

    @Override
    public String toString() {
        return nome + " - KM rodados:  " + KM_atual;
    }
}
