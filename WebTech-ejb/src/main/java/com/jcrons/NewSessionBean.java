/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcrons;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class NewSessionBean {

	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
    public List<String> businessMethod() {
    	APP_TABLE1 appTable = em.find(APP_TABLE1.class, new Long(0));
    	List<Majko> majkos = (List<Majko>) em.createQuery("SELECT e FROM Majko e").getResultList();
    	
    	
    	return createMe(majkos);
    }
    
    public List<String> createMe(List<Majko> majkos){
    	List<String> stringName = new ArrayList<>();
		for (Majko majko : majkos){
    		stringName.add(majko.getName());
    	}
		return stringName;
    }

    

}
