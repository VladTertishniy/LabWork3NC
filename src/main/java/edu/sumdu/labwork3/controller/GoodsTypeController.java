package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
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

    private final IAuthenticationFacade authenticationFacade;
    private final GoodsTypeService goodsTypeService;
    final static Logger logger = Logger.getLogger(GoodsTypeService.class);

    public GoodsTypeController(IAuthenticationFacade authenticationFacade, GoodsTypeService goodsTypeService) {
        this.authenticationFacade = authenticationFacade;
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllGoodsTypes() {
        logger.info("Request to receive all goods types by " + authenticationFacade.getAuthentication().getName());
        List<GoodsType> goodsTypeList = goodsTypeService.getAll();
        return new ModelAndView("goodsTypesPages/goodsType", "goodsTypeList", goodsTypeList);
    }

    @RequestMapping(value="/editGoodsType/{id}", method = RequestMethod.GET)
    public String editGoodsType(@PathVariable int id, Model model){
        logger.info("Request to edit goods type with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        GoodsType goodsType = goodsTypeService.getById(id);
        model.addAttribute("command", goodsType);
        return "goodsTypesPages/editGoodsType";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") GoodsType goodsType){
        logger.info("Request to save altered goods type: " + goodsType.toString() + " by " + authenticationFacade.getAuthentication().getName());
        goodsTypeService.update(goodsType);
        return "redirect:/goodsType";
    }

    @RequestMapping(value="/deleteGoodsType/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        logger.info("Request to delete goods type with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        goodsTypeService.delete(id);
        return "redirect:/goodsType";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGoodsType(@ModelAttribute("command") GoodsType goodsType) {
        logger.info("Request to save created goods type: " + goodsType.toString() + " by " + authenticationFacade.getAuthentication().getName());
        goodsTypeService.insert(goodsType);
        return "redirect:/goodsType";
    }

    @GetMapping(value = "addGoodsType")
    public String addGoodsType(Model model) {
        logger.info("Request to create new goods type by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new GoodsType());
        return "goodsTypesPages/addGoodsType";
    }
}
