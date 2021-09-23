/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class UsuarioDAO extends FuncionarioDAO{
    
    public UsuarioDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean logarUsuario(String login, String senha) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_admin WHERE nome_admin = ? AND senha_admin = ?", new String[]{login, senha});
        try {
            if (rs != null) {
                while (rs.next()) {
                    Usuario.setId_admin(rs.getInt(1));
                    Usuario.setNome_admin(rs.getString(2));
                    Usuario.setSenha_admin(rs.getString(3));
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
    
    public Usuario selecionaUsuario() {
        ResultSet rs = listar("SELECT * FROM tb_admin");
        Usuario u = new Usuario();
        try {
            if (rs != null) {
                while (rs.next()) {
                    u.setId_admin(rs.getInt(1));
                    u.setNome_admin(rs.getString(2));
                    u.setSenha_admin(rs.getString(3));
                }
                return u;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }   
    
    public boolean altUsuario(Usuario us) {
        String dados[] = new String[]{
            String.valueOf(us.getNome_admin()),
            String.valueOf(us.getSenha_admin()),};
        return executar("UPDATE tb_admin SET nome_admin = ?, senha_admin = ?", dados);
    }    
}
