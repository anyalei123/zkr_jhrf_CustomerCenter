$().ready(function() {
    //表单校验
	validateRule();

    //寄送文件类型的回显
    var fileTypeSelect = $("#fileType");
    var fileType = fileTypeSelect.val();
    if(fileType=="0"){
        $("#fileTypeOption").text("纸质保单");
        fileTypeSelect.append("<option value='1'>其他类型</option>");
    }else if(fileType=="1"){
        $("#fileTypeOption").text("其他类型");
        fileTypeSelect.append("<option value='0'>纸质保单</option>");
    }

    //保险公司的回显
    var insuranceCompanySelect = $("#insuranceCompany");
    var insuranceCompany = insuranceCompanySelect.val();
    if(insuranceCompany=="富通保险"){
        $("#insuranceCompanyOption").text("富通保险");
        insuranceCompanySelect.append("<option value='泰康保险'>泰康保险</option>");
        insuranceCompanySelect.append("<option value='平安保险'>平安保险</option>");
    }else if(insuranceCompany=="泰康保险"){
        $("#insuranceCompanyOption").text("泰康保险");
        insuranceCompanySelect.append("<option value='富通保险'>富通保险</option>");
        insuranceCompanySelect.append("<option value='平安保险'>平安保险</option>");
    }else if(insuranceCompany=="平安保险"){
        $("#insuranceCompanyOption").text("平安保险");
        insuranceCompanySelect.append("<option value='富通保险'>富通保险</option>");
        insuranceCompanySelect.append("<option value='泰康保险'>泰康保险</option>");
    }else if(insuranceCompany==""){
        $("#insuranceCompanyOption").text("--请选择--");
        insuranceCompanySelect.append("<option value='富通保险'>富通保险</option>");
        insuranceCompanySelect.append("<option value='泰康保险'>泰康保险</option>");
        insuranceCompanySelect.append("<option value='平安保险'>平安保险</option>");
    }

    //快递公司的回显
    var courierCompanySelect = $("#courierCompany");
    var courierCompany = courierCompanySelect.val();
    if(courierCompany=="邮政"){
        $("#courierCompanyOption").text("邮政");
        courierCompanySelect.append("<option value='顺丰速运'>顺丰速运</option>");
        courierCompanySelect.append("<option value='中通快递'>中通快递</option>");
    }else if(courierCompany=="顺丰速运"){
        $("#courierCompanyOption").text("顺丰速运");
        courierCompanySelect.append("<option value='邮政'>邮政</option>");
        courierCompanySelect.append("<option value='中通快递'>中通快递</option>");
    }else if(courierCompany=="中通快递"){
        $("#courierCompanyOption").text("中通快递");
        courierCompanySelect.append("<option value='邮政'>邮政</option>");
        courierCompanySelect.append("<option value='顺丰速运'>顺丰速运</option>");
    }else if(courierCompany==""){
        $("#courierCompanyOption").text("--请选择--");
        courierCompanySelect.append("<option value='邮政'>邮政</option>");
        courierCompanySelect.append("<option value='顺丰速运'>顺丰速运</option>");
        courierCompanySelect.append("<option value='中通快递'>中通快递</option>");
    }

    //寄送人类型的回显
    var senderTypeSelect = $("#senderType");
    var senderType = senderTypeSelect.val();
    if(senderType=="0"){
        $("#senderTypeOption").text("代理人");
        senderTypeSelect.append("<option value='1'>客户</option>");
    }else if(senderType=="1"){
        $("#senderTypeOption").text("客户");
        senderTypeSelect.append("<option value='0'>代理人</option>");
    }

    //获取寄送人完整地址
    var senderAddress = $("#senderAddress1").val();
    //通过“，”将地址分割成多个字符串数组
    var senderAddressArray = senderAddress.split(',');
    //初始化寄送人地址联动插件
    $('#distpicker1').distpicker({
        province:senderAddressArray[0],//省
        city:senderAddressArray[1],//市
        district:senderAddressArray[2]//区
    });
    //寄送人详细地址
    $("#senderAddress").val(senderAddressArray[3]);

    //获取收件人完整地址
    var recipientAddress = $("#recipientAddress1").val();
    //通过“，”将地址分割成多个字符串数组
    var recipientAddressArray = recipientAddress.split(',');
    //初始化收件人地址联动插件
    $('#distpicker2').distpicker({
        province:recipientAddressArray[0],//省
        city:recipientAddressArray[1],//市
        district:recipientAddressArray[2]//区
    });
    //收件人详细地址
    $("#recipientAddress").val(recipientAddressArray[3]);

    //获取寄送时间
    var sendTimeSelect = $("#sendTime").val();
    if(sendTimeSelect == null || sendTimeSelect == ""){
        //如果寄送时间为空，设置最小值
        sendTimeSelect = "1900-01-01 00:00:00";
    }
    //获取收件时间
    var receiptTimeSelect = $("#receiptTime").val();
    if(receiptTimeSelect == null || receiptTimeSelect == ""){
        //如果收件时间为空，设置最大值
        receiptTimeSelect = "2099-12-31 23:59:59";
    }
    //寄送时间
    var sendTime = laydate.render({
        elem: '#sendTime',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        max:receiptTimeSelect, //寄送时间的最大值设置为已选的收件时间
        done: function (value, date, endDate) {
            receiptTime.config.min = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //寄送时间选好后，重置收件时间的最小时间
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
        min:sendTimeSelect, //收件时间的最小值设置为已选的寄送时间
        done: function (value, date, endDate) {
            sendTime.config.max = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //收件时间选好后，重置寄送时间的最大时间
        }
    });
    //获取冷静期起
    var calmPeriodStartSelect = $("#calmPeriodStart").val();
    if(calmPeriodStartSelect == null || calmPeriodStartSelect == ""){
        //如果冷静期起为空，设置最小值
        calmPeriodStartSelect = "1900-01-01 00:00:00";
    }
    //获取冷静期止
    var calmPeriodEndSelect = $("#calmPeriodEnd").val();
    if(calmPeriodEndSelect == null || calmPeriodEndSelect == ""){
        //如果冷静期止为空，设置最大值
        calmPeriodEndSelect = "2099-12-31 23:59:59";
    }
    //冷静期起
    var start = laydate.render({
        elem: '#calmPeriodStart',
        type:'datetime',  //可选择：年月日时分秒
        trigger: 'click', //采用click弹出
        max:calmPeriodEndSelect, // 冷静期起的最大值设置为已选的冷静期止
        done: function (value, date, endDate) {
            end.config.min = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //冷静期起选好后，重置冷静期止的最小时间
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
        min:calmPeriodStartSelect, //冷静期止的最小值设置为已选的冷静期起
        done: function (value, date, endDate) {
            start.config.max = {
                year: date.year,
                month: date.month - 1,
                date: date.date,
                hours: date.hours,
                minutes: date.minutes,
                seconds: date.seconds
            }; //冷静期止选好后，重置冷静期起的最大时间
        }
    });

    //寄送状态的回显
    var sendStateSelect = $("#sendState");
    var sendState = sendStateSelect.val();
    if(sendState=="0"){
        $("#sendStateOption").text("寄送中");
        sendStateSelect.append("<option value='1'>已签收</option>");
    }else if(sendState=="1"){
        $("#sendStateOption").text("已签收");
        sendStateSelect.append("<option value='0'>寄送中</option>");
    }

    //寄送附件的回显
    var attachUrl = $("#hidden").val();
    if(attachUrl!=null&&attachUrl!=""){
        var attachName = attachUrl.substring(attachUrl.lastIndexOf("/")+1);
        $("#aId").text(attachName);
    }
});

$.validator.setDefaults({
    //提交表单
	submitHandler : function() {
		update();
	}
});

//提交表单，修改数据
function update() {
    var formData = new FormData($("#signupForm")[0]);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/send/sendInfo/update",
        data : formData, //发送到服务器的数据
		async : false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type
		error : function(request) { //请求失败时回调
			parent.layer.alert("Connection error");
		},
		success : function(data) { //请求成功后回调
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