package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.shop.service.BucketService;

@Controller
@RequestMapping(value = "/bucket")
public class BucketController {

    @Autowired
    BucketService bucketService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestParam Long id) {
        bucketService.addProduct(id);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@RequestParam Long id) {
        bucketService.deleteProduct(id);
    }

    @RequestMapping(value = "/changeNumberProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeNumberProduct(@RequestParam("product_id") Long id, @RequestParam("number") Integer number) {
        bucketService.changeNumberProduct(id, number);
    }


}
