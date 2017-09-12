//加载对应笔记本的全部笔记
function loadNotes(){
	//设置选中效果
	$(this).siblings('li').find('a').removeClass('checked');
	$(this).find("a").addClass("checked");
	var bookId = $(this).data("bookId");
	$.ajax({
		type:"post",
		dataType:"json",
		url:path+"/note/loadNotes.do",
		data:{"bookId":bookId},
		success:function(result){
			$("#note-list").empty();
			if(result.status==0){
				var notes = result.data;
				for(var i = 0;i<notes.length;i++){
					var noteTitle = notes[i].cn_note_title;
					var noteId = notes[i].cn_note_id;
					createNoteLi(noteId,noteTitle);
				}
			}
		},
		error:function(){
			alert("获取笔记列表失败");
		}
	});
};

function createNoteLi(noteId,noteTitle){
	var li = '<li class="online">';
	 li+="<a>";
	 li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	 li+=noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	 li+='</a>';
	 li+='<div class="note_menu" tabindex="-1">';
	 li+='<dl>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_move"  title="移动至..."><i class="fa fa-random"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" id="share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" id="like" style="background:#f00;color:#000;" title="收藏"><i class="fa fa-star" style="font-size:15px;line-height:10px;"></i></button></dt>	';
	 li+='</dl></div></li>';
	 var $li=$(li);
	 $li.data("noteId",noteId);
	 $("#note-list").append($li);
}
//显示对应点击的note
function showNote(){
	$(this).siblings("li").find("a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var noteId = $(this).data("noteId");
	$.ajax({
		type:"post",
		dataType:"json",
		url:path+"/note/showNote.do",
		data:{"noteId":noteId},
		success:function(result){
			if(result.status==0){
				$("#input_note_title").val(result.data.cn_note_title);
				um.setContent(result.data.cn_note_body);
			}else{
				myalert(result.msg);
			}
		},
		error:function(){
			alert("获取笔记信息失败");
		}
	});
};
//保存笔记
function saveNote(){
	//获取noteId,title,body
	var noteId = $("#note-list a.checked").parent().data("noteId");
	var title = $("#input_note_title").val().trim();
	var body = um.getContent();
	//发送ajax请求
	$.ajax({
		type:"post",
		dataType:"json",
		url:path+"/note/saveNote.do",
		data:{"noteId":noteId,"title":title,"body":body},
		success:function(result){
			if(result.status==0){
				var title = $("#input_note_title").val().trim();
				var sli='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli+=title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				$("#note-list a.checked").html(sli);
				alert("保存笔记信息成功");
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("笔记信息保存失败");
		}
	});
	
}
//创建新的note对话框
function isAddNoteWindow(){
	var $li = $("#notebook-list a.checked").parent();
	if($li.length!=0){
		//新建note的对话框
		addNoteWindow();
	}else{
		alert("请选择笔记本");
	}
}
//绑定创建note事件
function addNote(){
	var $li = $("#notebook-list a.checked").parent();
	var bookId = $li.data("bookId");
	var userId = getCookie("userId");
	var noteTitle = $("#input_note").val().trim();
	if(noteTitle!=''){
		$.ajax({
			type:"post",
			dataType:"json",
			url:path+"/note/addNote.do",
			data:{"userId":userId,"bookId":bookId,"noteTitle":noteTitle},
			success:function(result){
				if(result.status==0){
					createPreNote(result.data.cn_note_id,noteTitle);
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("创建笔记本失败");
			}
		});
	}else{
		alert("请输入笔记名称");
	}
}
function createPreNote(noteId,noteTitle){
	var li = '<li class="online">';
	 li+="<a>";
	 li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	 li+=noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	 li+='</a>';
	 li+='<div class="note_menu" tabindex="-1">';
	 li+='<dl>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_move"  title="移动至..."><i class="fa fa-random"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" id="share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	 li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" id="like" style="background:#f00;color:#000;" title="收藏"><i class="fa fa-star" style="font-size:15px;line-height:10px;"></i></button></dt>	';
	 li+='</dl></div></li>';
	 var $li=$(li);
	 $li.data("noteId",noteId);
	 $("#note-list").prepend($li);
}
//显示下拉选项
function showOption(){
	var note_menu = $(this).parents("li").find("div");
	note_menu.hide();
	note_menu.slideDown(500);
	event.stopPropagation();//阻止冒泡事件
}
//删除note
function deleteNote(){
	var noteId = $("#note-list a.checked").parent().data("noteId");
	if(noteId!=''){
		$.ajax({
			type:"post",
			dataType:"json",
			url:path +"/note/delete.do",
			data:{"noteId":noteId},
			success:function (result){
				$("#note-list a.checked").parent().remove();
				alert(result.msg);
			},
			error:function(){
				alert("删除笔记本失败");
			}
		});
	}
};