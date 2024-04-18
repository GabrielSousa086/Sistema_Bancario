package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        // Loop para permitir que o usuário crie vários clientes
        while (true) {
            System.out.println("Deseja adicionar um novo cliente? (s/n)");
            String resposta = scanner.nextLine().trim().toLowerCase();
            
            if (!resposta.equals("s")) {
                break; // Sai do loop se a resposta não for 's'
            }

            System.out.println("Digite o nome do cliente:");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF do cliente:");
            String cpf = scanner.nextLine();

            // Crie a conta bancária aqui (conta corrente, poupança, etc.)
            // Você pode solicitar informações adicionais, como saldo inicial, dependendo do tipo de conta.
            System.out.println("Escolha o tipo de conta (1 - Conta Corrente, 2 - Conta Poupança):");
            int tipoConta = Integer.parseInt(scanner.nextLine());

            ContaBancaria conta;
            if (tipoConta == 1) {
                System.out.println("Digite o saldo inicial da conta corrente:");
                double saldoInicial = Double.parseDouble(scanner.nextLine());
                System.out.println("Digite o limite do cheque especial:");
                double limiteChequeEspecial = Double.parseDouble(scanner.nextLine());
                conta = new ContaCorrente("", saldoInicial, limiteChequeEspecial);
            } else if (tipoConta == 2) {
                System.out.println("Digite o saldo inicial da conta poupança:");
                double saldoInicial = Double.parseDouble(scanner.nextLine());
                System.out.println("Digite a taxa de rendimento da poupança:");
                double taxaRendimento = Double.parseDouble(scanner.nextLine());
                conta = new ContaPoupanca("", saldoInicial, taxaRendimento);
            } else {
                System.out.println("Tipo de conta inválido. Criando conta corrente por padrão.");
                conta = new ContaCorrente("", 0, 0);
            }

            // Crie o cliente com as informações fornecidas
            Cliente cliente = new Cliente(nome, cpf, conta);

            // Adicione o cliente ao banco
            banco.adicionarCliente(cliente);
        }

        scanner.close();

        // Exemplo de utilização do banco após a criação dos clientes:
        System.out.println("Clientes no banco:");
        for (Cliente cliente : banco.getClientes()) {
            System.out.println(cliente);
        }
    }
}
