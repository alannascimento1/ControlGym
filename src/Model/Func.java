package Model;

import java.util.Date;

/**
 *
 * 
 */
public class Func {
    private int id; 
    private String nome;
    private String cpf; 
    private Date dataDeNascimeto;
    private String telefone; 
    private String email;

    public Func(int id, String nome, String cpf, Date dataDeNascimeto, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimeto = dataDeNascimeto;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Func () {
        
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimeto() {
        return dataDeNascimeto;
    }

    public void setDataDeNascimeto(Date dataDeNascimeto) {
        this.dataDeNascimeto = dataDeNascimeto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 
    
    
}