/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pablo
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void eliminar(Autor objeto) {
        super.eliminar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Autor objeto) {
        super.editar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Autor objeto) {
        super.guardar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    public Autor buscarAutorPorID(long id) {
        try {
            conectar();
            Autor autor = em.find(Autor.class, id);
            return autor;

        } catch (Exception e) {
            System.out.println("No se ha encontrado el ID");
            throw e;
        } finally {
            desconectar();
        }
    }

    public List<Autor> buscarAutores() {
        conectar();
        try {
            TypedQuery<Autor> autores = em.createQuery("SELECT a FROM Autores a", Autor.class);
            return autores.getResultList();
        } catch (Exception e) {
            System.out.println("No se encontraron autores");
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarPermanentementePorID(Long id) {
        conectar();
        try {
            Autor autor = em.find(Autor.class, id);
            em.getTransaction().begin();
            if (autor != null) {
                em.remove(autor);
                em.getTransaction().commit();
            } else {
                System.out.println("No se encontró autor con id proporcionada.");
            }

        } catch (Exception e) {
        }
    }

}
