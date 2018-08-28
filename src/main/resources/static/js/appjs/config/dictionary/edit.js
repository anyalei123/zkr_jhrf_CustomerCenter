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
	var delFlag = $("#hiddenInput").val();
    $.ajax({
        type : "GET",
        url : "/config/dictionary/getByType/"+encodeURI(encodeURI("删除标记")),
        dataType : "json",
        async : false,
        success : function(data) {
            $(data).each(function (index, dictionary) {
                if (dictionary.dictValue == delFlag){
                    delSelect.append("<option selected value="+dictionary.dictValue+">"+dictionary.dictName+"</option>");
                }else{
                    delSelect.append("<option value="+dictionary.dictValue+">"+dictionary.dictName+"</option>");
                }
            })
        }
    });
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
            typeId : {
                required : true,
                min : 0
            },
            dictName : {
                required : true
            },
            dictValue : {
                required : true
            },
            dictDesc : {
                required : true
            }
        },
        messages : {
            typeId : {
                required : icon + "请选择字典类型！",
                min: icon + "请选择字典类型！"
            },
            dictName : {
                required : icon + "请输入字典名称！"
            },
            dictValue : {
                required : icon + "请输入字典数据值！"
            },
            dictDesc : {
                required : icon + "请输入字典描述！"
            }
		}
	})
}