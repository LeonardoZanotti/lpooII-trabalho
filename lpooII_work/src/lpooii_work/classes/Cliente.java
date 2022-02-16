/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.classes;

/**
 *
 * @author leonardozanotti
 */
public class Cliente {
    private String nome, sobrenome, rg, cpf, endereco;
    private int id, conta;
    
    public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco, int conta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.conta = conta;
    }
    
    public String getFullName() {
        return this.nome + " " + this.sobrenome;
    }
}
