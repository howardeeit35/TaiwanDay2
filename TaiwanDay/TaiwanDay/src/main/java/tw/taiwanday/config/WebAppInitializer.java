package tw.taiwanday.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//相當於web.xml
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override  //用來設定相當於beans.config.xml的java程式組態
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
//		return null;
	}

	@Override  //用來設定相當於mvc-servlet.xml的java程式組態
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
//		return null;
	}

	@Override  //用來設定ServletMappings url patterns
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter();
		encodeFilter.setEncoding("UTF-8");
		encodeFilter.setForceEncoding(true);
		
		//CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter("UTF-8",true);
		//����
		
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		
		return new Filter[] {encodeFilter,hiddenHttpMethodFilter}; //new摰�隞乩蝙�嚗�撮鞎瑚����
//		return null;
	}
	
	

}
