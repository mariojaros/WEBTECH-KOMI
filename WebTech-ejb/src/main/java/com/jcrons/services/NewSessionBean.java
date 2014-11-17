/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcrons.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.Profile;


@Stateless
@LocalBean
public class NewSessionBean {

	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
	public String getAllDigitalContent(){
		return ((Profile) em.createNamedQuery("Profile.findAll").getResultList().get(0)).getFirstName();
	}
}
