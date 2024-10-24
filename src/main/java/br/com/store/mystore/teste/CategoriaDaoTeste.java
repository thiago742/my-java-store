package br.com.store.mystore.teste;

import br.com.store.mystore.dao.CategoriaDao;
import br.com.store.mystore.factory.DaoFactory;
import br.com.store.mystore.model.Categoria;

import java.util.List;

public class CategoriaDaoTeste {

    public static void main(String[] args) {
        CategoriaDao dao = DaoFactory.getCategoriaDAO();

        List<Categoria> lista = dao.listar();
        for(Categoria categoria : lista){
            System.out.println(categoria.getCodigo() + " " + categoria.getNome());
        }
    }
}
