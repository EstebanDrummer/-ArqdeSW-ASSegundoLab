/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejb.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bean.entidad.Productos;

/**
 *
 * @author yepesk8r
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {
    @PersistenceContext(unitName = "ASSegundoLab-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
}
