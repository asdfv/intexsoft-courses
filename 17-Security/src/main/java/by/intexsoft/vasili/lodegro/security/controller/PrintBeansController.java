package by.intexsoft.vasili.lodegro.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/print")
public class PrintBeansController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping
    public List<String> printBeans() {
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }
}
