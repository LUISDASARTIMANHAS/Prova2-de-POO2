/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author jean_
 */
public class ProdutoDAO {

    public ProdutoDAO() {

    }

    public void inserir(Produto prod) throws ClassNotFoundException, SQLException {
        // Insere todos os dados do produto no banco de dados       
        // Observe que o parâmetro é um objeto do tipo Produto, 
        //   portanto você deverá ler de um Frame os dados, criar um objeto 
        //   do tipo Produto e passar como parâmetro para essa função
        // O ID do Produto é auto numeração

        String sql = "INSERT INTO public.produto(nome, quantidade, preco) VALUES (?, ?, ?);";

        PreparedStatement stmt = ConexaoPSQL.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        int col = 1;
        stmt.setString(col++, prod.getNome());
        stmt.setInt(col++, prod.getQuantidade());
        stmt.setFloat(col++, prod.getPreco());

        stmt.execute();

        // PEGAR O NÚMERO GERADO
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            prod.setIdProduto(id);
        }

    }

    public List<Produto> listar() throws SQLException, ClassNotFoundException {
        // Pesquisa no banco e retorna, através de um List,
        // todos os produtos

        List<Produto> lista = new ArrayList();

        Statement stmt = ConexaoPSQL.obterConexao().createStatement();

        String sql = "SELECT * FROM Produto";

        ResultSet rs = stmt.executeQuery(sql);

        // Criar uma LISTA DE OBJETOS
        while (rs.next()) {
            Produto cid = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getInt("quantidade"), rs.getFloat("preco"));
            lista.add(cid);
        }

        return lista;

    }

}
