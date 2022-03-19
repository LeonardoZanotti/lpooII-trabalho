/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leonardozanotti
 */
public class ConnectionFactory implements AutoCloseable {
    // --- MUDAR ESTAS VARIÁVEIS CONFORME SUAS CONFIGURAÇÕES ---
    private static String DATABASE = "lpooii";              // nome do banco de dados
    private static String LOGIN = "leonardozanotti";        // login do postgres
    private static String SENHA = "leo123";                 // senha do postgres
    
    private static String DRIVER = "org.postgresql.Driver";
    private static String URL = String.join(" ", "jdbc:postgresql://localhost:5432/", ConnectionFactory.DATABASE);
    
    private Connection con = null;
    
    public Connection getConnection() throws DAOException {
        if (this.con == null) {
            try {
                Class.forName(this.DRIVER);
                this.con = DriverManager.getConnection(this.URL, this.LOGIN, this.SENHA);
            }
            catch (ClassNotFoundException e) {
                throw new DAOException("Driver do banco não encontrado: " + this.DRIVER, e);
            }
            catch (SQLException e) {
                throw new DAOException("Erro conectando ao banco de dados: " + this.URL + "/" + this.LOGIN + "/" + this.SENHA, e);
            }
        }
        return this.con;
    }
    
    @Override
    public void close() throws Exception {
        if (this.con != null) {
            try {
                this.con.close();
                this.con = null;
            }
            catch (Exception e) {
                System.out.println("Erro fechando a conexão.");
                e.printStackTrace();
            }
        }
    }
}
