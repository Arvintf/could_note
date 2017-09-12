package com.cap.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
	@Around("within(com.cap.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) throws Throwable {
		Object obj = null;
		try {
			
			long beforeTime = System.currentTimeMillis();
			obj = point.proceed();
			long afterTime = System.currentTimeMillis();
			System.out.println(point.getSignature().toString()+"运行时间:"+(afterTime-beforeTime));
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return obj;
	}
}
