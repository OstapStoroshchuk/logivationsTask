package ostap.storoshchuk.logivations.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "orderline")
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numberOfProducts;

    @ManyToOne
    private Product product;

    public Orderline() {
    }

    public Orderline(Integer numberOfProducts, Product product) {
        this.numberOfProducts = numberOfProducts;
        this.product = product;
    }
}
