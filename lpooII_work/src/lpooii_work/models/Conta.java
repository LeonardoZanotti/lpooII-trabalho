/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.models;

import lpooii_work.models.ContaI;

/**
 *
 * @author leonardozanotti
 */
public abstract class Conta implements ContaI {
    public int id, tipo;
    public double saldo = 0, depositoInicial, limite, montanteMinimo, depositoMinimo;

    public Conta() {
        
    }
    
    @Override
    public boolean deposita(double valor) {
        if (valor <= 0)
            return false;
        // show message in the screen
        this.saldo += valor;
        return true;
    }

    @Override
    public boolean saca(double valor) {
        if (valor <= 0)
            return false;
        // show message in the screen
        this.saldo -= valor;
        return true;
    }

    @Override
    public Cliente getDono() {
        // get data from database (find client where account id equals this id)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumero() {
        return this.id;
    }
    
    @Override
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }

}
