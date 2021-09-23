/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Func;
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
public class FuncionarioDAO extends ExecuteSQL {

    public FuncionarioDAO(Connection conexao) {
        super(conexao);
    }

    public List<Func> listarFuncionarios() {
        List<Func> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_funcionario ORDER BY nome_funcionario");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Func f = new Func(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getString(6)
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

    public Func selecionaFuncionario(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE nome_funcionario = ?", nome);
        Func f = new Func();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setCpf(rs.getString(3));
                    f.setDataDeNascimeto(rs.getDate(4));
                    f.setTelefone(rs.getString(5));
                    f.setEmail(rs.getString(6));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Func selecionaFuncionario(int id) {
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE id_funcionario = ?", String.valueOf(id));
        Func f = new Func();
        try {
            if (rs != null) {
                while (rs.next()) {
                    f.setId(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setCpf(rs.getString(3));
                    f.setDataDeNascimeto(rs.getDate(4));
                    f.setTelefone(rs.getString(5));
                    f.setEmail(rs.getString(6));
                }
                return f;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addFuncionario(Func f) { 
        String dados[] = new String[]{           
            f.getNome(),
            f.getCpf(),
            new SimpleDateFormat("yyyy-MM-dd").format(f.getDataDeNascimeto()),
            f.getTelefone(),
            f.getEmail(),
        };
        return executar("INSERT INTO tb_funcionario (nome_funcionario, cpf_funcionario, datadenascimento_funcionario, telefone_funcionario, email_funcionario) VALUES (?,?,?,?,?)", dados);
    }
    
    public boolean altFuncionario(Func f) { 
        String dados[] = new String[]{
            f.getCpf(),
            new SimpleDateFormat("yyyy-MM-dd").format(f.getDataDeNascimeto()),
            f.getEmail(),
            f.getTelefone(),
            f.getNome()
        };
        return executar("UPDATE tb_funcionario SET cpf_funcionario = ?, dataDeNascimento_funcionario  = ?, email_funcionario = ? , telefone_funcionario = ? WHERE nome_funcionario = ?", dados);
    }

    public boolean delFuncionario(Func f) {
        
        return executar("DELETE FROM tb_funcionario WHERE nome_funcionario = ?", f.getNome());
    }
    
    public boolean existeLoginFuncionario(String login) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE login_funcionario = ?", login);
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
    
    public boolean existeFuncionario(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_funcionario WHERE nome_funcionario = ?", nome);
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
