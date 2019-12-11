package config;


import com.nf.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.nf.controller","com.nf.exception"})
@EnableWebMvc
@Import(ServiceConfig.class)
public class MvcConfig implements WebMvcConfigurer {

//    @Bean
//    public StandardServletMultipartResolver multipartResolver(){
//        StandardServletMultipartResolver standardServletMultipartResolver =  new StandardServletMultipartResolver();
//        return standardServletMultipartResolver;
//    }

    /**
     * 添加转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistry.addPathPatterns("/home/**");
    }


    
}
