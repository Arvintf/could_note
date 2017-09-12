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
	@AfterThrowing(throwing = "e", pointcut = "within(com.cap.cloud_note.service..*)") // ָ���쳣����
	public void traceException(Exception e) throws Exception {
		// ���쳣��Ϣ�����ļ�
		try {
			FileWriter fw = new FileWriter("D:\\note_exception.log", true);
			PrintWriter pw = new PrintWriter(fw);
			// ���쳣��Ϣд���ļ�
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String excetionDate = sdf.format(date);
			pw.println("*********************************************************");
			pw.println("*�쳣���ͣ�" + e);
			pw.println("*�쳣ʱ�䣺" + excetionDate);
			pw.println("***********************�쳣��ϸ��Ϣ**************************");
			e.printStackTrace(pw);
			pw.close();
			fw.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
