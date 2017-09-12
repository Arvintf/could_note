package com.cap.cloud_note.aspect;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceException {
	@AfterThrowing(throwing = "e", pointcut = "within(com.cap.cloud_note.service..*)") // 指定异常对象
	public void traceException(Exception e) throws Exception {
		// 将异常信息输入文件
		try {
			FileWriter fw = new FileWriter("D:\\note_exception.log", true);
			PrintWriter pw = new PrintWriter(fw);
			// 将异常信息写入文件
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String excetionDate = sdf.format(date);
			pw.println("*********************************************************");
			pw.println("*异常类型：" + e);
			pw.println("*异常时间：" + excetionDate);
			pw.println("***********************异常详细信息**************************");
			e.printStackTrace(pw);
			pw.close();
			fw.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
