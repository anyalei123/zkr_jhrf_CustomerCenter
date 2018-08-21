//上传文件
layui.use('upload', function () {
    var upload = layui.upload;
    //执行实例
    var uploadInst = upload.render({
        elem: '#selectFile', //绑定元素
        url: '/send/sendInfo/importXlsx', //上传接口
        auto: false,//选择文件后不自动上传
        bindAction: '#importExcel', //指向一个按钮触发上传
        accept: 'file',
        exts:'xlsx|xls',//限定上传的文件后缀
        done: function (r) {
            if((r.importSuccess+r.importFail)==0){
                //导入的文件中没有数据
                layer.msg("选择的文件中没有数据！");
            }else{
                var msg ="一共导入"+(r.importSuccess+r.importFail)+"条数据，导入成功"+r.importSuccess+"条，导入失败"+r.importFail+"条";
                //如果有导入失败的数据，拼接失败的信息
                if(r.importFail!=0){
                    var map = r.failMap;
                    msg+="<br/>导入失败的信息如下：<br/>";
                    for(var key in map){
                        msg+="寄送单号："+key+"，失败原因："+map[key]+"<br/>";
                    }
                }
                layer.confirm(msg,{
                    btn:['寄送查询','继续导入']
                },function () {

                },function () {
                    
                });
            }
        },
        error: function (r) {
            layer.msg("操作失败");
        }
    });
});

//模板下载
function downloadTemplate(){
    window.location.href = "/send/sendInfo/downloadXlsx?fileName=寄送信息导入模板.xlsx";
}

