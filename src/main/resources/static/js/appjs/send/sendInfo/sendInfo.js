var prefix = "/send/sendInfo"
$(function() {
	load();
});

//发送请求，加载列表数据
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						iconSize : 'outline', //定义的图标大小
						toolbar : '#exampleToolbar', //jQuery的选择器，指明自定义的toolbar
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFul格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// 发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者asc,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                policyNo:$('#policyNo').val(),
                                sendOrderno:$('#sendOrderno').val(),
                                fileType:$("#fileType").val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [ //列配置项
								{
									checkbox : true //是否显示多选checkbox
								},
								{
									field : 'sendId', //该列映射的data的参数名
									title : '寄送编号' //该列的表头名
								},
								{
									field : 'policyNo', 
									title : '保单号' 
								},
								{
									field : 'sendOrderno', 
									title : '寄送单号' 
								},
								{
									field : 'fileType', 
									title : '寄送文件类型',
                                    formatter: function format1(value,row,index){
										if(value == "0"){
											return "纸质保单";
	                                     }else if(value == "1"){
											return "其他类型";
	                                     }
							        }
								},
								{
									field : 'insuranceCompany', 
									title : '保险公司' 
								},
								{
									field : 'courierCompany', 
									title : '快递公司' 
								},
								{
									field : 'senderType', 
									title : '寄送人类型',
									formatter:function format2(value,row,index){
                                        if(value == "0"){
                                            return "代理人";
                                        }else if(value == "1"){
                                            return "客户";
                                        }
									}
								},
								{
									field : 'senderName', 
									title : '寄送人姓名' 
								},
								{
									field : 'senderMobile', 
									title : '寄送人电话' 
								},
								{
									field : 'senderAddress', 
									title : '寄送人地址' 
								},
								{
									field : 'sendTime', 
									title : '寄送时间' 
								},
								{
									field : 'recipientName', 
									title : '收件人姓名' 
								},
								{
									field : 'recipientMobile', 
									title : '收件人电话' 
								},
								{
									field : 'recipientAddress', 
									title : '收件人地址' 
								},
								{
									field : 'receiptTime', 
									title : '收件时间' 
								},
								{
									field : 'sendContent', 
									title : '寄送内容' 
								},
								{
									field : 'sendDesc', 
									title : '寄送描述' 
								},
								{
									field : 'sendAttach', 
									title : '寄送附件'
								},
								{
									field : 'sendState', 
									title : '寄送状态',
                                    formatter:function format3(value,row,index){
                                        if(value == "0"){
                                            return "寄送中";
                                        }else if(value == "1"){
                                            return "已签收";
                                        }
                                    }
								},
								{
									field : 'calmPeriodStart', 
									title : '冷静期起' 
								},
								{
									field : 'calmPeriodEnd', 
									title : '冷静期止' 
								},
								{
									field : 'createTime', 
									title : '创建时间' 
								},
								{
									field : 'createBy',
									title : '创建人' 
								},
								{
									field : 'updateTime', 
									title : '修改时间' 
								},
								{
									field : 'updateBy',
									title : '修改人' 
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										// 格式化单元格内容，function(value, row, index),
										// value：该cell本来的值，
										// row：该行数据，
										// index：该行序号（从0开始）
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.sendId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.sendId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.sendId
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}

//刷新表格
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

//打开增加寄送信息窗口
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}

//打开编辑寄送信息窗口
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}

//根据id删除寄送信息
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'sendId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

//批量删除寄送信息
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['sendId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}