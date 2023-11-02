/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Editorial;
import javax.persistence.TypedQuery;

/**
 *
 * @author pablo
 */
public class EditorialDAO extends DAO<Editorial>{

    @Override
    protected void eliminar(Editorial objeto) {
        super.eliminar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void editar(Editorial objeto) {
        super.editar(objeto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void guardar(Editorial objeto) {
        super.guardar(objeto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Editorial buscarEditorialPorID(int id){
        conectar();
        try {
            Editorial editorial = em.find(Editorial.class, id);
            return editorial;
            
        } catch (Exception e) {
            System.out.println("Error al buscar id");
            throw e;
            
        } finally {
            desconectar();
        }
    }
    
    public void eliminarpermanentementePorID(int id){
        conectar();
        try {
           Editorial editorial = em.find(Editorial.class, id);
           em.getTransaction().begin();
           em.remove(editorial);
           em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar por id");
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre){
        conectar();
        try {
            TypedQuery<Editorial> editoriales = em.createQuery("SELECT a FROM Autores a WHERE a.nombre = : nombre", Editorial.class);
            editoriales.setParameter("nombre", nombre);
            return editoriales.getSingleResult();
            
        } catch (Exception e) {
            System.out.println("No se encontraron autores");
            throw e;
        } finally {
            desconectar();
        }
    }
}
