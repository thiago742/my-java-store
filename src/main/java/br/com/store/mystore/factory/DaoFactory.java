package br.com.store.mystore.factory;

import br.com.store.mystore.dao.CategoriaDao;
import br.com.store.mystore.dao.ProdutoDao;
import br.com.store.mystore.dao.impl.OracleCategoriaDao;
import br.com.store.mystore.dao.impl.OracleProdutoDao;
import br.com.store.mystore.dao.impl.OracleUsuarioDao;

public class DaoFactory {
    public static ProdutoDao getProdutoDAO() {
        return new OracleProdutoDao();
    }
    public static CategoriaDao getCategoriaDAO() {
        return new OracleCategoriaDao();
    }
    public static OracleUsuarioDao getUsuarioDAO() {
        return new OracleUsuarioDao();
    }
}