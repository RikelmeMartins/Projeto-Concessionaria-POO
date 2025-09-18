public class Venda {

    public Veiculo veiculo;
    public Cliente cliente;
    public String dataVenda;
    public double valorVenda;
    public String formaPagamento;

    public Venda(Veiculo veiculo, Cliente cliente, String dataVenda, double valorVenda, String formaPagamento){

        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;

    }

    @Override
    public String toString() {
        return String.format(
                "<Venda: veiculo=%s,\n cliente=%s,\n dataVenda=%s, valorVenda=%.2f, formaPagamento=%s>",
                this.veiculo, this.cliente, this.dataVenda, this.valorVenda, this.formaPagamento
        );
    }
}
