package com.maboxuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JumpController {

    @RequestMapping(value = "testupload", method = RequestMethod.GET)
    public String testUpload() {
        return "Index";
    }
}
