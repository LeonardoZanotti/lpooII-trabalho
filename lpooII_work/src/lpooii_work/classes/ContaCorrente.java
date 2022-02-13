/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.classes;

/**
 *
 * @author leonardozanotti
 */
public class ContaCorrente extends Conta {
    private double depositoInicial, limite;
    private int numero, count = 0;
    
    public ContaCorrente(double depositoInicial, double limite) {
        this.depositoInicial = depositoInicial;
        this.limite = limite;
        count++;
        this.numero = count;
    }
}
