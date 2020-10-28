package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.BasketOfGoods;
import edu.sumdu.labwork3.service.BasketOfGoodsService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basketOfGoods")
public class BasketOfGoodsRestApiController {

    private final BasketOfGoodsService basketOfGoodsService;
    final static Logger logger = Logger.getLogger(GoodsTypeRestApiController.class);

    public BasketOfGoodsRestApiController(BasketOfGoodsService basketOfGoodsService) {
        this.basketOfGoodsService = basketOfGoodsService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<BasketOfGoods> getAllBasketOfGoods() {
        return basketOfGoodsService.findAll();
    }

    @RequestMapping(value = "/getByGoodsId/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<BasketOfGoods> getByGoodsId(@PathVariable int id) {
        return basketOfGoodsService.getByGoodsId(id);
    }

    @RequestMapping(value = "/getByOrderId/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<BasketOfGoods> getByOrderId(@PathVariable int id) {
        return basketOfGoodsService.getByOrderId(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public BasketOfGoods createGoods(@RequestBody BasketOfGoods basketOfGoods) {
        return basketOfGoodsService.insert(basketOfGoods);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public BasketOfGoods updateGoods(@RequestBody BasketOfGoods basketOfGoods) {
        return basketOfGoodsService.update(basketOfGoods);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@RequestBody BasketOfGoods basketOfGoods) {
        basketOfGoodsService.delete(basketOfGoods);
    }
}
