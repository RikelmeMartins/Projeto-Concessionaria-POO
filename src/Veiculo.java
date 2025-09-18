public class Veiculo {

    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;

    public Veiculo(String marca, String modelo, String placa, int ano, double preco){

        this.disponivel = true;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;

    }

    public void mudarDisponibilidade (boolean disponivel){

        this.disponivel = disponivel;

    }

    @Override
    public String toString() {
        return String.format(
                "<Veiculo: marca=%s,\n modelo=%s,\n placa=%s,\n ano=%d,\n disponivel=%b,\n preço=%.2f>",
                this.marca, this.modelo, this.placa, this.ano, this.disponivel, this.preco
        );
    }
}
