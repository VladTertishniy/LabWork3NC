package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsRestApiController {
    private final GoodsService goodsService;
    final static Logger logger = Logger.getLogger(GoodsTypeRestApiController.class);

    public GoodsRestApiController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<Goods> getAllGoods() {
        return goodsService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Goods getByGoodsId(@PathVariable int id) {
        return goodsService.getById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Goods createGoods(@RequestBody Goods goods) {
        return goodsService.insert(goods);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Goods updateGoods(@RequestBody Goods goods) {
        return goodsService.update(goods);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void removeGoods(@PathVariable int id) {
        goodsService.delete(id);
    }
}
