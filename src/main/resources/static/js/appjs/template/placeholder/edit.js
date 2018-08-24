$().ready(function() {
	//表单校验
	validateRule();
});

$.validator.setDefaults({
	//提交表单
	submitHandler : function() {
		update();
	}
});

//提交表单，修改数据
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/template/placeholder/update",
		data : $('#signupForm').serialize(), //表单序列化
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad(); //刷新列表
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			} else {
				parent.layer.alert(data.msg)
			}
		}
	});
}

//表单校验
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
        rules : {
            placeholderCode : { //占位符代码
                required : true
            },
            placeholderName : { //名称
                required : true
            },
            placeholderType : { //类型
                required : true
            }
        },
        messages : {
            placeholderCode : {
                required : icon + "请输入占位符代码"
            },
            placeholderName : {
                required : icon + "请输入占位符名称"
            },
            placeholderType : {
                required : icon + "请输入占位符类型"
            }
		}
	})
}