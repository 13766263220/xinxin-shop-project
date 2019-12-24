package config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.SimpleDateFormat;
import java.util.List;

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

//    /**
//     * 配置拦截器
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistry = registry.addInterceptor(new LoginInterceptor());
//        interceptorRegistry.addPathPatterns("/home/**");
//    }


    /**
     *  消息转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); i++) {
            HttpMessageConverter<?> messageConverter = converters.get(i);
            if(messageConverter instanceof MappingJackson2HttpMessageConverter){
                converters.remove(i); //先把原来的消息jackson消息转换器删除
            }
        }
        converters.add(mappingJackson2HttpMessageConverter());//再添加一个新的
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        //new 一个jackson消息转换器
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置转换的日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mappingJackson2HttpMessageConverter;

    }

    /**
     * 全局配置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST")
                .maxAge(3600);
    }
}
