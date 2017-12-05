/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celular;

import java.util.ArrayList;

/**
 *
 * @author thomazerlach
 */
public class ListaDeContatos {
    
     private final ArrayList<Contato> lista = new ArrayList<>();
    
    public void AddNaLista(String nome, String numero) {
        Contato contato = new Contato(nome, numero);
        this.lista.add(contato);
    }
    
    public void Remover(String item) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getNome().equalsIgnoreCase(item)) {
                this.lista.remove(i);
            }
        }
    }

    public ArrayList<Contato> getLista() {
        return this.lista;
    }
}
