package com.wangc.shopcart.service;

import com.wangc.shopcart.dao.ShopCartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class ShopCartDelService {
    @Resource
    private ShopCartMapper shopCartMapper;
    public int deleteShop(String cids) {
        int res = 1;
        String[] split = cids.split(",");
        for (int i = 0; i < split.length; i++) {
            int i1 = shopCartMapper.deleteByPrimaryKey(Integer.parseInt(split[i]));
            res *= i1;
        }
        return res;
    }
}
