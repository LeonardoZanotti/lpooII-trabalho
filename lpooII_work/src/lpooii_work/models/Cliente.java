/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.models;

import java.io.IOException;
import java.sql.SQLException;
import lpooii_work.controller.ContaController;
import lpooii_work.database.DAOException;

/**
 *
 * @author leonardozanotti
 */
public class Cliente implements Comparable {
    private String nome, sobrenome, rg, cpf, endereco;
    private int id, conta;
    
    public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public Cliente(int id, String nome, String sobrenome, String rg, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public String getFullName() {
        return this.nome + " " + this.sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object cliente) {
        Cliente c = (Cliente) cliente;
        return this.getFullName().compareTo(c.getFullName());
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", rg=" + rg + ", cpf=" + cpf + ", endereco=" + endereco + ", id=" + id + '}';
    }
    
    public Conta getConta() throws DAOException, IOException, SQLException {
        return ContaController.getByCliente(this);
    }
    
    public void setConta(int conta) {
        this.conta = conta;
    }
}
