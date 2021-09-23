/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Model.Equipamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class EquipamentoDAO extends ExecuteSQL {

    public EquipamentoDAO(Connection conexao) {
        super(conexao);
    }

    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_equipamento ORDER BY nome_equipamento");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Equipamento e = new Equipamento(
                            rs.getInt(1),
                            rs.getString(2),                            
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getString(5)
                    );
                    lista.add(e);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Equipamento selecionaEquipamento(String nome) {
        ResultSet rs = listar("SELECT * FROM tb_equipamento WHERE nome_equipamento = ?", nome);
        Equipamento e = new Equipamento();
        try {
            if (rs != null) {
                while (rs.next()) {
                    e.setId(rs.getInt(1));
                    e.setNome(rs.getString(2));
                    e.setDescricao(rs.getString(3));
                    e.setFornecedor(rs.getInt(4));
                    e.setExercicio(rs.getString(5));
                    
                }
                return e;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Cliente selecionaEquipamento(int id) {
        ResultSet rs = listar("SELECT * FROM tb_equipamento WHERE id_equipamento = ?", String.valueOf(id));
        Cliente c = new Cliente();
        try {
            if (rs != null) {
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setDataNascimento(rs.getDate(3));
                    c.setCpf(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setEndereco(rs.getString(7));
                    c.setPlano(rs.getString(8));
                    c.setPersonal(rs.getInt(9));                      
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean addEquipamento(Equipamento e) {
        String dados[] = new String[]{
            e.getNome(),        
            e.getDescricao(),
            Integer.toString(e.getFornecedor()),
            e.getExercicio()
        };
        return executar("INSERT INTO tb_equipamento (nome_equipamento, descricao_equipamento, id_fornec, exercicio_equipamento) VALUES (?,?,?,?)", dados);
    }

    public boolean altEquipamento(Equipamento eq) {
        String dados[] = new String[]{
            String.valueOf(eq.getDescricao()),
            String.valueOf(eq.getFornecedor()),
            String.valueOf(eq.getExercicio()),
            String.valueOf(eq.getNome()),};
        return executar("UPDATE tb_equipamento SET  descricao_equipamento= ? , id_fornec   = ? , exercicio_equipamento  = ? WHERE nome_equipamento = ?", dados);
    }

    public boolean delEquipamento(Equipamento e) {
        return executar("DELETE FROM tb_equipamento WHERE nome_equipamento= ?", e.getNome());
    }

    public boolean existeEquipamento(String nome) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_equipamento WHERE nome_equipamento = ?", nome);
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
