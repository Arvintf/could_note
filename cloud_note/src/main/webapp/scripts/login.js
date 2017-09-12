function checkLogin(){
	// 获取用户名和密码
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	// 设置信息为空
	$("#name_msg").html("");
	$("#password_msg").html("");
	// 判断用户名或密码是否为空
	var flag = true;
	if (name == "") {
		flag = false;
		$("#name_msg").html("用户名不能为空");
	}
	if (password == "") {
		flag = false;
		$("#password_msg").html("密码不能为空");
	}
	if (true) {// 用户名和密码检测通过后，发送登录请求
		$.ajax({
			type : "post",
			data : {
				"name" : name,
				"password" : password
			},
			url : path + "/user/login.do",
			dataType : "json",
			success : function(result) {
				// result是服务器返回的数据
				if (result.status == 0) {
					// 将用户信息保存到cookie中
					var userId = result.data.cn_user_id;
					addCookie("userId", userId, 2);
					window.location.href = path + "/edit.html";

				} else if (result.status == 1) {
					$("#name_msg").html(result.msg);
				} else {
					$("#password_msg").html(result.msg);
				}
			},
			error : function() {
				alert("登录失败！");
			}
		});
	}
};
