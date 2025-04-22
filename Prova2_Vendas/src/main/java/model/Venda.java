/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author jean_
 */
public class Venda {

    private int idVenda;
    private Date dataVenda;
    private int qtdeVendida;
    private float valorTotal;
    private int idProduto;

//    sem id
    public Venda(Date dataVenda, int qtdeVendida, float valorTotal, int idProduto) {
        this.dataVenda = dataVenda;
        this.qtdeVendida = qtdeVendida;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
    }
    
//    com id
    public Venda(int idVenda, Date dataVenda, int qtdeVendida, float valorTotal, int idProduto) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.qtdeVendida = qtdeVendida;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
