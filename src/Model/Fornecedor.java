/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

public class Fornecedor {
    private int id; 
    private String nome;
    private String email;
    private String endereco;
    private String descricao;

    public Fornecedor(int id, String nome, String email, String endereco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.descricao = descricao;
    }
    
    public Fornecedor() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
