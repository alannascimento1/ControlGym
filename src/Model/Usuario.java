/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 */
public class Usuario {
    
    private static int id_admin;
    private static String nome_admin;
    private static String senha_admin;

    public Usuario() {
    }

    public static int getId_admin() {
        return id_admin;
    }

    public static void setId_admin(int id_admin) {
        Usuario.id_admin = id_admin;
    }

    public static String getNome_admin() {
        return nome_admin;
    }

    public static void setNome_admin(String nome_admin) {
        Usuario.nome_admin = nome_admin;
    }

    public static String getSenha_admin() {
        return senha_admin;
    }

    public static void setSenha_admin(String senha_admin) {
        Usuario.senha_admin = senha_admin;
    }

   
}
