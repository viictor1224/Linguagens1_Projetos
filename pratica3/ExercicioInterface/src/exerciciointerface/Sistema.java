package exerciciointerface;

public class Sistema {

    public boolean login( IAutenticavel objeto , String senhaDeAcesso) {
        
        return objeto.autenticar(senhaDeAcesso);
        
        
        
    }

}
