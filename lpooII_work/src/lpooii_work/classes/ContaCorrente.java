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
    
    public ContaCorrente(double depositoInicial, double limite) {
        this.depositoInicial = depositoInicial;
        this.limite = limite;
    }

    @Override
    public boolean saca(double valor) {
        if (this.saldo - valor < limite) {
            // saque inválido, mostrar na tela isso
            return false;
        }
        return super.saca(valor);
    }

    @Override
    public void remunera() {
        this.saldo = this.saldo * 1.01;
    }
}
