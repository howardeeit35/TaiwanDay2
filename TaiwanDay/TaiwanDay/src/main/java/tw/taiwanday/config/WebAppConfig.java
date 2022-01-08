package tw.taiwanday.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//相當於mvc-servlet.xml
@Configuration//成為配置類
@EnableWebMvc//Spring MVC註解
@ComponentScan(basePackages = {"tw.taiwanday"})
public class WebAppConfig implements WebMvcConfigurer {
	
	//定義靜態資源的路徑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}
	
	//輸入/即可導向membersmain.controller
	//輸入/sweethome即可導向form.jsp
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "membersmain.controller");
		registry.addViewController("/sweethome").setViewName("form");
	}


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver ViewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		//去找"WEB-INF/pages/"裡面找有.jsp的檔案
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
//		上三行等於下一行
//		InternalResourceViewResolver vr = new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
		vr.setOrder(6);//萬一找不到檔案會浪費記憶體資源，所以設低優先
		return vr;
	}
	
	

}
