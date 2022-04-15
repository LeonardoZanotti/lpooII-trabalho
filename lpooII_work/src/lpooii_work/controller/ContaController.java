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
    
}
