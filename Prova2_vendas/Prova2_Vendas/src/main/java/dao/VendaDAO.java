/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import model.Venda;

/**
 *
 * @author jean_
 */

public class VendaDAO {
    
    public VendaDAO() {
        
    }
    
    public void inserir(Venda vend) {
        // Insere todos os dados da Venda no banco de dados       
        // Observe que o parâmetro é um objeto do tipo Venda, 
        //   portanto você deverá ler de um Frame os dados, criar um objeto 
        //   do tipo Venda e passar como parâmetro para essa função
        // O ID da Venda é auto numeração
    }
    
    public Venda pesquisar(int idVenda) {
        // Pesquisa no banco e retorna um objeto do tipo Venda
        //    de acordo com o id da venda
        
        
    }
    
    public List<Venda> listar() {
        // Pesquisa no banco e retorna, através de um List,
        // todas as vendas
        
        
    }
    
    
    public List<Venda> listarVendasDia(Date dataPesq){
        // Pesquisa no banco e retorna, através de um List,
        // todas as vendas de um determinado dia, passando pelo parâmetro
        
        
   }

}
