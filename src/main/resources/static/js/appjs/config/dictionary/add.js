$().ready(function() {
	validateRule();
	//查询字典类型下拉选项
    $.ajax({
        type : "GET",
        url : "/config/dictionaryType/listType",
        dataType : "json",
        async : false,
        success : function(data) {
            var select = $("#typeId");
            $(data).each(function (index, type) {
                select.append("<option value="+type.typeId+">"+type.typeName+"</option>");
            })
        }
    });
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/config/dictionary/save",
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






