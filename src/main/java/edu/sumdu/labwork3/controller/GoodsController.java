package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
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

    private final IAuthenticationFacade authenticationFacade;
    private final GoodsService goodsService;
    final static Logger logger = Logger.getLogger(GoodsController.class);

    public GoodsController(IAuthenticationFacade authenticationFacade, GoodsService goodsService) {
        this.authenticationFacade = authenticationFacade;
        this.goodsService = goodsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllGoods() {
        logger.info("Request to receive all goods by " + authenticationFacade.getAuthentication().getName());
        List<Goods> goodsList = goodsService.getAll();
        return new ModelAndView("goodsPages/goods", "goodsList", goodsList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGoods(@ModelAttribute("command") Goods goods) {
        logger.info("Request to save created goods: " + goods.toString() + " by " + authenticationFacade.getAuthentication().getName());
        goodsService.insert(goods);
        return "redirect:/goods";
    }

    @GetMapping(value = "addGoods")
    public String addGoods(Model model) {
        logger.info("Request to create new goods by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new Goods());
        return "goodsPages/addGoods";
    }

    @RequestMapping(value="/deleteGoods/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        logger.info("Request to delete goods with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        goodsService.delete(id);
        return "redirect:/goods";
    }

    @RequestMapping(value="/editGoods/{id}", method = RequestMethod.GET)
    public String editGoods(@PathVariable int id, Model model){
        logger.info("Request to edit goods with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        Goods goods = goodsService.getById(id);
        model.addAttribute("command", goods);
        return "goodsPages/editGoods";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Goods goods){
        logger.info("Request to save altered goods: " + goods.toString() + " by " + authenticationFacade.getAuthentication().getName());
        goodsService.update(goods);
        return "redirect:/goods";
    }
}
