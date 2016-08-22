package app.controller;

import app.domain.Leaf;
import app.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by smparadeza on 6/12/15.
 */
@Controller
public class LeafController {
    @Autowired
    private MainService mainService;


    @RequestMapping(method = RequestMethod.GET, value = "/test",
            produces = "application/json")
    public @ResponseBody String test() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/label_data")
    public ModelAndView labelData(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("label_data");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/leaf/get_unlabeled",
            produces = "application/json")
    public ModelAndView getUnlabeledLeaf(){
        Leaf leaf = mainService.getUnlabeledLeaf();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewer");
        modelAndView.addObject("leaf", leaf);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/leaf/get_unlabeled/{leafId}",
            produces = "application/json")
    public ModelAndView getUnlabeledLeafById(@PathVariable String leafId){
        Leaf leaf = mainService.getLeafById(Long.parseLong(leafId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewer");
        modelAndView.addObject("leaf", leaf);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/leaf/get_next",
            consumes = "application/json")
    public ModelAndView getNextLeaf(@RequestBody Map<String, String> jsonBody) {
        Long leafId = Long.parseLong(jsonBody.get("leafId").toString());
        Leaf leaf =  mainService.getNextLeaf(mainService.getLeafById(new Long(leafId)));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewer");
        modelAndView.addObject("leaf", leaf);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/leaf/get_previous",
            consumes = "application/json")
    public ModelAndView getPreviousLeaf(@RequestBody Map<String, Object> jsonBody) {
        Long leafId = Long.parseLong(jsonBody.get("leafId").toString());
        Leaf leaf = mainService.getPreviousLeaf(mainService.getLeafById(new Long(leafId)));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewer");
        modelAndView.addObject("leaf", leaf);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/leaf/mark_as_compound",
            produces = "application/json", consumes = "application/json")
    public @ResponseBody Boolean markAsCompound(@RequestBody Map<String, Object> jsonBody){
        Long leafId = Long.parseLong(jsonBody.get("leafId").toString());
        Leaf leaf = mainService.getLeafById(new Long(leafId));
        leaf = mainService.markAsCompound(leaf);
        if(leaf.getIsCompound()) return true;
        return false;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/leaf/mark_as_simple",
            produces = "application/json", consumes = "application/json")
    public @ResponseBody Boolean markAsSimple(@RequestBody Map<String, Object> jsonBody){
        Long leafId = Long.parseLong(jsonBody.get("leafId").toString());
        Leaf leaf = mainService.getLeafById(new Long(leafId));
        leaf = mainService.markAsSimple(leaf);
        if(!leaf.getIsCompound()) return true;
        return false;
    }


    @RequestMapping(method = RequestMethod.GET, value = "leaf/compound", produces = "application/json")
    public ModelAndView getCompoundLeaves(){
        List<String> names = mainService.getCompoundLeavesNames();
        List<Integer> imgCounts = new ArrayList<>();
        Long ave = new Long(0);
        for(String s : names){
            imgCounts.add(mainService.getCompoundLeafImages(s).size());
            ave += imgCounts.get(imgCounts.size()-1);
        }
        Long total = ave;
        ave = ave/imgCounts.size();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("compound");
        modelAndView.addObject("totalImages", total);
        modelAndView.addObject("average", ave);
        modelAndView.addObject("leaves", names);
        modelAndView.addObject("imgCounts", imgCounts);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/leaf/compound/images",
             consumes = "application/json")
    public ModelAndView getLeafImages(@RequestBody Map<String, Object> jsonBody){
        String leafName = jsonBody.get("leafName").toString();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("leaf-images");
        modelAndView.addObject("images", mainService.getCompoundLeafImages(leafName));
        return modelAndView;
    }




    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public void handleConstraintException() {

    }
}
