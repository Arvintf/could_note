//弹出新建笔记本的对话框
function addBookWindow() {
	$("#can").load("alert/alert_notebook.html", function() {
		$('.opacity_bg').show();
	});
}
function closeAlertWindow(){
	//清空div内容
	$("#can").empty();
	//隐藏背景
	$('.opacity_bg').hide();
}
//弹出新建笔记的对话框
function addNoteWindow() {
	$("#can").load("alert/alert_note.html", function() {
		$('.opacity_bg').show();
	});
}
//弹出删除笔记警告对话框
function deleteNoteWindow() {
	$("#can").load("alert/alert_delete_note.html", function() {
		$('.opacity_bg').show();
	});
}