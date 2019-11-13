package ostap.storoshchuk.logivations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ostap.storoshchuk.logivations.entity.Product;
import ostap.storoshchuk.logivations.exeption.WrongInputDataException;
import ostap.storoshchuk.logivations.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) throws WrongInputDataException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new WrongInputDataException("Product with id : " + id + " not found");
    }
}
