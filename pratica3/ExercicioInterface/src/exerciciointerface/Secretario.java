package exerciciointerface;

public class Secretario extends Funcionario implements IExibicao {

    public Secretario(String nome, int registro, double salario) {
        this.setNome(nome);
        this.setRegistro(registro);
        this.setSalarioBase(salario);
    }

    public boolean atenderTelefone(boolean ocupado) {
        return !ocupado;            // se não tiver ocupado, atende o telefone       

    }

    @Override
    public void exibirResumo() {
        System.out.println("Resumo");
    }

}
