/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import point.Point;

/**
 *
 * @author simon
 */
public class PointFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public PointFacade(){
        
    }
    
    public List<Point> allPoints() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Point> query
                    = em.createQuery("Select p from Point p", Point.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
