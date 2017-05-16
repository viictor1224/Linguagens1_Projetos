package exerciciointerface;

public class Cliente implements IAutenticavel, IImprimivel {

    private String psw;
    private String cpf;
    private String nome;

    public Cliente(String nome, String cpf, String senha) {

        this.psw = senha;
        this.cpf = cpf;
        this.nome = nome;
    }

    public boolean alterarSenha(String senhaNova, String senhaAntiga) {
        boolean retorno = false;

        if (this.autenticar(this.psw)) {
            this.psw = senhaNova;
            retorno = true;
        }
        return retorno;

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeNovo) {
        this.nome = nomeNovo;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpfNovo) {
        this.cpf = cpfNovo;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.psw.equals(senha);
    }

    @Override
    public void exibirResumo() {
        System.out.println("Resumo");
    }

    @Override
    public void imprimirResumo() {
        System.out.println("Enviando: ");
        this.exibirResumo();
        System.out.println("para impressora.");
    }

}
