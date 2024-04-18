package application;

public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, double saldoInicial, double taxaRendimento) {
        super(numeroConta, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double calcularRendimento() {
        return getSaldo() * taxaRendimento;
    }

    @Override
    public void transferir(ContaBancaria contaDestino, double valor) throws SaldoInsuficienteException {
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }
        super.transferir(contaDestino, valor);
    }
}