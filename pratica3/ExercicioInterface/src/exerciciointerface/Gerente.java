package exerciciointerface;

public class Gerente extends Funcionario implements IAutenticavel {

    public boolean autenticar(double senha) {
        return true;
    }

}
