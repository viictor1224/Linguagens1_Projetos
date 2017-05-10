package exerciciointerface;

public class Diretor extends Funcionario implements IAutenticavel {

    public boolean autenticar(double senha) {
        return true;
    }

}
