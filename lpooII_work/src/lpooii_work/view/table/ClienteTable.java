/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpooii_work.view.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import lpooii_work.models.Cliente;

/**
 *
 * @author leonardozanotti
 */
public class ClienteTable extends AbstractTableModel {
    private List<Cliente> clientes = new ArrayList();
    private String[] columns = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Endereço", "Conta"};

    public ClienteTable() {
        
    }
    
    public ClienteTable(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return this.columns[index];
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getRg();
            case 3: return cliente.getCpf();
            case 4: return cliente.getEndereco();
            case 5: return cliente.getConta() != 0 ? (cliente.getConta() == 1 ? "Corrente" : "Investimento") : "Sem conta";
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente cliente = clientes.get(row);
        switch (col) {
            case 0:
                cliente.setNome((String) value);
                break;
            case 1:
                cliente.setSobrenome((String) value);
                break;
            case 2:
                cliente.setRg((String) value);
                break;
            case 3:
                cliente.setCpf((String) value);
                break;
            case 4:
                cliente.setEndereco((String) value);
                break;
            case 5:
                cliente.setConta((int) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeCliente(Cliente cliente) {
        int line = this.clientes.indexOf(cliente);
        boolean result = this.clientes.remove(cliente);
        this.fireTableRowsDeleted(line, line);
        return result;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        this.fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
        Collections.sort(this.clientes);
    }
    
    public void updateCliente(Cliente cliente, String nome, String sobrenome, String rg, String cpf, String endereco) {
        int row = this.clientes.indexOf(cliente);
        this.setValueAt(nome, row, 0);
        this.setValueAt(sobrenome, row, 1);
        this.setValueAt(rg, row, 2);
        this.setValueAt(cpf, row, 3);
        this.setValueAt(endereco, row, 4);
        Collections.sort(this.clientes);
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        this.fireTableDataChanged();
        Collections.sort(this.clientes);
    }

    public void cleanTable() {
        int index = clientes.size()-1;
        if(index < 0)
            index = 0;
        this.clientes = new ArrayList();
        this.fireTableRowsDeleted(0, index);
    }

    public Cliente getCliente(int linha){
        return clientes.get(linha);
    }
    
    public void searchCliente(String search) {
        List<Cliente> filteredClientes = this.clientes.stream()
            .filter(cliente -> cliente.getFullName().contains(search) || cliente.getRg().contains(search) || cliente.getCpf().contains(search))
            .collect(Collectors.toList());
        this.setClientes(filteredClientes);
    }
}
