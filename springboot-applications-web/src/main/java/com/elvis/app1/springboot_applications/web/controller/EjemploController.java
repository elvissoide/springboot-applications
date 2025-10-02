package com.elvis.app1.springboot_applications.web.controller;

import com.elvis.app1.springboot_applications.core.dto.InfoDto;
import com.elvis.app1.springboot_applications.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EjemploController {

    @Autowired
    private InfoService infoService;

    @GetMapping("path")
    public String obtenerInfo(Model model) {
        InfoDto info = infoService.obtenerInformacion();
        model.addAttribute("info", info);
        return "detalles_info";
    }

    @GetMapping("/api/info")
    @ResponseBody
    public InfoDto obtenerInfoJson() {
        return infoService.obtenerInformacion();
    }
}