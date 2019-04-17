<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#dg_article').datagrid({
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
	    url:'/cmfz-admin/Article/query.do',
	    columns:[[    
	        {field:'articleId',title:'编号',width:40},
	        {field:'articleName',title:'标题',width:60},
            {field:'introduction',title:'介绍',width:60},
            {field:'articleStatus',title:'状态',width:30},
            {field:'articleDate',title:'创建时间',width:70,
            },
            {field:'articleByName',title:'所属上师',width:80},
	        {field:"operation",title:"操作",width:80,formatter:function(value,row,index){
	        	//$("#del").linkbutton({});
				return "<a name='art' class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-ok'\" onClick='show()'>文章详情</a>   ";
			}},
	    ]],


            onLoadSuccess:function(){
	    	/* console.log(11);
	    	$(".btn").linkbutton({}); */

                $("a[name='art']").linkbutton({});
	    },
	    pagination:true,
	    pageList : [ 5, 10, 15, 20, 25 ],
		pageSize : 5,
		toolbar : "#tb_article",
		fitColumns: true,
		singleSelect:true,
		
	});
	





	


});




        function show(){
            $("#dialog_article").dialog({
                iconCls:'icon-pictures',
                width:600,
                height:500,
                title:"文章详情",
                href:"${pageContext.request.contextPath}/article/showArticle.jsp",
                modal:true,
                minimizable:true,
                maximizable:true,
                onLoad:function(){
                    var rowData = $("#dg_article").datagrid("getSelected");
                    document.getElementById("hh").innerHTML=rowData.articleName;
                    document.getElementById("hh1").innerHTML=rowData.introduction;
                    document.getElementById("hh2").innerHTML=rowData.articleStatus;
                    document.getElementById("hh3").innerHTML=rowData.articleDate;
                    document.getElementById("hh4").innerHTML=rowData.articleByName;
                }
            });
        }



</script>

<table id="dg_article"></table>
<div id="tb_article">



</div>

<div id="dialog_article"></div>


