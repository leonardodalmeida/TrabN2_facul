package br.pro.adalto.compras2020_2;

import java.time.LocalDateTime;

public class Abastecimento {

    private int id;
    private int veiculo_id;
    private LocalDateTime Dt_Abastecimento;
    private double kmAbastecimento_veiculo;
    private double precoGas;
    private double precoEta;
    private double capacidade_tanque;
    private String Combs_indicado;
    private String Combs_selecionado;
    private double L_abastecidos;

    public Abastecimento() {

    }

//    public Produto(String nome, double KM_atual) {
//        this.nome = nome;
//        this.KM_atual = KM_atual;
//    }

    public Abastecimento(int id, int veiculo_id, LocalDateTime Dt_Abastecimento, double kmAbastecimento_veiculo, double precoGas, double precoEta, double capacidade_tanque, String Combs_indicado, String Combs_selecionado, double L_abastecidos) {
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

    public int getId_veiculo() {
        return veiculo_id;
    }

    public void setId_veiculo(int veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    public LocalDateTime getDt_Abastecimento() {
        return Dt_Abastecimento;
    }

    public void setDt_Abastecimento(LocalDateTime Dt_Abastecimento) {
        this.Dt_Abastecimento = Dt_Abastecimento;
    }

    public double getprecoGas() {
        return precoGas;
    }

    public void setprecoGas(double precoGas) {
        this.precoGas = precoGas;
    }

    public double getprecoEta() {
        return precoGas;
    }

    public void getprecoEta(double precoEta) {
        this.precoEta = precoEta;
    }

    public String getCombs_indicado() {
        return Combs_indicado;
    }

    public void setCombs_indicado(String Combs_indicado) {
        this.Combs_indicado = Combs_indicado;
    }

    public String getCombs_selecionado() {
        return Combs_selecionado;
    }

    public void setCombs_selecionado(String Combs_selecionado) {
        this.Combs_selecionado = Combs_selecionado;
    }


    public double getKM_abastecimento() {
        return kmAbastecimento_veiculo;
    }

    public void setKM_abastecimento(double kmAbastecimento_veiculo) {
        this.kmAbastecimento_veiculo = kmAbastecimento_veiculo;
    }


    public double getTanque() {
        return capacidade_tanque;
    }

    public void setTanque(double capacidade_tanque) {
        this.capacidade_tanque = capacidade_tanque;
    }

    public double getLitrosAbastecidos() {
        return L_abastecidos;
    }

    public void setLitrosAbastecidos(double L_abastecidos) {
        this.L_abastecidos = L_abastecidos;
    }


    public static double calcular(double vGas, double vEta){
        return vEta/vGas;
    }

    public static  double calculaMedia(double kmL, double vGas){
        return kmL/vGas;
    }


}

