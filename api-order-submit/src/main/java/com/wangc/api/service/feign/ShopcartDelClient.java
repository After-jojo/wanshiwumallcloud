package com.wangc.api.service.feign;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.fallback.ShopcartDelClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shopcart-del", fallback = ShopcartDelClientFallback.class)
public interface ShopcartDelClient {

    @DeleteMapping("/shopcart/del")
    int delete(@RequestParam("cids") String cids);

}
