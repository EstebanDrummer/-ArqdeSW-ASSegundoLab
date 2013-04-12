/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejb.bean;

import java.util.List;
import javax.ejb.Local;
import org.bean.entidad.Productos;

/**
 *
 * @author yepesk8r
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);

    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
}
