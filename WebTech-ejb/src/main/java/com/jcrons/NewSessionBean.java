/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcrons;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class NewSessionBean {

	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
    public String businessMethod() {
    	APP_TABLE1 appTable = em.find(APP_TABLE1.class, new Long(0));
    	
    	return appTable.getContent()+createMe();
    }
    
    public String createMe(){
    	Majko majko = new Majko();
    	majko.setName("Mario Jaros");
    	majko.setId(new Long(50));
    	em.persist(majko);
    	return majko.getName();
    }

    

}
