package com.hellojd.jpetstore.config;

import com.hellojd.common.web.HeaderVersionArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Configuration
@ComponentScan("com.hellojd.jpetstore.app")
public class WebConfig extends  WebMvcConfigurationSupport  {
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HeaderVersionArgumentResolver());
        argumentResolvers.add(new ServletWebArgumentResolverAdapter(new PageableArgumentResolver()));
    }

    //静态资源Handlers
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/","classpath:META-INF/resources/").setCachePeriod(3600);
    }
    //请求url(spring的url)映射到control的配置
    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping rmhm = super.requestMappingHandlerMapping();
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("locale");
        MappedInterceptor mappedInterceptor = new MappedInterceptor(new String[]{"/**"},interceptor);
        rmhm.setInterceptors(new Object[]{mappedInterceptor});
        return rmhm;
    }


    @Bean(name="viewResolver")
    public InternalResourceViewResolver newInternalResourceViewResolver(){
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setPrefix("/WEB-INF/views/");
        irvr.setSuffix(".jsp");
        irvr.setOrder(2);
        return irvr;

    }

    //配置servlet处理<mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name="localeResolver")
    public CookieLocaleResolver newCookieLocaleResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        return cookieLocaleResolver;
    }
}
