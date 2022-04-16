/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.models.dao;

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
import lpooii_work.models.Conta;
import lpooii_work.models.ContaCorrente;
import lpooii_work.models.ContaInvestimento;

/**
 *
 * @author leonardozanotti
 */
public class ContaDAO implements DAO<Conta> {
    private static final String QUERY_INSERIR_CONTA_CORRENTE = "INSERT INTO tb_conta (saldo_conta, deposito_inicial_conta, limite_conta, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
    private static final String QUERY_INSERIR_CONTA_INVESTIMENTO = "INSERT INTO tb_conta (saldo_conta, deposito_inicial_conta, deposito_minimo_conta, montante_minimo_conta, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM tb_conta WHERE id_conta = (?)";
    private static final String QUERY_BUSCAR_POR_CLIENTE = "SELECT * FROM tb_conta WHERE id_cliente = (?)";
    private static final String QUERY_BUSCAR_POR_CPF = "SELECT * FROM tb_conta INNER JOIN tb_cliente on tb_conta.id_cliente = tb_cliente.id_cliente WHERE tb_cliente.cpf_cliente LIKE CONCAT('%',?,'%')";
    private static final String QUERY_REMOVER = "DELETE FROM tb_conta WHERE id_conta = (?)";
    private Connection con = null;

    public ContaDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ContaDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Conta buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ContaDAO.QUERY_BUSCAR)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    if (rs.getInt("tipo_conta") == 1)
                        return new ContaCorrente(
                                rs.getInt("id_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getDouble("limite_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
                    else
                        return new ContaInvestimento(
                                rs.getInt("id_conta"),
                                rs.getDouble("saldo_conta"),
                                rs.getDouble("montante_minimo_conta"),
                                rs.getDouble("deposito_minimo_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando cliente: " + ContaDAO.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Conta> buscarTodos() throws DAOException {
        throw new DAOException("Método não implementado!");
    }

    @Override
    public void inserir(Conta c) throws DAOException {
        String realQuery = ContaDAO.QUERY_INSERIR_CONTA_CORRENTE;
        if (c.getTipo() == 2) realQuery = ContaDAO.QUERY_INSERIR_CONTA_INVESTIMENTO;
        try (PreparedStatement st = con.prepareStatement(realQuery)) {
            if (c.getTipo() == 1) {     // conta corrente
                st.setDouble(1, c.getSaldo());
                st.setDouble(2, c.getDepositoInicial());
                st.setDouble(3, c.getLimite());
                st.setInt(4, c.getTipo());
                st.setInt(5, c.getIdCliente());
            } else {                    // conta investimento
                st.setDouble(1, c.getSaldo());
                st.setDouble(2, c.getDepositoInicial());
                st.setDouble(3, c.getDepositoMinimo());
                st.setDouble(4, c.getMontanteMinimo());
                st.setInt(5, c.getTipo());
                st.setInt(6, c.getIdCliente());
            }
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo conta: " + realQuery + "/ " + c.toString(), e);
        }
    }

    @Override
    public void atualizar(Conta c) throws DAOException {
        throw new DAOException("Método não implementado!");
    }

    @Override
    public void remover(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ContaDAO.QUERY_REMOVER)) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo conta: " + ContaDAO.QUERY_REMOVER + "/ id=" + id, e);
        }
    }

    public Conta getByCliente(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ContaDAO.QUERY_BUSCAR_POR_CLIENTE)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    if (rs.getInt("tipo_conta") == 1)
                        return new ContaCorrente(
                                rs.getInt("id_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getDouble("limite_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
                    else
                        return new ContaInvestimento(
                                rs.getInt("id_conta"),
                                rs.getDouble("saldo_conta"),
                                rs.getDouble("montante_minimo_conta"),
                                rs.getDouble("deposito_minimo_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando conta do cliente: " + ContaDAO.QUERY_BUSCAR_POR_CLIENTE, e);
        }
    }

    public Conta getContaByCPF(String search) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ContaDAO.QUERY_BUSCAR_POR_CPF)) {
            st.setString(1, search);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    if (rs.getInt("tipo_conta") == 1)
                        return new ContaCorrente(
                                rs.getInt("id_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getDouble("limite_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
                    else
                        return new ContaInvestimento(
                                rs.getInt("id_conta"),
                                rs.getDouble("saldo_conta"),
                                rs.getDouble("montante_minimo_conta"),
                                rs.getDouble("deposito_minimo_conta"),
                                rs.getDouble("deposito_inicial_conta"),
                                rs.getInt("tipo_conta"),
                                rs.getInt("id_cliente")
                        );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando conta do cliente pelo CPF: " + ContaDAO.QUERY_BUSCAR_POR_CPF, e);
        }
    }
}

