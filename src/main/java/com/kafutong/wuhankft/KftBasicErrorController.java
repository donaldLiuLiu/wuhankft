package com.kafutong.wuhankft;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KftBasicErrorController extends BasicErrorController {

	public KftBasicErrorController() {
		super(new DefaultErrorAttributes(), new ErrorProperties());
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", false);
        map.put("msg", body.get("message"));
        return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	@Override
	public ModelAndView errorHtml(HttpServletRequest request,
			HttpServletResponse response) {
		HttpStatus status = getStatus(request);
        //response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        return(modelAndView == null ? new ModelAndView("error", model) : modelAndView);
	}
	
	
}
