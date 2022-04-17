/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.controller;

import java.io.IOException;
import lpooii_work.database.ConnectionFactory;
import lpooii_work.models.Conta;
import lpooii_work.models.dao.ContaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import lpooii_work.database.DAOException;
import lpooii_work.models.Cliente;

/**
 *
 * @author leonardozanotti
 */
public class ContaController {
    public static void inserir(Conta conta) throws DAOException, IOException, SQLException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ContaDAO dao = new ContaDAO(factory.getConnection());
            dao.inserir(conta);
        }
    }

    public static Conta getByCliente(Cliente cliente) throws DAOException, IOException, SQLException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ContaDAO dao = new ContaDAO(factory.getConnection());
            return dao.getByCliente(cliente.getId());
        }
    }

    public static Conta getContaByCPF(String search) throws DAOException, IOException, SQLException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ContaDAO dao = new ContaDAO(factory.getConnection());
            return dao.getContaByCPF(search);
        }
    }

    public static void atualizar(Conta conta) throws DAOException, IOException, SQLException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ContaDAO dao = new ContaDAO(factory.getConnection());
            dao.atualizar(conta);
        }
    }
    
}
