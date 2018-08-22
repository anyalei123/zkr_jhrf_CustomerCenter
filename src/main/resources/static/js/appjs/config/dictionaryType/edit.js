$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/config/dictionaryType/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			typeValue : {
				required : true
			},
			typeName : {
				required : true
			},
			typeDesc : {
				required : true
			}
		},
		messages : {
			typeValue : {
				required : icon + "请输入字典类型编码！"
			},
			typeName : {
				required : icon + "请输入字典类型名称！"
			},
			typeDesc : {
				required : icon + "请输入字典类型描述！"
			}
		}
	})
}