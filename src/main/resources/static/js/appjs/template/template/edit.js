$().ready(function() {
	//模板类型的回显
    $.ajax({
        type : "GET",
        url : "/template/templateType/listJson",
        dataType : "json",
        async : false,
        success : function(data) {
            var select1 = $("#typeId");
            var value1 = select1.val();
            $(data).each(function (index, type) {
            	if (type.typeId == value1){
            		$("#typeIdOption").text(type.typeName);
				}else{
                    select1.append("<option value="+type.typeId+">"+type.typeName+"</option>");
				}
            })
        }
    });

	//模板语言的回显
    var select = $("#templateLanguage");
    var language = select.val();
    if(language=="简体中文"){
        select.append("<option value='繁体中文'>繁体中文</option>");
        select.append("<option value='English'>English</option>");
    }else if(language=="繁体中文"){
        select.append("<option value='简体中文'>简体中文</option>");
        select.append("<option value='English'>English</option>");
    }else if(language=="English"){
        select.append("<option value='简体中文'>简体中文</option>");
        select.append("<option value='繁体中文'>繁体中文</option>");
	}

    //模板生效时间
    laydate.render({
        elem: '#effectTime' ,//指定元素
        type: 'datetime',//日期时间
        min:  timestr//最小时间
    });

	//表单校验
    validateRule();
});
//定义最小时间
var starttime = new Date();
var timestr = dateFtt("yyyy-MM-dd hh:mm:ss",starttime);
function dateFtt(fmt,date) {
    var o = {
        "M+" : date.getMonth()+1,                 //月份
        "d+" : date.getDate(),                    //日
        "h+" : date.getHours(),                   //小时
        "m+" : date.getMinutes(),                 //分
        "s+" : date.getSeconds(),                 //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S"  : date.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});

//提交表单，修改数据
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/template/template/update",
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
            templateName : {
                required : true
            },
            templateContent : {
                required : true
            },
            templateVersion : {
                required : true
            },
            typeId : {
                required : true,
                min : 0
            }
        },
        messages : {
            templateName : {
                required : icon + "请输入模板名称"
            },
            templateContent : {
                required : icon + "请输入模板内容"
            },
            templateVersion : {
                required : icon + "请输入模板版本"
            },
            typeId : {
                required : icon + "请选择模板类型",
                min : icon+"请选择模板类型"
            }
		}
	})
}