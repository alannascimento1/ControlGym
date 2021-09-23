/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 
 */
public class AdminDAO extends ExecuteSQL {
    
    public AdminDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean logarUsuario(String login, String senha) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_admin WHERE nome_admin = ? AND senha_admin= ?", new String[]{login, senha});
        Admin ad = new Admin();

        try {
            if (rs != null) {
                while (rs.next()) {
                    ad.setId(rs.getInt(1));
                    ad.setNome(rs.getString(2));
                    ad.setSenha(rs.getString(3));
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
    
    
    
}
