package com.ocreatech.pms.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.basic.ResponseStatus;
import com.ocreatech.pms.utils.PathMatchUtil;

import lombok.extern.slf4j.Slf4j;


@Component
@WebFilter(urlPatterns="/")
@Slf4j
public class WebSecurityFilter implements Filter{
	
	private List<String> excludeUri = Arrays.asList("/user/login");
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		log.info("filter-request-url---"+req.getRequestURI());
		// 跨域处理
		cossDomain(resp);
		// 不需要登陆的路径直接返回
		if(PathMatchUtil.matchStart(excludeUri,req.getRequestURI())) {
			chain.doFilter(request, response);
			return;
		}
		// 是否登陆
		if(!hasLogin(req)) {
			permissionDeny(resp);
			return;
		}
		chain.doFilter(request, response);
	}


	private void permissionDeny(HttpServletResponse resp) {
		resp.setCharacterEncoding(RequestCommonEunm.ENCODING_UTF8.key());
		resp.setContentType(RequestCommonEunm.CONTENT_TYPE_JSON.key());
		try {
			resp.getWriter().write(JSON.toJSONString(ResponseDataVO.fail(ResponseStatus.UNAUTHORIZED)));
		} catch (IOException e) {
			log.error("WebSecurityFilter HttpServletResponse write error:",e);
		}
	}


	private boolean hasLogin(HttpServletRequest req) {
		String token = req.getHeader(RequestCommonEunm.ACCESS_TOKEN.key());
		return token != null && req.getSession().getAttribute(token) != null;
	}


	private void cossDomain(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Access-Token, Content-Type");
        resp.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
	}

}
