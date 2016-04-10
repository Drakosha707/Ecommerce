package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String newProduct(@ModelAttribute ProductForm productForm) {
        productService.saveProduct(productForm);
        return "redirect:/admin/add-product";
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public String addCategory(Model model) {
        return "add-category";
    }
    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public String saveCategory(@RequestParam String name, Model model) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "add-category";
    }
}
