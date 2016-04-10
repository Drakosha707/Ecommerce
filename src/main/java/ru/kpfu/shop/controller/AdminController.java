package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;
import ru.kpfu.shop.util.PropertyPath;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String addProduct(Model model) {
        PropertyPath.getPath();
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String newProduct(@ModelAttribute ProductForm productForm) {
        productService.saveProduct(productForm);
        return "redirect:/admin/add-product";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

}
