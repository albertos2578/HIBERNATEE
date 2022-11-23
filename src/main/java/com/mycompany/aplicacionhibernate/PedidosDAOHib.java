/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.pedidos;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class PedidosDAOHib implements PedidosDAO {

    @Override
    public void save(pedidos m) {
        Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.save(m);
            t.commit();
            s.close();
        }
    

    @Override
    public void update(pedidos m) {
       Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.update(m);
            t.commit();
            s.close();
            System.out.println("Pedido actualizado:");
        }
    

    @Override
    public pedidos get(Integer id) {
        pedidos ped = new pedidos();
        Session s = HibernateUtil.getSessionFactory().openSession();
        ped=s.get(pedidos.class, id);
      
    
            return ped;
           
        }
    

    @Override
    public void delete(pedidos m) {
       Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
         System.out.println(m.getId_pedido());
            s.remove(m);
            t.commit();
             s.close();
             System.out.println("Pedido con ID: "+m.getId_pedido()+" borrado con exito");
        }

    @Override
    public List<pedidos> AllPedidos() {
       Session s = HibernateUtil.getSessionFactory().openSession();
    CriteriaBuilder cb = s.getCriteriaBuilder();
    CriteriaQuery<pedidos> cq = cb.createQuery(pedidos.class);
    Root<pedidos> rootEntry = cq.from(pedidos.class);
    CriteriaQuery<pedidos> all = cq.select(rootEntry);

    TypedQuery<pedidos> allQuery = s.createQuery(all);
    return allQuery.getResultList();
}

    @Override
    public List<pedidos> PedidosHoy() {
             LocalDate todaysDate = LocalDate.now();
      
           Session s = HibernateUtil.getSessionFactory().openSession();
           s.beginTransaction();
           Criteria criteria = s.createCriteria(pedidos.class);
           criteria.add(Restrictions.eq("fecha", todaysDate));
       List<pedidos> list1= (List<pedidos>) criteria.list();
       s.getTransaction().commit();
       s.close();
     
       
        
    return list1;
}

    }
    
    
    
    
    
    

