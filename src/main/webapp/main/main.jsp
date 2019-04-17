<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LT论坛管理系统主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css"><link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
		function addTab(menuName,menuUrl) {
			var a=$("#tt").tabs("exists",menuName);
			if(a){
			    $("#tt").tabs("select",menuName);
			}else{
			    $("#tt").tabs("add",{
			        title:menuName,
					iconCls:"icon-add",
					closable:true,
                    href:menuUrl,
                });
			}
        }
		$(function() {
			$.ajax({
				type: 'POST',
				async: false,
				dataType: "json",
				data:"moduleParentId="+0,
				url: '/forum/module/findAll.do',//获取菜单
				success: function(data) {
					$.each(data, function(index, value) { //加载父类节点即一级菜单
						$('#aa').accordion('add', {
						title: data[index].moduleName,
						//iconCls: data[index].menuIcon,
						selected: false
					});
				});
			$('#aa').accordion({
					selected:999,
					onSelect:function (title,index) {
			$.ajax({
					type: 'POST',
					async: false,
					dataType: "json",
					data: "moduleParentId=" + data[index].moduleId,
					url: '/forum/module/findAll.do',//获取菜单
						success: function (data2) {
							var pp = $('#aa').accordion('getSelected');
							pp.empty();
						$.each(data2, function(index, value) {
						pp.css("text-align","center").append('<a name="zl" class="easyui-linkbutton" data-options="iconCls:\''+data2[index].moduleIcon+'\',plain:true" onclick="addTab(\''+data2[index].moduleName+'\',\''+data2[index].moduleUrl+'\')" >'+data2[index].moduleName+'</a><br/>');
						});
					}
			});
					//$.parser.parse();
                        $("a[name='zl']").linkbutton({});
					}
				});
			}
		});
	});
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:84px;background-color:  #056DAA">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 微软雅黑;font-weight: 900;width: 500px;float:left;padding-left: 40px;padding-top: 12px" >LT论坛后台管理系统</div>
    	<div style="font-size: 17px;color: #FAF7F7;font-family: 微软雅黑;width: 300px;float:right;padding-top:30px;padding-right:-40px">欢迎您:xxxxx &nbsp;<a href="#" style="font-size: 14px;color: #FAF7F7;font-family: 微软雅黑;font-weight: 900;text-decoration:none">关于</a> <a href="#" style="font-size: 14px;color: #FAF7F7;font-family: 微软雅黑;font-weight: 900;text-decoration:none">修改密码</a>&nbsp;&nbsp;<a href="#" style="font-size: 14px;color: #FAF7F7;font-family: 微软雅黑;font-weight: 900;text-decoration:none" >退出</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 44px;background: #056DAA">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 微软雅黑" >&copy;毕业设计 hz15858@163.com</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">

    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title=" 位置: 首页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>