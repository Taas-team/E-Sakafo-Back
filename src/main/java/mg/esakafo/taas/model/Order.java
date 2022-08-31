package mg.esakafo.taas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.esakafo.taas.model.statusOrder.StatusOrder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "\"orders\"")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ref;
    private String category;
    
    @ManyToOne
    @JoinColumn(name="dish", referencedColumnName="id")
    private Dish dish;

    private Long quantity;
    private String clientName;
    private String contact;
    private String address;

    private String orderDate;
    
    @Enumerated(EnumType.STRING)
    private StatusOrder status;


    public Order(Dish dish, Long quantity, String clientName, String contact, String address) {
        this.dish = dish;
        this.quantity = quantity;
        this.clientName = clientName;
        this.contact = contact;
        this.address = address;
    }
}