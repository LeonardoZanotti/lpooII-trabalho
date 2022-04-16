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
        try (Connection con = new ConnectionFactory().getConnection()) {
            ContaDAO dao = new ContaDAO(con);
            dao.inserir(conta);
        }
    }

    public static Conta getByCliente(Cliente cliente) throws DAOException, IOException, SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ContaDAO dao = new ContaDAO(con);
            return dao.getByCliente(cliente.getId());
        }
    }

    public static Conta getContaByCPF(String search) throws DAOException, IOException, SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ContaDAO dao = new ContaDAO(con);
            return dao.getContaByCPF(search);
        }
    }
    
}
