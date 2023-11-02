/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final AutorDAO DAO = new AutorDAO();

    public void crearAutor() {
        try {
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre");
            autor.setNombre(leer.next());
            autor.setAlta(true);

            DAO.guardar(autor);
            System.out.println("Se creó el autor");
        } catch (Exception e) {
            throw e;
        }
    }

}
