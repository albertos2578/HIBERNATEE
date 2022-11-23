
package models;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

/**
 *
 * @author FranciscoRomeroGuill
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="pedidos")
public class pedidos implements Serializable {

    public pedidos() {
        hora = new Time(System.currentTimeMillis());
    }
    
    @Id
   @GeneratedValue(strategy=IDENTITY)
     @Column(name="id_pedido")
     private Integer id_pedido;
    
    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name="producto_id", referencedColumnName = "carta_id")
    private carta_productos producto_id;
   
    
    @Column(name="cliente")
    private String cliente;
    
    @Column(name="estado")
    private String estado;

        @Column(name="fecha")
    private LocalDate fecha;
    
     @Column(name="hora")
    private Time hora;

    @Override
    public String toString() {
        return "pedidos{" + "id_pedido=" + id_pedido + ", producto_id=" + producto_id + ", cliente=" + cliente + ", estado=" + estado + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

  
     
     

    

     
    
}
