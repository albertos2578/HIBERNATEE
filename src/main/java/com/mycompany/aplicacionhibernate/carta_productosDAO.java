/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.util.List;
import models.carta_productos;


public interface carta_productosDAO {
  
    public carta_productos get( Integer id);
 
    public List<carta_productos> getAll();
}
