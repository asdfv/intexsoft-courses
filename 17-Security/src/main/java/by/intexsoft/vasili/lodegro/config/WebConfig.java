package by.intexsoft.vasili.lodegro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web config
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "by.intexsoft.vasili.lodegro.controller",
        "by.intexsoft.vasili.lodegro.security.controller"
})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
