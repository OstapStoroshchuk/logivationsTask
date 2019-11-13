package ostap.storoshchuk.logivations.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double sizeX;
    private Double sizeY;
    private Double sizeZ;

    public Case() {
    }

    public Case(Double sizeX, Double sizeY, Double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Double square() {
        return sizeX * sizeY;
    }

    public Double volume() {
        return sizeX * sizeY * sizeZ;
    }

    public Integer canContain(Product product) {
        if (product.getSizeX() > this.sizeX ||
                product.getSizeY() > this.sizeY ||
                product.getSizeZ() > this.sizeZ) {
            return 0;
        } else if (product.getSizeX() == this.sizeX &&
                product.getSizeY() == this.sizeY &&
                product.getSizeZ() == this.sizeZ) {
            return 1;
        } else {
            int count = 1;
            int temp;
            if (this.sizeX / product.getSizeX() >= 2) {
                temp = (int) (this.sizeX / product.getSizeX());
                count *= temp;
            }
            if ((this.sizeY / product.getSizeY() >= 2)) {
                temp = (int) (this.sizeY / product.getSizeY());
                count *= temp;
            }
            if ((this.sizeZ / product.getSizeZ() >= 2)) {
                temp = (int) (this.sizeZ / product.getSizeZ());
                count *= temp;
            }
            return count;
        }
    }

    public Double freeSpaceInPercent(Orderline orderline) {
        double free = 0;
        if (canContain(orderline.getProduct()) >= 1) {
            free = ((this.volume() - orderline.getProduct().volume() * orderline.getNumberOfProducts())
                    / this.volume()) * 100;
        } else {
            return 100d;
        }
        return free;
    }


}
