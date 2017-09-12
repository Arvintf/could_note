function addShare(){
	var noteId =$("#note-list a.checked").parent().data("noteId");
	$.ajax({
		type:"post",
		dataType:"json",
		url:path +"/share/add.do",
		data:{"noteId":noteId},
		success:function (result){
			if(result.status==0){
				 var noteTitle =$("#note-list a.checked").parent().text(); 
				 //图标处理
				 var li='';
				 li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				 li+=noteTitle;
				 li+='<i class="fa fa-sitemap"></i>';
				 li+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				 $("#note-list a.checked").html(li);
				 alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("分享失败");
		}
	});
}