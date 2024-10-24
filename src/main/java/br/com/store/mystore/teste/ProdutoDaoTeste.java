package br.com.store.mystore.teste;

import br.com.store.mystore.dao.ProdutoDao;
import br.com.store.mystore.exception.DBException;
import br.com.store.mystore.factory.DaoFactory;
import br.com.store.mystore.model.Produto;

import java.time.LocalDate;
import java.util.List;

public class ProdutoDaoTeste {
    public static void main(String[] args) {
        ProdutoDao dao = DaoFactory.getProdutoDAO();//Cadastrar um produto
        Produto produto = new Produto(
                0,
                "Teclado ABNT2",
                55.49,
                200,
                LocalDate.of(2024, 8, 1));
        try {
            dao.cadastrar(produto);
        } catch (DBException e) {
            e.printStackTrace();
        }


        //Buscar um produto pelo código e atualizar
        produto = dao.buscar(1);
        produto.setNome("Mouse Cobra");
        produto.setValor(119.89);
        try {
            dao.atualizar(produto);
        } catch (DBException e) {
            e.printStackTrace();
        }

        //listar produtos
        List<Produto> lista = dao.listar();
        for (Produto item : lista) {
            System.out.println(item.getNome() + " " + item.getQuantidade() + " " + item.getValor());
        }

        //remover produto
        try {
            dao.remover(1);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
