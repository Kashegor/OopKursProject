package com.websystique.springsecurity.controller;

import com.websystique.springsecurity.model.Equipment;
import com.websystique.springsecurity.service.EquipmentService;
import com.websystique.springsecurity.service.OrderService;
import com.websystique.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private UserService userService;

    @Resource
    @Qualifier("orderService")
    private OrderService orderService;


    @RequestMapping(value = "mangas", method = RequestMethod.GET)
    public String listEquipment(Model model) {
        model.addAttribute("manga", new Equipment());
        model.addAttribute("listMangas", equipmentService.listEquipment());

        return "mangas";
    }

    @RequestMapping(value = "/mangas/add", method = RequestMethod.POST)
    public String addEquipment(@ModelAttribute("manga") Equipment equipment) {
        if (equipment.getId() == 0) {
            equipmentService.add(equipment);
        } else {
            equipmentService.update(equipment);
        }
        return "redirect:/mangas";
    }

    @RequestMapping("/remove/{id}")
    public String removeEquipment(@PathVariable("id") int id) {
        equipmentService.remove(id);

        return "redirect:/mangas";
    }

    @RequestMapping("edit/{id}")
    public String editEquipment(@PathVariable("id") int id, Model model) {
        model.addAttribute("manga", equipmentService.getById(id));
        model.addAttribute("listMangas", equipmentService.listEquipment());

        return "mangas";
    }

    @RequestMapping("mangadata/{id}")
    public String EquipmentData(@PathVariable("id") int id, Model model) {
        model.addAttribute("manga", this.equipmentService.getById(id));

        return "mangadata";
    }

    @RequestMapping(value = "bucket", method = RequestMethod.GET)
    public String bucketEquipment(Model model) {
        List list = new ArrayList();
        list.addAll(userService.getBucket(getPrincipal()));
        model.addAttribute("listMangas", list);
        model.addAttribute("allListMangas", equipmentService.listEquipment());

        return "bucket";
    }

    @RequestMapping("/addB/{id}")
    public String addInBucket(@PathVariable("id") int id, Model model) {

        orderService.addOrder(userService.findBySso(getPrincipal()).getId(), id);

        return "redirect:/bucket";
    }
    @RequestMapping("/removeB/{id}")
    public String removeInBucket(@PathVariable("id") int id, Model model) {

        orderService.deleteOrderByUser(userService.findBySso(getPrincipal()).getId(), id);

        return "redirect:/bucket";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
