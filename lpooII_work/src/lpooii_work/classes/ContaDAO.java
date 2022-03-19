/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.classes;

/**
 *
 * @author leonardozanotti
 */

import lpooii_work.database.DAO;
import lpooii_work.database.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leonardozanotti
 */
public class ContaDAO implements DAO<Conta> {
    private static final String QUERY_INSERIR = "INSERT INTO tb_conta (saldo_conta, deposito_inicial_conta, deposito_minimo_conta, limite_conta, montante_minimo_conta, tipo_conta) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM tb_conta WHERE id_conta = (?)";
    private static final String QUERY_REMOVER = "DELETE FROM tb_conta WHERE id_conta = (?)";
    private Connection con = null;

    public ContaDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ClienteDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Conta buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(this.QUERY_BUSCAR)) {
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next())
                if (rs.getInt("tipo_conta") == 1)
                    return new ContaCorrente(
                        rs.getInt("id_conta"),
                        rs.getDouble("deposito_inicial_conta"),
                        rs.getDouble("limite_conta")
                    );
                else
                    return new ContaInvestimento(
                        rs.getInt("id_conta"),
                        rs.getDouble("saldo_conta"),
                        rs.getDouble("montante_minimo_conta"),
                        rs.getDouble("deposito_minimo_conta"),
                        rs.getDouble("deposito_inicial_conta")
                    );
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando cliente: " + this.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Conta> buscarTodos() throws DAOException {
        throw new DAOException("Método não implementado!");
    }

    @Override
    public void inserir(Conta c) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(this.QUERY_INSERIR)) {
            if (c.getTipo() == 1) {     // conta corrente
                st.setDouble(1, c.getSaldo());
                st.setDouble(2, c.getDepositoInicial());
                st.setDouble(4, c.getLimite());
            } else {                    // conta investimento
                st.setDouble(1, c.getSaldo());
                st.setDouble(2, c.getDepositoInicial());
                st.setDouble(3, c.getDepositoMinimo());
                st.setDouble(5, c.getMontanteMinimo());
            }
            st.setInt(6, c.getTipo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo conta: " + this.QUERY_INSERIR + "/ " + c.toString(), e);
        }
    }

    @Override
    public void atualizar(Conta c) throws DAOException {
        throw new DAOException("Método não implementado!");
    }

    @Override
    public void remover(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(this.QUERY_REMOVER)) {
            Conta c = this.buscar(id);
            st.setInt(1, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo conta: " + this.QUERY_REMOVER + "/ id=" + id, e);
        }
    }
}

