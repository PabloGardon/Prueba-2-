/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Editorial;
import Entidades.Libro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author pablo
 */
public class LibroDAO extends DAO<Libro>{

    @Override
    protected void eliminar(Libro objeto) {
        super.eliminar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void editar(Libro objeto) {
        super.editar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void guardar(Libro objeto) {
        super.guardar(objeto); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Libro buscarLibroPorID(Long id){
        conectar();
        try {
            Libro libro = em.find(Libro.class, id);
            return libro;
            
        } catch (Exception e) {
            System.out.println("Error al buscar libro por id");
            throw e;
        }
    }
    
    public List<Libro> buscarLibros(){
        conectar();
        try {
            TypedQuery<Libro> libros = em.createQuery("SELECT a FROM Libro u", Libro.class);
            return libros.getResultList();
            
        } catch (Exception e) {
            System.out.println("Error al buscar libros");
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public List<Libro> buscarLibrosPorEditorial(Editorial editorial){
        conectar();
        try {
            TypedQuery<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial = : editorial", Libro.class);
            libros.setParameter("editorial", editorial);
            return libros.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscando libros por editorial");
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public void eliminarPorID(Long id){
        conectar();
        try {
            Libro libro = em.find(Libro.class, id);
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error eliminando");
            throw e;
        } finally {
            desconectar();
        }
    }
    
    
    public List<Libro> buscarLibroPorTitulo(String titulo){
        conectar();
        try {
            List<Libro> libro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE : titulo", Libro.class).setParameter("titulo", titulo).getResultList();
            return libro;
        } catch (Exception e) {
            System.out.println("Error buscando título");
            throw e;
        } finally {
            desconectar();
        }
    }
    
    
}
