/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

/**
 *
 * @author jean_
 */

//Em formato americano, a data é escrita no formato mês/dia/ano, ou seja, MM/DD/YYYY. 
//Por exemplo, a data de hoje, 20 de abril de 2025, 
//seria escrita como 04/20/2025

//formato de data para o tipo de dado "date" no PostgreSQL é yyyy-mm-dd .
//Este é o formato usado tanto para armazenar quanto para inserir dados.
public class VendaDAO {

    public VendaDAO() {

    }

    public void inserir(Venda vend) throws SQLException, ClassNotFoundException {
        // Insere todos os dados da Venda no banco de dados       
        // Observe que o parâmetro é um objeto do tipo Venda, 
        //   portanto você deverá ler de um Frame os dados, criar um objeto 
        //   do tipo Venda e passar como parâmetro para essa função
        // O ID da Venda é auto numeração

        String sql = "INSERT INTO public.venda(datavenda, qtdevendida, valortotal, idproduto)VALUES (?, ?, ?, ?, ?);";

        PreparedStatement stmt = ConexaoPSQL.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        int col = 1;
        stmt.setDate(col++, vend.getDataVenda());
        stmt.setInt(col++, vend.getQtdeVendida());
        stmt.setFloat(col++, vend.getValorTotal());

        stmt.setInt(col++, vend.getIdProduto());

        stmt.execute();

        // PEGAR O NÚMERO GERADO
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            vend.setIdProduto(id);
        }
    }

    public Venda pesquisar(int idVenda) throws SQLException, ClassNotFoundException {
        // Pesquisa no banco e retorna um objeto do tipo Venda
        //    de acordo com o id da venda

        String sql = "SELECT * "
                + "FROM public.venda vendaOnBank"
                + "WHERE vendaOnBank.idVenda = " + idVenda;
        Statement stmt = ConexaoPSQL.obterConexao().createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        Venda item = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getInt("qtdeVendida"), rs.getFloat("valorTotal"), rs.getInt("idProduto"));
        return item;

    }

    public List<Venda> listar() throws SQLException, ClassNotFoundException {
        // Pesquisa no banco e retorna, através de um List,
        // todas as vendas
        List<Venda> lista = new ArrayList();

        Statement stmt = ConexaoPSQL.obterConexao().createStatement();

        String sql = "SELECT * FROM Venda";

        ResultSet rs = stmt.executeQuery(sql);

        // Criar uma LISTA DE OBJETOS
        while (rs.next()) {
            Venda item = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getInt("qtdeVendida"), rs.getFloat("valorTotal"), rs.getInt("idProduto"));
            lista.add(item);
        }

        return lista;
    }

    public List<Venda> listarVendasDia(Date dataPesq) throws SQLException, ClassNotFoundException {
        // Pesquisa no banco e retorna, através de um List,
        // todas as vendas de um determinado dia, passando pelo parâmetro
        List<Venda> lista = new ArrayList();

        Statement stmt = ConexaoPSQL.obterConexao().createStatement();

//        yyyy-mm-dd
        String sql = "SELECT * "
                + "FROM public.venda vendaOnBank"
                + "WHERE vendaOnBank.datavenda = " + dataPesq;
        
        ResultSet rs = stmt.executeQuery(sql);

        // Criar uma LISTA DE OBJETOS
        while (rs.next()) {
            Venda item = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getInt("qtdeVendida"), rs.getFloat("valorTotal"), rs.getInt("idProduto"));
            lista.add(item);
        }

        return lista;

    }

}
