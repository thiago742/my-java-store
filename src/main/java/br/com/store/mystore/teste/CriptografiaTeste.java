package br.com.store.mystore.teste;

import br.com.store.mystore.util.CriptografiaUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CriptografiaTeste {

    public static void main(String[] args) {
        try {
            System.out.println(CriptografiaUtils.criptografar("123456"));
            System.out.println(CriptografiaUtils.criptografar("123456"));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
