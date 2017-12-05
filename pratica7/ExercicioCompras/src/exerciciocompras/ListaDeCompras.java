/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocompras;

import java.util.ArrayList;

/**
 *
 * @author thomazerlach
 */
public class ListaDeCompras {

    private final ArrayList<Compra> lista = new ArrayList<>();
    
    public void AddNaLista(String item) {
        Compra compra = new Compra(item);
        this.lista.add(compra);
        int indiceAtual = this.lista.indexOf(compra);
        compra.setIndice(indiceAtual);
        this.lista.set(indiceAtual, compra);
    }
    
    public void Modificar(String nvItem, int itemIndice) {
        Compra compra = new Compra(nvItem, itemIndice);
        this.lista.set(itemIndice, compra);
    }
    
    public void Remover(String item) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getItem().equalsIgnoreCase(item)) {
                this.lista.remove(i);
            }
        }
        for (int i = 0; i < this.lista.size(); i++) {
            Compra compra = this.lista.get(i);
            compra.setIndice(i);
            this.lista.set(i, compra);
        }
    }

    public ArrayList<Compra> getLista() {
        return this.lista;
    }
    
}
