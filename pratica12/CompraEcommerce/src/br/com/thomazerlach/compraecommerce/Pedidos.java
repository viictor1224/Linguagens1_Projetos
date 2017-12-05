/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.compraecommerce;

/**
 *
 * @author thomazerlach
 */
public class Pedidos {
    private int id;
    private String data;
    private double total;
    private String status;

    public Pedidos() {
    }

    public Pedidos(int id, String data, double total, String status) {
        this.id = id;
        this.data = data;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
