/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Model.Fornecedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class FornecedorDAO extends ExecuteSQL {

    public FornecedorDAO(Connection conexao) {
        super(conexao);
    }

    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_fornecedor ORDER BY nome_fornecedor");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Fornecedor f = new Fornecedor(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                            
                    );
                    lista.add(f);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
       

    public Fornecedor selecionaFornecedor(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_fornecedor WHERE nome_fornecedor = ?", nome);
        Fornecedor f = new Fornecedor();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setEmail(rs.getString(3));
                    f.setEndereco(rs.getString(4));
                    f.setDescricao(rs.getString(5));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
   public Fornecedor selecionaFornecedor(int id) {
        ResultSet rs = listar("SELECT * FROM tb_fornecedor WHERE id_fornecedor = ?", String.valueOf(id));
        Fornecedor f = new Fornecedor();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setEmail(rs.getString(3));
                    f.setEndereco(rs.getString(4));
                    f.setDescricao(rs.getString(5));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }    
    
   

    public boolean addFornecedor(Fornecedor f) {
        String dados[] = new String[]{
            f.getNome(),
            f.getEmail(),
            f.getEndereco(),
            f.getDescricao()
            
        };
        return executar("INSERT INTO tb_fornecedor (nome_fornecedor, email_fornecedor, endereco_fornecedor, descricao_fornecedor) VALUES (?,?,?,?)", dados);
    }

    public boolean altFornecedor(Fornecedor f) {
        String dados[] = new String[]{
            String.valueOf(f.getNome()),
            String.valueOf(f.getEmail()),
            String.valueOf(f.getEndereco()),
            String.valueOf(f.getDescricao()),
            String.valueOf(f.getNome()),};
        return executar("UPDATE tb_fornecedor SET nome_fornecedor = ?, email_fornecedor = ? , endereco_fornecedor = ? , descricao_fornecedor = ? WHERE nome_fornecedor = ?", dados);
    }

    public boolean delFornecedor(Fornecedor f) {

        return executar("DELETE FROM tb_fornecedor WHERE nome_fornecedor = ?", f.getNome());
    }

    public boolean existeFornecedor(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_fornecedor WHERE nome_fornecedor = ?", nome);
        try {
            if (rs != null) {
                while (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }

}
