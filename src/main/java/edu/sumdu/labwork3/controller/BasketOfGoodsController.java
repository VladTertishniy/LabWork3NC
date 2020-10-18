package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.service.BasketOfGoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basketOfGoods")
public class BasketOfGoodsController {

    private final BasketOfGoodsService basketOfGoodsService;
    final static Logger logger = Logger.getLogger(BasketOfGoodsController.class);

    public BasketOfGoodsController(BasketOfGoodsService basketOfGoodsService) {
        this.basketOfGoodsService = basketOfGoodsService;
    }

    @RequestMapping()
    public String showAllBasketsOfGoods() {
        basketOfGoodsService.findAll();
        return "basketsOfGoods";
    }
}
