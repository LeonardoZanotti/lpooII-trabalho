/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import lpooii_work.database.ConnectionFactory;
import lpooii_work.database.DAOException;
import lpooii_work.models.Cliente;
import lpooii_work.models.dao.ClienteDAO;
import lpooii_work.models.dao.ContaDAO;

/**
 *
 * @author leonardozanotti
 */
public class ClienteController {

    public static List<Cliente> buscarTodos() throws DAOException, IOException, SQLException {
        List<Cliente> clientes;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ClienteDAO dao = new ClienteDAO(con);
            clientes = dao.buscarTodos();
        }
        return clientes;
    }
    
    public static Cliente buscar(int id) throws DAOException, IOException, SQLException {
        Cliente cliente;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ClienteDAO dao = new ClienteDAO(con);
            cliente = dao.buscar(id);
        }
        return cliente;
    }

    public static void inserir(Cliente c) throws DAOException, IOException, SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ClienteDAO dao = new ClienteDAO(con);
            if (!ClienteController.validCPF(c.getCpf())) throw new DAOException("CPF inválido.");
            if (clientAlreadyExists(c)) throw new DAOException("Já existe cliente com este nome ou cpf.");
            dao.inserir(c);
        }
    }

    public static void atualizar(Cliente c) throws DAOException, IOException, SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            if (!ClienteController.validCPF(c.getCpf())) throw new DAOException("CPF inválido.");
            if (clientAlreadyExists(c)) throw new DAOException("Já existe cliente com este nome ou cpf.");
            ClienteDAO dao = new ClienteDAO(con);
            dao.atualizar(c);
        }
    }

    public static void remover(Cliente c) throws DAOException, IOException, SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ClienteDAO clienteDao = new ClienteDAO(con);
            clienteDao.remover(c.getId());
            
        }
    }
    
    private static boolean clientAlreadyExists(Cliente c) throws DAOException, IOException, SQLException {
        List<Cliente> clients = ClienteController.buscarTodos();
        return clients.stream().anyMatch(client -> client.getId() != c.getId() && (client.getNome().equals(c.getNome()) || client.getCpf().equals(c.getCpf())));
    }

    private static boolean validCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

}
