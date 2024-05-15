package com.karolkosinski.test_web_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("name",System.getProperty("os.name"));
        model.addAttribute("version",System.getProperty("os.version"));
        model.addAttribute("arch", System.getProperty("os.arch"));
        model.addAttribute("jv",System.getProperty("java.version"));
        try{
            InetAddress localhost = InetAddress.getLocalHost();

            String ipAddress = localhost.getHostAddress();
            model.addAttribute("ip", ipAddress);

        }catch (Exception e){
            model.addAttribute("ip", "nan");
        }
        return "index";
    }
}
