package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
import edu.sumdu.labwork3.model.BasketOfGoods;
import edu.sumdu.labwork3.service.BasketOfGoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/basketOfGoods")
public class BasketOfGoodsController {

    private final IAuthenticationFacade authenticationFacade;
    private final BasketOfGoodsService basketOfGoodsService;
    final static Logger logger = Logger.getLogger(BasketOfGoodsController.class);

    public BasketOfGoodsController(IAuthenticationFacade authenticationFacade, BasketOfGoodsService basketOfGoodsService) {
        this.authenticationFacade = authenticationFacade;
        this.basketOfGoodsService = basketOfGoodsService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        logger.info("Request to receive all basketOfGoods by " + authenticationFacade.getAuthentication().getName());
        List<BasketOfGoods> basketOfGoodsList = basketOfGoodsService.findAll();
        return new ModelAndView("basketOfGoodsPages/basketsOfGoods", "basketOfGoodsList", basketOfGoodsList);
    }

    @GetMapping(value = "addBasketOfGoods")
    public String addBasketOfGoods(Model model) {
        logger.info("Request to add new basketOfGoods");
        model.addAttribute("command", new BasketOfGoods());
        return "basketOfGoodsPages/addBasketOfGoods";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String insert(@ModelAttribute("command") BasketOfGoods basketOfGoods) {
        logger.info("Request to save created basketOfGoods: " + basketOfGoods.toString() + " by " + authenticationFacade.getAuthentication().getName());
        basketOfGoodsService.insert(basketOfGoods);
        return "redirect:/index.jsp";
    }

    @RequestMapping(value="/deleteBasketOfGoods/{goods_id}/{order_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int goods_id, @PathVariable int order_id){
        logger.info("Request to delete basketOfGoods by goods_id: " + goods_id + ", order_id: " + order_id + " by " + authenticationFacade.getAuthentication().getName());
        basketOfGoodsService.delete(order_id, goods_id);
        return "redirect:/basketOfGoods";
    }

    @RequestMapping(value="/editBasketOfGoods/{goods_id}/{order_id}", method = RequestMethod.GET)
    public String edit(@PathVariable int goods_id, @PathVariable int order_id, Model model){
        logger.info("Request to edit basketOfGoods by goods_id: " + goods_id + ", order_id: " + order_id + " by " + authenticationFacade.getAuthentication().getName());
        BasketOfGoods basketOfGoods = basketOfGoodsService.getByOrderAndGoodsId(order_id, goods_id);
        model.addAttribute("command", basketOfGoods);
        return "basketOfGoodsPages/editBasketOfGoods";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") BasketOfGoods basketOfGoods){
        logger.info("Request to save altered basketOfGoods: " + basketOfGoods.toString() + " by " + authenticationFacade.getAuthentication().getName());
        basketOfGoodsService.update(basketOfGoods);
        return "redirect:/basketOfGoods";
    }
}
