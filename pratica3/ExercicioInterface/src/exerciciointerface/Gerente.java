package exerciciointerface;

public class Gerente extends Funcionario implements IAutenticavel {

    public Gerente(String nome, int registro, double salario, String senha) {
        this.setNome(nome);
        this.setRegistro(registro);
        this.setSalarioBase(salario);
        this.psw = senha;
    }

    public String psw;

    public boolean alterarSenha(String senhaNova, String senhaAntiga) {
        boolean retorno = false;

        if (this.autenticar(this.psw)) {
            this.psw = senhaNova;
            retorno = true;
        }
        return retorno;

    }

    @Override
    public boolean autenticar(String senha) {
        return true;
    }

}
