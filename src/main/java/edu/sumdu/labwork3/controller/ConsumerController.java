package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {

    private final IAuthenticationFacade authenticationFacade;
    private final ConsumerService consumerService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public ConsumerController(IAuthenticationFacade authenticationFacade, ConsumerService consumerService) {
        this.authenticationFacade = authenticationFacade;
        this.consumerService = consumerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllConsumers() {
        logger.info("Request to receive all consumers by " + authenticationFacade.getAuthentication().getName());
        List<Consumer> consumersList = consumerService.getAll();
        return new ModelAndView("consumersPages/consumers", "consumersList", consumersList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createConsumer(@ModelAttribute("command") Consumer consumer) {
        logger.info("Request to save created consumer: " + consumer.toString() + " by " + authenticationFacade.getAuthentication().getName());
        consumerService.insert(consumer);
        return "redirect:/consumers";
    }

    @GetMapping(value = "addConsumer")
    public String addConsumer(Model model) {
        logger.info("Request to create new consumer by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new Consumer());
        return "consumersPages/addConsumer";
    }

    @RequestMapping(value="/deleteConsumer/{user_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        logger.info("Request to delete consumer with userId: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        consumerService.delete(user_id);
        return "redirect:/consumers";
    }

    @RequestMapping(value="/editConsumer/{user_id}", method = RequestMethod.GET)
    public String editConsumer(@PathVariable int user_id, Model model){
        logger.info("Request to edit consumer with userId: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        Consumer consumer = consumerService.getById(user_id);
        model.addAttribute("command", consumer);
        return "consumersPages/editConsumer";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Consumer consumer){
        logger.info("Request to save altered consumer: " + consumer.toString() + " by " + authenticationFacade.getAuthentication().getName());
        consumerService.update(consumer);
        return "redirect:/goods";
    }
}
