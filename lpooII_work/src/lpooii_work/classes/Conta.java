/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.classes;

import lpooii_work.models.ContaI;

/**
 *
 * @author leonardozanotti
 */
public abstract class Conta implements ContaI {
    public int id; // número da conta (usado apenas na conta corrente)
    public double saldo = 0;
    
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
    public double getSaldo() {
        return this.saldo;
    }
    
}
