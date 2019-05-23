package com.szu.labmanagementsystem.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public String listGoods() {
        return "";
    }

}
