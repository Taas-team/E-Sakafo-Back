package mg.esakafo.taas.model;

import java.io.Serializable;

import javax.persistence.Entity;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "dish")
public class Dish implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;

    @ManyToOne
    @JoinColumn(name="category", referencedColumnName="id")
    private Category category;
    private Long orderNumber;
    private Long quantity;


    public Dish(String name, Float price, Category category, Long quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
}