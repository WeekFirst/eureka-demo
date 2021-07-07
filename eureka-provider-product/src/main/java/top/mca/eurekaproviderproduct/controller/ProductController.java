package top.mca.eurekaproviderproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mca.eurekaproviderproduct.pojo.Product;
import top.mca.eurekaproviderproduct.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public List<Product> selectProductList(){
        return productService.selectProductList();
    }
}
