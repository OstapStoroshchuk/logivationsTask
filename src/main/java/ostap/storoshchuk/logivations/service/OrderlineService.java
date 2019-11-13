package ostap.storoshchuk.logivations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ostap.storoshchuk.logivations.entity.Orderline;
import ostap.storoshchuk.logivations.repository.OrderlineRepository;

import java.util.List;

@Service
public class OrderlineService {

    @Autowired
    private OrderlineRepository orderlineRepository;

    public void create(Orderline orderline) {
        orderlineRepository.save(orderline);
    }

    public List<Orderline> findAll() {
        return orderlineRepository.findAll();
    }
}
