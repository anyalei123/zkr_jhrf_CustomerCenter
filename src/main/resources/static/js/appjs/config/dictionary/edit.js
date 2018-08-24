$().ready(function() {
	validateRule();
    //字典类型的回显
    $.ajax({
        type : "GET",
        url : "/config/dictionaryType/listType",
        dataType : "json",
        async : false,
        success : function(data) {
            var select = $("#typeId");
            var value = select.val();
            $(data).each(function (index, type) {
                if (type.typeId == value){
                    $("#typeIdOption").text(type.typeName);
                }else{
                    select.append("<option value="+type.typeId+">"+type.typeName+"</option>");
                }
            })
        }
    });
    //删除标记回显
    var delSelect = $("#delFlag");
	var delFlag = delSelect.val();
	if(delFlag == "0"){
		$("#delOption").text("未删除");
        delSelect.append("<option value='1'>已删除</option>");
	}else if(delFlag == "1"){
        $("#delOption").text("已删除");
        delSelect.append("<option value='0'>未删除</option>");
	}
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
		url : "/config/dictionary/update",
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
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}