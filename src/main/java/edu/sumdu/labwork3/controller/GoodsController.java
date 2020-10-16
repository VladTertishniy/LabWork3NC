package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.dao.impl.DaoGoodsTypeIml;
import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.model.Supplier;
import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;
    final static Logger logger = Logger.getLogger(GoodsController.class);

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping()
    public String showAllGoods() {
        return "goods";
    }

    @RequestMapping("/create")
    public String createGoodsType() {
//        User user = new User();
//        user.setUser_id(1);
//        user.setUsername("123");
//        user.setPassword("123");
//        Supplier supplier = new Supplier();
//        supplier.setUser(user);
//        supplier.setPhoneNumber("12345");
//        supplier.setOrganization("dgasga");
//        supplier.setEmail("lalala@gmail.com");
//        supplier.setFirstname("Ivan");
//        supplier.setLastname("Ivanovich");
//        GoodsType goodsType = new GoodsType();
//        goodsType.setVendorCode("23141");
//        goodsType.setName("La la la tales");
//        goodsType.setParent_id(5);
//        goodsType.setId(5);
//        Goods goods = new Goods(1, "Fairy tales", 5.5f, goodsType, supplier);
//        goodsService.insert(goods);
        goodsService.getById(1);
        goodsService.getAll();
        return "goods";
    }
}
