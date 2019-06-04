package com.kafutong.wuhankft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ConfigWebMvc implements WebMvcConfigurer {
	
	
	/**
	 * 配置thymeleaf视图解析器：鉴于在配置文件中配置无效
	 * @param templateEngine
	 * @return
	 */
	@Bean
	public ITemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		//ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(ContextLoader.getCurrentWebApplicationContext().getServletContext());
	    templateResolver.setPrefix("classpath:/templates/");
	    templateResolver.setCacheable(false);
	    templateResolver.setCharacterEncoding("UTF-8");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode("HTML5");
	    return templateResolver;
	}
	@Bean
	public TemplateEngine templateEngine(ITemplateResolver templateResolver){
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    return templateEngine;
	}
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine);
	    return viewResolver;
	}
		
	
}
