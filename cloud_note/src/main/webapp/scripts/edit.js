//根据userId加载笔记本列表
function loadNoteBooks(userId) {
	$("#notebook-list").empty();
	if (userId == null) {
		window.location.href="log_in.html";
	} else {
		$.ajax({
			type : "post",
			url : path + "/book/loadNoteBooks.do",
			data : {
				"userId" : userId
			},
			dataType : "json",
			success : function(result) {
				// 查询成功
				if (result.status == 0) {
					// 获取笔记本集合
					var books = result.data;
					for (var i = 0; i < books.length; i++) {
							var bookName = books[i].cn_notebook_name;
							var bookId = books[i].cn_notebook_id;
							//创建笔记本的列表项元素
							createBookLi(bookId,bookName);
					}
				}
			},
			error : function() {
				alert("获取笔记本列表失败");
			}
		});
	}
};
//创建li元素
function createBookLi(bookId,bookName){
	var sli='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>';
	sli+=bookName;
	sli+='</a></li>';
	var $li = $(sli);
	//将bookId的值与jQuery对象绑定
	$li.data("bookId",bookId);
	$("#notebook-list").append($li);
};
//创建新的Book
function addBook(){
	var bookName = $("#input_notebook").val();
	var userId = getCookie("userId");
	if(bookName!=''&&userId!=null){
		$.ajax({
			type:"post",
			dataType:"json",
			url:path+"/book/addBook.do",
			data:{"userId":userId,"bookName":bookName},
			success:function(result){
				if(result.status==0){
					createPreBookLi(result.data.cn_notebook_id,bookName);
					//弹窗创建成功
					alert("创建笔记本成功");
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("创建笔记本失败");
			}
		});
	}else{
		alert("笔记本名称不能为空");
	}
}
function createPreBookLi(bookId,bookName){
	var sli='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>';
	sli+=bookName;
	sli+='</a></li>';
	var $li = $(sli);
	//将bookId的值与jQuery对象绑定
	$li.data("bookId",bookId);
	$("#notebook-list").prepend($li);
}