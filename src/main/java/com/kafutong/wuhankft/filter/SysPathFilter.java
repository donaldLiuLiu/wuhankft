package com.kafutong.wuhankft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysPathFilter implements Filter {
	private String sysProtocol;
	private String sysPort;
	private String sysIp;
	private String sysDomain;
	private String exclusions;
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		//HttpServletResponse response = (HttpServletResponse) resp;
		request.setAttribute("sysProtocol", sysProtocol);
		request.setAttribute("sysPort", sysPort);
		request.setAttribute("sysIp", sysIp);
		request.setAttribute("sysDomain", sysDomain);
		
		chain.doFilter(req, resp);
		
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		sysProtocol = config.getInitParameter("sysProtocol");
		sysPort = config.getInitParameter("sysPort");
		sysIp = config.getInitParameter("sysIp");
		sysDomain = config.getInitParameter("sysDomain");
		exclusions = config.getInitParameter("sysDomain");
	}
	
}
