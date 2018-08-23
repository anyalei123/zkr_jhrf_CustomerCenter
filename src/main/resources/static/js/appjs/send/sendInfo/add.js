$().ready(function() {
    //表单校验
    validateRule();
	//初始化寄送人地址联动插件
    $('#distpicker1').distpicker({
        autoSelect:false
	});
    //初始化收件人地址联动插件
    $('#distpicker2').distpicker({
        autoSelect:false
    });
    //寄送时间
    var sendTime = laydate.render({
        elem: '#sendTime',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        done: function (value, date, endDate) {
            receiptTime.config.min = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //寄送时间选好后，重置收件时间的最小日期
            receiptTime.config.value = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //将收件时间的初始值设定为寄送时间
        }
    });
    //收件时间
    var receiptTime = laydate.render({
        elem: '#receiptTime',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        done: function (value, date, endDate) {
            sendTime.config.max = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //收件时间选好后，重置寄送时间的最大日期
        }
    });
    //冷静期起
    var start = laydate.render({
        elem: '#calmPeriodStart',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        done: function (value, date, endDate) {
            end.config.min = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //冷静期起选好后，重置冷静期止的最小日期
            end.config.value = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //将冷静期止的初始值设定为冷静期起
        }
    });
    //冷静期止
    var end = laydate.render({
        elem: '#calmPeriodEnd',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        done: function (value, date, endDate) {
            start.config.max = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //冷静期止选好后，重置冷静期起的最大日期
        }
    });
});

$.validator.setDefaults({
    //提交表单
	submitHandler : function() {
		save();
	}
});

//提交表单，保存数据
function save() {
    var formData = new FormData($("#signupForm")[0]);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/send/sendInfo/save",
        data : formData, //发送到服务器的数据
		async : false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type
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
// 手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请填写正确的手机号码");
//表单校验
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            policyNo : {  //保单号
				required : true
			},
            sendOrderno : {  //寄送单号
                required : true
            },
            fileType : {  //寄送文件类型
                required : true,
                min:0
            },
            senderType : {  //寄送人类型
                required : true,
                min:0
            },
            senderName : {  //寄送人姓名
                required : true
            },
            senderMobile : {  // 寄送人电话
                required : true,
                minlength:11,
                isMobile:true
            },
            senderAddress : {  //寄送人地址
                required : true
            },
            recipientName : {  //收件人姓名
                required : true
            },
            recipientMobile : {  //收件人电话
                required : true,
                minlength:11,
                isMobile:true
            },
            recipientAddress : {  //收件人地址
                required : true
            },
            sendContent : {  //寄送内容
                required : true
            },
            sendState : {  //寄送状态
                required : true,
                min:0
            }
		},
		messages : {
            policyNo : {  //保单号
				required : icon + "请输入保单号"
			},
            sendOrderno : {  //寄送单号
                required : icon+"请输入寄送单号"
            },
            fileType : {  //寄送文件类型
                required : icon+"请选择寄送文件类型",
                min:icon+"请选择寄送文件类型"
            },
            senderType : {  //寄送人类型
                required : icon+"请选择寄送人类型",
                min:icon+"请选择寄送人类型"
            },
            senderName : {  //寄送人姓名
                required : icon+"请输入寄送人姓名"
            },
            senderMobile : {  // 寄送人电话
                required : icon+"请输入寄送人电话",
                minlength:icon+"手机号不能小于11个字符",
                isMobile:icon+"请输入正确的手机号码"
            },
            senderAddress : {  //寄送人地址
                required : icon+"请输入寄送人地址"
            },
            recipientName : {  //收件人姓名
                required : icon+"请输入收件人姓名"
            },
            recipientMobile : {  //收件人电话
                required : icon+"请输入收件人电话",
                minlength:icon+"手机号不能小于11个字符",
                isMobile:icon+"请输入正确的手机号码"
            },
            recipientAddress : {  //收件人地址
                required : icon+"请输入收件人地址"
            },
            sendContent : {  //寄送内容
                required : icon+"请输入寄送内容"
            },
            sendState : {  //寄送状态
                required : icon+"请选择寄送状态",
                min:icon+"请选择寄送状态"
            }
		}
	})
}