package com.kafutong.wuhankft;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.kafutong.wuhankft.filter.SysPathFilter;

/**
 * (config raw Filter)
 * @author freshJuice
 *
 */
@Configuration
public class ConfigFilter {
	
	/**
	 * spring  CharacterEncodingFilter encoding 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Filter> characterFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
		CharacterEncodingFilter characterFilter = new CharacterEncodingFilter();
		characterFilter.setEncoding("UTF-8");
		characterFilter.setForceEncoding(true);
		filterRegistrationBean.setFilter(characterFilter);
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
	
	@Value("${com.kafutong.ip:#{null}}")
	private String sysIp;
	@Value("${com.kafutong.ip.address:#{null}}")
	private String sysDomain;
	@Value("${server.port}")
	private String port;
	@Value("${static.exclusions}")
	private String exclusions;
	/**
	 * sys path set to request filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Filter> sysPathFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
		SysPathFilter sysPathFilter = new SysPathFilter();
		filterRegistrationBean.setFilter(sysPathFilter);
		filterRegistrationBean.addInitParameter("sysProtocol", "http");
		filterRegistrationBean.addInitParameter("sysIp", sysIp);
		filterRegistrationBean.addInitParameter("sysDomain", sysDomain);
		filterRegistrationBean.addInitParameter("sysPort", sysDomain);
		filterRegistrationBean.addInitParameter("exclusions", exclusions);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
