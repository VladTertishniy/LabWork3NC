package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.service.GoodsTypeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    private final GoodsTypeService goodsTypeService;
    final static Logger logger = Logger.getLogger(GoodsTypeService.class);

    public GoodsTypeController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllGoodsTypes() {
        List<GoodsType> goodsTypeList = goodsTypeService.getAll();
        return new ModelAndView("goodsTypesPages/goodsType", "goodsTypeList", goodsTypeList);
//        return "goodsType";
    }

    @RequestMapping(value="/editGoodsType/{id}", method = RequestMethod.GET)
    public String editGoodsType(@PathVariable int id, Model model){
        GoodsType goodsType = goodsTypeService.getById(id);
        model.addAttribute("command", goodsType);
        logger.info(goodsType.toString() + " before edit");
        return "goodsTypesPages/editGoodsType";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") GoodsType goodsType){
        logger.info(goodsType.toString() + " after edit");
        goodsTypeService.update(goodsType);
        return "redirect:/goodsType";
    }

    @RequestMapping(value="/deleteGoodsType/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        goodsTypeService.delete(id);
        return "redirect:/goodsType";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGoodsType(@ModelAttribute("command") GoodsType goodsType) {
        goodsTypeService.insert(goodsType);
        return "redirect:/goodsType";
    }

    @GetMapping(value = "addGoodsType")
    public String addGoodsType(Model model) {
        model.addAttribute("command", new GoodsType());
        return "goodsTypesPages/addGoodsType";
    }
}
