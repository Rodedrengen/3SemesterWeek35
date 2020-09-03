/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author simon
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacede(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }

    }

    public List<Customer> findByLastName(String name) {
        List<Customer> results;
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c WHERE c.lastName = \'" + name + "\'", Customer.class);
            results = query.getResultList();
            return results;
        } finally {
            em.close();
        }

    }

    public long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();

        try {
            Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
            long result = (long) q1.getSingleResult();
            return result;
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(String fName, String lName) {
        Customer customer = new Customer(fName, lName);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

}
