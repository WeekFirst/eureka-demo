package top.mca.eurekaproviderproduct.service.impl;

import org.springframework.stereotype.Service;
import top.mca.eurekaproviderproduct.pojo.Product;
import top.mca.eurekaproviderproduct.service.ProductService;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"华为手机", 2 , 5999D),
                new Product(2,"苹果手机", 1 , 8999D),
                new Product(3,"三星手机", 3 , 7999D),
                new Product(4,"小米手机", 7 , 3999D)
        );
    }
}
