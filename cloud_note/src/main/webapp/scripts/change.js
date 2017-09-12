function checkPassword(){
	var last_password = $("#last_password").val();
	var userId = getCookie("userId");
	var flag = true;
	$.ajax({
		type:"post",
		dataType:"json",
		url:path+"/user/changePassword.do",
		data:{"userId":userId},
		success:function(result){
			
		}
	});
}