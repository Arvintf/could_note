package com.cap.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.cloud_note.dao.UserDao;
import com.cap.cloud_note.entity.User;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(String name, String password) {
		// ���ս������
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		// �û���������
		if (user == null) {
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		String user_password = user.getCn_user_password();
		String md5Password = NoteUtil.md5(password);
		// �ж������Ƿ���ȷ
		if (!user_password.equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		// �û��������붼��ȷʱ�����÷��ؽ��
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}

	public NoteResult<User> register(String name, String password, String nickname) {
		NoteResult result = new NoteResult();
		User isExistUser = userDao.findByName(name);
		if(isExistUser!=null) {
			result.setStatus(1);
			result.setMsg("�û����Ѵ���");
			return result;
		}
		String id = NoteUtil.createId();
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_desc(nickname);
		user.setCn_user_id(id);
		userDao.save(user);
		result.setMsg("ע��ɹ�");
		result.setStatus(0);
		return result;
	}
}
