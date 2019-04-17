<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>后台管理</title>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
<link href="css/login.css" rel="stylesheet" type="text/css">
<style type="text/css">
#inp_zh{position:absolute;left: 85px;	top: 55px;}
#inp_zh input{width:185px; height:20px;border:0;}
#inp_mm{position:absolute;left: 85px;top: 89px;}
#inp_mm input{width:185px; height:20px; border:0;}
</style>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">

        $(function(){

            //  form 表单提交
            $("#loginForm").bind("submit",function(){
                var name=$("#forumName").val();
                var pwd=$("#forumPassword").val();
                if(name==""){
                    alert("登录账户不能为空！");
                }if(pwd==""){
                    alert("密码密码不能为空！");
				}if(name!=""&&pwd!=""){
                    //alert("正常");
                    var managername =$("#forumName").val()
                    var managerpassword =$("#forumPassword").val()

                    /*$.ajax({
                        type: "POST",
                        url: "manager/loginIn.do",
                        data: {
                            forumName: managername,
                            forumPassword: managerpassword
                        },
                        dataType: "json",
                        error: function () {
                            alert('ajax请求请求错误...')
                        },
                        success: function (data) {
                            //清空
                            $("#showRet").empty();
                            if (data.manager == "redirect:/login.jsp") {
                                //将接收到的数据显示到文本框

								/!*document.getElementById("nameDiv").innerHTML = "用户不存在";
								 document.getElementById("nameDiv").style.color="red"*!/
                                alert("登录失败请重新登录");
                            }
                        },
                    })*/
                    return true;
                }
                return false;
            });


        });

        $(function(){
            //文本框点击事件
            $("#forumName").blur(function(){
                //发送ajax请求
                var manager =$("#forumName").val()
                $.ajax({
                    type:"POST",
                    url:"manager/checkUserName.do",
                    data:{
                        managerName:manager
                    },
                    dataType:"json",
                    error:function(){
                        alert('ajax请求请求错误...')
                    },
                    success:function(data){
                        //清空
                        $("#showRet").empty();
                        if(data.manager=="用户不存在"){
                            //将接收到的数据显示到文本框

                            /*document.getElementById("nameDiv").innerHTML = "用户不存在";
                            document.getElementById("nameDiv").style.color="red"*/
							alert("用户不存在");
                        } else{
                            /*document.getElementById("nameDiv").innerHTML = "用户已存在"
                            document.getElementById("nameDiv").style.color="green"*/
                        }
                    },
                })
            })
        });

	</script>
</head><body scroll="no" id="body">
<div style="height: 900px;" id="page">
	<form name="loginForm" method="post" id="loginForm" action="manager/loginIn.do">
		<div id="logo"><img src="images/biaoti.gif" width="362" height="77"></div>
	    <div id="ap">
	        <div class="err"></div>
	        <div class="content">
	            <div id="inp_zh"><input name="forumName" id="forumName" value="张三" type="text"><span id="nameDiv" style="display:block"></span></div>
	            <div id="inp_mm"><input name="forumPassword" id="forumPassword" value="123456" type="password"></div>
	            <div id="inp_but">
	            	<input name="Button22" id="submit" src="images/login.png"  type="image">
	            	<input name="Button222" id="reset" src="images/reset.png"  type="image">
	            </div>
	        </div>
	    </div>
    </form>
</div>
</body></html>
