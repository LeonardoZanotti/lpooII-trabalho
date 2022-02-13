/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.classes;

/**
 *
 * @author leonardozanotti
 */
public class ContaInvestimento extends Conta {
    private double montanteMinimo, depositoMinimo, depositoInicial;
    
    public ContaInvestimento(double montanteMinimo, double depositoMinimo, double depositoInicial) {
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
        this.depositoInicial = depositoInicial;
    }
}
