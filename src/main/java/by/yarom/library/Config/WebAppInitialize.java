package by.yarom.library.Config;


import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

@Order(1)
public class WebAppInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                WebConfig.class, SecurityConfig.class
        };
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();
        utf8Filter.setEncoding("UTF-8");
        utf8Filter.setForceEncoding(true);

        return new Filter[] { utf8Filter };
    }

    //add file
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        10485760, 10485760, 10485760/2);

        registration.setMultipartConfig(multipartConfigElement);

    }

}
