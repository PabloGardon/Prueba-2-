/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.mascota;

import dominio.usuario.Usuario;

/**
 *
 * @author pablo
 */
public class Mascota {
    
    private int id;
    private String apodo;
    private String Raza;
    private Usuario usuario;

    public Mascota() {
    }

    public Mascota(int id, String apodo, String Raza, Usuario usuario) {
        this.id = id;
        this.apodo = apodo;
        this.Raza = Raza;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
