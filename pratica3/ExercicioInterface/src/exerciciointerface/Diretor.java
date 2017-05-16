package exerciciointerface;

public class Diretor extends Funcionario implements IAutenticavel {

    private String psw;
    
    public Diretor ( String nome, int registro, double salario, String senha){
    this.setNome(nome);
    this.setRegistro(registro);
    this.setSalarioBase(salario);
    this.psw = senha;        
    }

    public boolean alterarSenha(String senhaNova, String senhaAntiga) {
        boolean retorno = false;

        if (this.autenticar(this.psw)) {
            this.psw = senhaNova;
            retorno = true;
        }
        return retorno;

    }

    public boolean darAumento(Funcionario f, String senha, double aumento) {

        boolean retorno = false;

        if (this.autenticar(senha)) {
            f.setSalarioBase(f.getSalarioBase() + aumento);
            retorno = true;
            System.out.println("Aumento realizado.");
        } else {
            System.out.println("Senha incorreta, não foi possível realizar o aumento.");
        }
        return retorno;
    }

    @Override
    public boolean autenticar(String senha) {

        return this.psw.equals(senha);       //se for igual já retorna true!
    }

}
