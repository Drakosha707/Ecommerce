package ru.kpfu.shop.controller;

import org.apache.poi.ss.formula.functions.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;


@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProductsPage(@RequestParam(name = "category", required = false) Long categoryId,
                                  Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        if (categoryId == null) {
            model.addAttribute("products", productRepository.findAll());
        } else {
            model.addAttribute("products", productService.findByCategoryId(categoryId));
        }
        return "products";
    }

    @RequestMapping(value = "/products/detail", method = RequestMethod.GET)
    public String detailProduct(@RequestParam("id") Long productId, Model model) {
        model.addAttribute("product", productRepository.findOne(productId));
        return "shop-item";
    }
}
