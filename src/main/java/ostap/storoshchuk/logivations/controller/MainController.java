package ostap.storoshchuk.logivations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ostap.storoshchuk.logivations.entity.Case;
import ostap.storoshchuk.logivations.entity.Orderline;
import ostap.storoshchuk.logivations.entity.Product;
import ostap.storoshchuk.logivations.exeption.WrongInputDataException;
import ostap.storoshchuk.logivations.repository.OrderlineRepository;
import ostap.storoshchuk.logivations.service.CaseService;
import ostap.storoshchuk.logivations.service.OrderlineService;
import ostap.storoshchuk.logivations.service.ProductService;

import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    private CaseService caseService;
    @Autowired
    private OrderlineService orderlineService;
    @Autowired
    private ProductService productService;


    @PostMapping("/saveOrderline")
    public String saveOrderline(@RequestParam Integer numberOfProducts,
                                @RequestParam Integer productId)
            throws WrongInputDataException {
        Orderline orderline = new Orderline();
        orderline.setNumberOfProducts(numberOfProducts);
        orderline.setProduct(productService.findById(productId));
        orderlineService.create(orderline);
        return "redirect:/main";
    }

    @PostMapping("/saveCase")
    public String saveCase(Case c) {
        System.out.println(c);
        caseService.create(c);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("cases", caseService.findAll());
        model.addAttribute("orders", orderlineService.findAll());
        return "main";
    }

    @GetMapping("/")
    public String some() {
        System.out.println(caseService.theBestOrderline(Arrays.asList(
                new Case(1d, 2d, 2d),
                new Case(2d, 22d, 2d),
                new Case(2.5, 2d, 2d),
                new Case(3d, 1d, 10d)),
                Arrays.asList(
                        new Orderline(4, new Product(2d, 2d, 2d)),
                        new Orderline(1, new Product(2d, 2d, 2d)))));
        return "index";
    }
}
