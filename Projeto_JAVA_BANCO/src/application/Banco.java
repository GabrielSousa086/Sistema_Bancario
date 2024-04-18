package application;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public double consultarSaldoTotal() {
        double saldoTotal = 0.0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getConta().getSaldo();
        }
        return saldoTotal;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    public boolean removerClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clientes.remove(cliente);
                return true; // Cliente removido com sucesso
            }
        }
        return false; // Cliente não encontrado
    }
}

