package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;
    final static Logger logger = Logger.getLogger(GoodsController.class);

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllGoods() {
        List<Goods> goodsList = goodsService.getAll();
        return new ModelAndView("goodsPages/goods", "goodsList", goodsList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGoodsType(@ModelAttribute("command") Goods goods) {
        goodsService.insert(goods);
        return "redirect:/goods";
    }

    @GetMapping(value = "addGoods")
    public String addGoodsType(Model model) {
        model.addAttribute("command", new Goods());
        return "goodsPages/addGoods";
    }

    @RequestMapping(value="/deleteGoods/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        goodsService.delete(id);
        return "redirect:/goods";
    }

    @RequestMapping(value="/editGoods/{id}", method = RequestMethod.GET)
    public String editGoodsType(@PathVariable int id, Model model){
        Goods goods = goodsService.getById(id);
        model.addAttribute("command", goods);
        return "goodsPages/editGoods";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Goods goods){
        goodsService.update(goods);
        return "redirect:/goods";
    }
}
