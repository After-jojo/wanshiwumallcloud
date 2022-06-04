package com.wangc.order.feign;
import com.wangc.fmmall.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author After拂晓
 */

@FeignClient("order-querybyid")
public interface OrderQueryByIdClient {

    @GetMapping("/order/query/{oid}")
    Orders query(@PathVariable("oid") String oid);


}
