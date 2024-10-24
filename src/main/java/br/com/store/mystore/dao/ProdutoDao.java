package br.com.store.mystore.dao;

import br.com.store.mystore.exception.DBException;
import br.com.store.mystore.model.Produto;

import java.util.List;

public interface ProdutoDao {
    void cadastrar(Produto produto) throws DBException;

    void atualizar(Produto produto) throws DBException;

    void remover(int codigo) throws DBException;

    Produto buscar(int id);

    List<Produto> listar();
}
