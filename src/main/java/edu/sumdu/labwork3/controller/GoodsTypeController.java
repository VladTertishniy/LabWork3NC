package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.service.GoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    private final GoodsTypeService goodsTypeService;

    public GoodsTypeController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping()
    public String showAllGoodsTypes() {
        return "goodsType";
    }

    @RequestMapping("/create")
    public String createGoodsType() {
//        GoodsType goodsType = new GoodsType(1, null,"Bag", "576");
//        GoodsType goodsType1 = new GoodsType(3, null, "fork", "321");
//        goodsTypeService.update(goodsType1);
//        goodsTypeService.insert(goodsType);
//        goodsTypeService.getAll();
        return "goodsType";
    }
}
