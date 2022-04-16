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
public class ContaCorrente extends Conta {
    public ContaCorrente(double saldo, double depositoInicial, double limite, int tipo, int idCliente) {
        this.saldo = saldo;
        this.depositoInicial = depositoInicial;
        this.limite = limite;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }
    
    public ContaCorrente(int id, double saldo, double depositoInicial, double limite, int tipo, int idCliente) {
        this.id = id;
        this.saldo = saldo;
        this.depositoInicial = depositoInicial;
        this.limite = limite;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    @Override
    public boolean saca(double valor) {
        if (this.saldo - valor < limite) {
            return false;
        }
        return super.saca(valor);
    }

    @Override
    public void remunera() {
        this.saldo = this.saldo * 1.01;
        try {
            ContaController.atualizar(this);
        } catch (DAOException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
