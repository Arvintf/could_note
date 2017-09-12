function register(){
			//获取数据
			var name = $("#regist_username").val().trim();
			var nickname = $("#nickname").val().trim(); 
			var password = $("#regist_password").val().trim();
			var final_password = $("#final_password").val().trim();
			var flag =true;
			$("#warning_11 span").html("");
			//检查数据
			if(name==""){
				$("#warning_11 span").html("用户名不能为空");
				$("#warning_11").show();
				flag =false;
			}
			//密码校验
			if(password==""){
				$("#warning_2 span").html("密码不能为空");
				$("#warning_2").show();
				flag =false;
			}else if(password>0&&password.length<6){
				$("#warning_2 span").html("密码不能小于六位");
				$("#warning_2").show();
				flag =false;
			}
			if(final_password!=password){
				$("#warning_3 span").html("输入密码不一致");
				$("#warning_3").show();
				flag =false;
			}
			if(flag){
				$.ajax({
					type:"post",
					url:path+"/user/add.do",
					dataType:"json",
					data:{"name":name,"password":password,"nickname":nickname},
					success:function(result){
						if(result.status==0){
							alert(result.msg);
							$("#back").click();
						}else if (result.status==1){
							$("#warning_11 span").html(result.msg);
							$("#warning_11").show();
						}
					},
					error:function(){
						alert("注册失败");
					}
				});
			}
		}