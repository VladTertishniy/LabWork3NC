package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.controller.UserController;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.service.GoodsTypeService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goodsType")
public class GoodsTypeRestApiController {
    private final GoodsTypeService goodsTypeService;
    final static Logger logger = Logger.getLogger(GoodsTypeRestApiController.class);

    public GoodsTypeRestApiController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<GoodsType> getAllGoodsType() {
        return goodsTypeService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public GoodsType getByGoodsTypeId(@PathVariable int id) {
        return goodsTypeService.getById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public GoodsType createGoodsType(@RequestBody GoodsType goodsType) {
        return goodsTypeService.insert(goodsType);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public GoodsType updateGoodsType(@RequestBody GoodsType goodsType) {
        return goodsTypeService.update(goodsType);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@RequestBody GoodsType goodsType) {
        goodsTypeService.delete(goodsType.getId());
    }
}
