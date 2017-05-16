package exerciciointerface;

public class ExercicioInterface {

    public static void main(String[] args) {

        Secretario secretario = new Secretario("Sec", 1, 5200);

        Gerente gerente = new Gerente("Ger", 2, 9000, "minha senha é oi");

        Diretor diretor = new Diretor("Dir", 3, 18000, "minha senha é oi");

        Cliente cliente = new Cliente("Cli", "555.555.555-55", "minha senha é oi");
        cliente.imprimirResumo();
        
        Sistema sistema = new Sistema();
        
        
        String senhaTentativaAcessoSistema = "5555";
        if ( sistema.login( cliente ,senhaTentativaAcessoSistema )){
            
            
            //Acesso ao sistema
            System.out.println("acessou");
            
        }
        
        
        
    }

}
