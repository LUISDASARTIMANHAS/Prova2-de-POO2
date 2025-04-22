/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConexaoPSQL;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Produto;
import model.Venda;

/**
 *
 * @author jean
 */
public class GerenciadorDominio {

    private ProdutoDAO produtoDao;
    private VendaDAO vendaDAO;

    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        ConexaoPSQL.obterConexao();

        // Instânciar as classes DAO
        produtoDao = new ProdutoDAO();
        vendaDAO = new VendaDAO();
    }

    public List<Produto> listarProdutos() throws ClassNotFoundException, SQLException {
        return produtoDao.listar();
    }

    public List<Venda> listarVendas() throws ClassNotFoundException, SQLException {
        return vendaDAO.listar();
    }

    public void inserirProduto(String nome, int quantidade, float preco) throws ClassNotFoundException, SQLException {

        Produto item = new Produto(nome, quantidade, preco);
        produtoDao.inserir(item);
    }

}
