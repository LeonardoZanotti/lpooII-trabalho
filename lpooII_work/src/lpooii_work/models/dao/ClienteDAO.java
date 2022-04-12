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
import java.util.ArrayList;
import java.util.List;
import lpooii_work.models.Cliente;

/**
 *
 * @author leonardozanotti
 */
public class ClienteDAO implements DAO<Cliente> {
    private static final String QUERY_INSERIR = "INSERT INTO tb_cliente (nome_cliente, sobrenome_cliente, rg_cliente, cpf_cliente, endereco_cliente) VALUES (?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM tb_cliente WHERE id_cliente = (?)";
    private static final String QUERY_SEARCH = "SELECT * FROM tb_cliente WHERE nome_cliente LIKE '%(?)%' OR sobrenome_cliente LIKE '%(?)%' OR rg_cliente LIKE '%(?)%' OR cpf_cliente LIKE '%(?)%'";
    private static final String QUERY_SEARCH_CPF_ONLY = "SELECT * FROM tb_cliente WHERE cpf_cliente = (?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM tb_cliente";
    private static final String QUERY_ALTERAR = "UPDATE tb_cliente SET nome_cliente = (?), sobrenome_cliente = (?), rg_cliente = (?), cpf_cliente = (?), endereco_cliente = (?), id_conta = (?) WHERE id_cliente = (?)";
    private static final String QUERY_REMOVER = "DELETE FROM tb_cliente WHERE id_cliente = (?)";
    private Connection con = null;

    public ClienteDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ClienteDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Cliente buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ClienteDAO.QUERY_BUSCAR)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    return new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nome_cliente"),
                            rs.getString("sobrenome_cliente"),
                            rs.getString("rg_cliente"),
                            rs.getString("cpf_cliente"),
                            rs.getString("endereco_cliente"),
                            rs.getInt("id_conta")
                    );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando cliente: " + ClienteDAO.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws DAOException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(ClienteDAO.QUERY_BUSCAR_TODOS); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Cliente client = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome_cliente"),
                    rs.getString("sobrenome_cliente"),
                    rs.getString("rg_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getString("endereco_cliente"),
                    rs.getInt("id_conta")
                );
                clientes.add(client);
            }
            return clientes;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os clientes: " + ClienteDAO.QUERY_BUSCAR_TODOS, e);
        }
    }
    
    public List<Cliente> search(String search) throws DAOException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(ClienteDAO.QUERY_SEARCH)) {
            st.setString(1, search);
            st.setString(2, search);
            st.setString(3, search);
            st.setString(4, search);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Cliente client = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("sobrenome_cliente"),
                        rs.getString("rg_cliente"),
                        rs.getString("cpf_cliente"),
                        rs.getString("endereco_cliente"),
                        rs.getInt("id_conta")
                    );
                    clientes.add(client);
                }
            }
            return clientes;
        } catch (SQLException e) {
            throw new DAOException("Erro pesquisando clientes: " + ClienteDAO.QUERY_SEARCH, e);
        }
    }
    
    public Cliente searchByCPFOnly(String cpf) throws DAOException {
        try (PreparedStatement st = this.con.prepareStatement(ClienteDAO.QUERY_SEARCH_CPF_ONLY)) {
            st.setString(1, cpf);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("sobrenome_cliente"),
                        rs.getString("rg_cliente"),
                        rs.getString("cpf_cliente"),
                        rs.getString("endereco_cliente"),
                        rs.getInt("id_conta")
                    );
                }
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro pesquisando cliente pelo cpf: " + ClienteDAO.QUERY_SEARCH_CPF_ONLY, e);
        }
    }

    @Override
    public void inserir(Cliente c) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ClienteDAO.QUERY_INSERIR)) {
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setString(3, c.getRg());
            st.setString(4, c.getCpf());
            st.setString(5, c.getEndereco());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo cliente: " + ClienteDAO.QUERY_INSERIR + "/ " + c.toString(), e);
        }
    }

    @Override
    public void atualizar(Cliente c) throws DAOException {
        System.out.println(c);
        try (PreparedStatement st = con.prepareStatement(ClienteDAO.QUERY_ALTERAR)) {
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setString(3, c.getRg());
            st.setString(4, c.getCpf());
            st.setString(5, c.getEndereco());
            st.setInt(6, c.getConta());
            st.setInt(7, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro atualizando cliente: " + ClienteDAO.QUERY_ALTERAR + "/ " + c.toString(), e);
        }
    }

    @Override
    public void remover(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ClienteDAO.QUERY_REMOVER)) {
            Cliente c = this.buscar(id);
            st.setInt(1, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo cliente: " + ClienteDAO.QUERY_REMOVER + "/ id=" + id, e);
        }
    }
}

