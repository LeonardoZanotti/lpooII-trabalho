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
public class ContaInvestimento extends Conta {
    public ContaInvestimento(double saldo, double montanteMinimo, double depositoMinimo, double depositoInicial, int tipo, int idCliente) {
        this.saldo = saldo;
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
        this.depositoInicial = depositoInicial;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }
    
    public ContaInvestimento(int id, double saldo, double montanteMinimo, double depositoMinimo, double depositoInicial, int tipo, int idCliente) {
        this.id = id;
        this.saldo = saldo;
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
        this.depositoInicial = depositoInicial;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    @Override
    public boolean saca(double valor) {
        if (this.saldo - valor < montanteMinimo) {
            return false;
        }
        return super.saca(valor);
    }
    
    @Override
    public boolean deposita(double valor) {
        if (valor < this.depositoMinimo) {
            return false;
        }
        return super.deposita(valor);
    }

    @Override
    public void remunera() {
        this.saldo = this.saldo * 1.02;
        try {
            ContaController.atualizar(this);
        } catch (DAOException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
