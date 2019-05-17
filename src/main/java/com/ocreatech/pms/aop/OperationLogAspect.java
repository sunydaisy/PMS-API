package com.ocreatech.pms.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.ocreatech.pms.annotation.OperationLog;
import com.ocreatech.pms.config.RequestCommonEunm;
import com.ocreatech.pms.mapper.OperationLogMapper;
import com.ocreatech.pms.model.TbOperationLog;
import com.ocreatech.pms.model.TbUser;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class OperationLogAspect {

	@Autowired
	private HttpServletRequest req;
	@Autowired
	private OperationLogMapper mapper;

	/**
	 * 定义一个切点
	 */
	@Pointcut("@annotation(com.ocreatech.pms.annotation.OperationLog)")
	public void logPointCut() {

	}

	@AfterReturning(returning = "responseDate", pointcut = "logPointCut()")
	public void logAspectAround(JoinPoint joinPoint, Object responseDate) {
		// 获取签名
		Signature signature = joinPoint.getSignature();
		if (!(signature instanceof MethodSignature)) {
			return;
		}
		try {
			TbOperationLog operationLog = new TbOperationLog();
			// 操作方法
			String operationMethod = signature.getDeclaringTypeName() + ":" + signature.getName();
			operationLog.setOperationMethod(operationMethod);
			// 操作请求参数,请求参数可能为空
			Object[] args = joinPoint.getArgs();
			if(args.length>0 && args[0] != null) {
				operationLog.setOperationRequst(String.valueOf(args[0]));
			}
			// 操作返回参数
			String operationResponse = String.valueOf(responseDate);
			operationLog.setOperationResponse(operationResponse);
			// 操作时间
			operationLog.setOperationTime(LocalDateTime.now());
			// 操作路径
			operationLog.setOperationUrl(String.valueOf(req.getRequestURL()));
			// 操作用户
			String token = req.getHeader(RequestCommonEunm.ACCESS_TOKEN.key());
			TbUser user = (TbUser) req.getSession().getAttribute(token);
			operationLog.setOperationUser(user.getUserName());
			// 操作名称，获取Method可以优化
			Class<?>[] parameterTypes = ((MethodSignature) signature).getMethod().getParameterTypes();
			Method method = joinPoint.getTarget().getClass().getMethod(signature.getName(), parameterTypes);
			OperationLog oL = method.getDeclaredAnnotation(OperationLog.class);
			operationLog.setOperationName(oL.name());
			mapper.insert(operationLog);
		} catch (Exception e) {
			log.error("调用方法" + signature.getDeclaringTypeName() + ":" + signature.getName() + "记录操作日志异常", e);
		}
	}
}
