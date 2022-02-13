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
public class Conta implements ContaI {

    public Conta() {
        
    }
    
    @Override
    public boolean deposita(double valor) {
        return valor > 0;
    }

    @Override
    public boolean saca(double valor) {
        // show message in the screen
        return valor > 0;
    }

    @Override
    public Cliente getDono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remunera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
