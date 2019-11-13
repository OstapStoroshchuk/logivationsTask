package ostap.storoshchuk.logivations.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double sizeX;
    private Double sizeY;
    private Double sizeZ;
 //   private String productName;
    @OneToMany(mappedBy = "product")
    private List<Orderline> orderlines = new ArrayList<>();

    public Product() {
    }

    public Product(Double sizeX, Double sizeY, Double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Double square(){
        return sizeX*sizeY;
    }

    public  Double volume(){
        return sizeX*sizeY*sizeZ;
    }
}
