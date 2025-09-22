import java.util.ArrayList;

public class Concessionaria {

    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public Concessionaria (String nome){

        this.nome = nome;

    }

    public boolean adicionarVeiculo(Veiculo veiculo){

        for (int i = 0; i < totalVeiculos; i++){
            if(this.veiculos.get(i).placa.equals(veiculo.placa)){
                return false;
            }
        }

        boolean veiculoInserido = this.veiculos.add(veiculo);

        if (veiculoInserido){
            this.totalVeiculos++;
        }

        return veiculoInserido;

    }

    public boolean removerVeiculo(String placa){

        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(placa)){
                this.veiculos.remove(i);
                this.totalVeiculos--;
                return true;
            }
        }

        return false;

    }

    public ArrayList<Veiculo> buscarVeiculoPorMarca(String marca){

        ArrayList<Veiculo> bucarVeiculo = new ArrayList<>();

        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).marca.toLowerCase().contains(marca.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(i);
                bucarVeiculo.add(veiculo);
            }
        }

        return bucarVeiculo;

    }

    public ArrayList<Veiculo> buscarVeiculoPorModelo(String modelo){

        ArrayList<Veiculo> bucarVeiculo = new ArrayList<>();

        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).modelo.toLowerCase().contains(modelo.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(i);
                bucarVeiculo.add(veiculo);
            }
        }

        return bucarVeiculo;

    }

    public boolean cadastrarCliente (Cliente cliente){

        for (int i = 0; i < totalClientes; i++){
            if (this.clientes.get(i).id == cliente.id){
                return false;
            }
        }

        boolean ClinteCadastrado = this.clientes.add(cliente);

        if(ClinteCadastrado){
            this.totalClientes++;
        }

        return ClinteCadastrado;

    }

    public boolean removerCLiente (int id){

        for (int i = 0; i < totalClientes; i++){
            if (this.clientes.get(i).id == id){
                this.clientes.remove(i);
                this.totalClientes--;
                return true;
            }
        }

        return false;

    }

    public boolean realizarVenda(String placa, int idCliente, String dataVenda, String formaPagamento, double valor){

        Cliente cliente = null;

        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).id == idCliente){
                cliente = this.clientes.get(i);
                break;
            }
        }

        Veiculo veiculo;

        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(placa)){
                veiculo = this.veiculos.get(i);
                if (!veiculo.disponivel){
                    return false;
                }
                Venda venda = new Venda(veiculo, cliente, dataVenda, valor, formaPagamento);
                boolean vendaConcluida = this.vendas.add(venda);
                if (vendaConcluida){
                    this.totalVendas++;
                    this.totalVeiculos--;
                    veiculo.mudarDisponibilidade(veiculo.disponivel=false);
                    return vendaConcluida;
                }
            }
        }

        return false;

    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis(){

        ArrayList<Veiculo> veiculosDisponiveis = new ArrayList<>();

        for (int i = 0; i < totalVeiculos; i++){
            if(this.veiculos.get(i).disponivel){
                Veiculo veiculo = this.veiculos.get(i);
                veiculosDisponiveis.add(veiculo);
            }
        }

        return veiculosDisponiveis;

    }

    public ArrayList<Venda> listarVendasRealizadas(){

        return this.vendas;

    }

    @Override
    public String toString() {
        return String.format(
                "<Concessionaria: nome=%s, totalVeiculos=%d, totalCliente=%d, totalVendas=%d>",
                this.nome, this.totalVeiculos, this.totalClientes, this.totalVendas
        );
    }
}
