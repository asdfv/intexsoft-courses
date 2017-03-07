package by.intexsoft.vasili.userapp.config.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web config
 */
@Configuration
@EnableWebMvc
@ComponentScan("by.intexsoft.vasili.userapp.controller")
public class WebConfig {
}
