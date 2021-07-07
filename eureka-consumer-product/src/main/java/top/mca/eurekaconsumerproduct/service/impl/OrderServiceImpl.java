package top.mca.eurekaconsumerproduct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import top.mca.eurekaconsumerproduct.pojo.Order;
import top.mca.eurekaconsumerproduct.pojo.Product;
import top.mca.eurekaconsumerproduct.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //元数据

    @Autowired
    private LoadBalancerClient loadBalancerClient; //Ribbon 负载均衡

    @Override
    public Order selectOrderById(Integer id) {
        return new Order(1 , "order-01" , "china" , 19999D , selectProductListByLoadBalancerClient());
    }

    /**
     * 元数据模式
     * @return
     */
    private List<Product> selectProductListByDiscoverClient() {
        StringBuffer sb = null;

        //获取服务列表
        List<String> serviceIds = discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIds))
            return null;


        //根据服务名称获取服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-provider-product");
        if(CollectionUtils.isEmpty(serviceInstances))
            return null;

        ServiceInstance si = serviceInstances.get(0);
        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return responseEntity.getBody();
    }

    private List<Product> selectProductListByLoadBalancerClient() {
        StringBuffer sb = null;

        ServiceInstance si = loadBalancerClient.choose("SERVICE-PROVIDER-PRODUCT");
        if (si == null) {
            return null;
        }
        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");
        System.out.println(sb.toString());

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return responseEntity.getBody();
    }


}
