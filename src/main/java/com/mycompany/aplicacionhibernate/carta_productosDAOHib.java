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

/**
 *
 * @author FranciscoRomeroGuill
 */
public class carta_productosDAOHib implements carta_productosDAO {

    @Override
    public void save(carta_productos u) {
       Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.save(u);
            t.commit();
        }
    

    @Override
    public void update(carta_productos u) {
       Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.update(u);
            t.commit();
        }
    

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
    

