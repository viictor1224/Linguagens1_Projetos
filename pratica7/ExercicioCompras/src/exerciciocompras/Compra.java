/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocompras;

/**
 *
 * @author thomazerlach
 */
public class Compra {
    
    private String Item;
    private int indice;

    public Compra() {
    }

    public Compra(String Item) {
        this.Item = Item;
    }

    public Compra(String Item, int indice) {
        this.Item = Item;
        this.indice = indice;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getItem() {
        return Item;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }
 
}
