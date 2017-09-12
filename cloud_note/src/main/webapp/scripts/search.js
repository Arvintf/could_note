function searchNote(event){
	var content = $("#search_note").val();
	if (event.keyCode == 13){
		page=1;
		loadPageShare(content,page);
	}
}
function moreSearchShare(){
	var content = $("#search_note").val().trim();
	page = page+1;
	loadPageShare(content,page);
}
function loadPageShare(content,page){
	$.ajax({
		type:"post",
		dateType:"json",
		data:{"content":content,"page":page},
		url:path+"/share/search.do",
		success:function(result){
			var shares = result.data;
				for (var i =0;i<shares.length;i++){
					//获取shareId
					var shareId = shares[i].cn_share_id;
					//获取shareTitle
					var shareTitle = shares[i].cn_share_title;
					//获取li对象
					var li = '<li class="online">';
					 li+="<a>";
					 li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
					 li+=shareTitle;
					 li+='</a>';
					 li+='</li>';
					 var $li = $(li);
					//绑定shareId
					 $li.data("shareId",shareId);
					 //
					 $("#search_url").append($li);
					 //隐藏全部笔记区域
					 $("#pc_part_2").hide();
					 //显示搜索区 
					 $("#pc_part_6").show(); 
				}
		},
		error:function(){
			alert("搜索失败");
		}
	});
}