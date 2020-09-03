/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.CustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 *
 * @author simon
 */
public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacede(emf);

        facade.addCustomer("John", "larsen");
        facade.addCustomer("Per", "Hansen");
        facade.addCustomer("Klas", "Jensne");
        facade.addCustomer("Mikkel", "Mikkelsen");
        
        long id = 1;
        
        System.out.println(facade.findByID(id));
        System.out.println(facade.getNumberOfCustomers());
        
        List<Customer> liste = facade.findByLastName("larsen");
        
        for (Customer customer : liste) {
            System.out.println(customer);
        }
        
        System.out.println("-------------");
        
        liste = facade.allCustomers();
        
        for (Customer customer : liste) {
            System.out.println(customer);
        }
    }
}
