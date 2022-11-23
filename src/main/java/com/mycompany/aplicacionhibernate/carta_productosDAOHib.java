/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.util.List;
import models.carta_productos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class carta_productosDAOHib implements carta_productosDAO {

 

    

    @Override
    public carta_productos get(Integer id) {
       Session s = HibernateUtil.getSessionFactory().openSession();
            return s.get(carta_productos.class,id);            
        }
    

    @Override
    public List<carta_productos> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        var q = s.createQuery("from carta_productos");
            return q.list();
        }

    }
    

