package com.senac.cicero.cardviewapplication.model;

public class Produto {

        private String nomeProduto;
        private Double precProduto;
        private int idProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecProduto() {
        return precProduto;
    }

    public void setPrecProduto(Double precProduto) {
        this.precProduto = precProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "nome do Produto: " + getNomeProduto()
                + "\nPreço do Produto:  " + getPrecProduto();
    }
}
