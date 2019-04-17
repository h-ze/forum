
//function showCover
function showCover(cover,id){
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;      
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;	
	
	//如果是ie6，隐藏页面select
	if(Sys.ie=="6.0"){
		//alert("a");
		var n=document.getElementsByTagName("select").length;
		var m=document.getElementById(id).getElementsByTagName("select").length;

		//alert(m);
		for(var i = 0;i < n;i++){
			document.getElementsByTagName("select")[i].style.display= 'none';
		}
		for(var j=0;j<m;j++){
			document.getElementById(id).getElementsByTagName("select")[j].style.display= '';
		}
	}	
	var objCover=document.getElementById(cover);
	var objId=document.getElementById(id);
	var scrollW=document.documentElement.scrollWidth;
	var scrollH=document.documentElement.scrollHeight;
	if (Sys.safari) {
		var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.body.scrollTop;
	}else{
		var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.documentElement.scrollTop;	
	}
	var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
	
	
	objCover.style.width=scrollW+"px";
	objCover.style.height=scrollH+"px";
	objCover.style.visibility="visible";
	
	objId.style.top=T+"px";
	objId.style.left=L+"px";
	objId.style.visibility="visible";
}
//function hideCover
function hideCover(cover,id){
	//将页面全部select换件设为可用状态
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;    
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;	
	if(Sys.ie=="6.0"){
		var n=document.getElementsByTagName("select").length;
		for(var i=0;i<n;i++){
			document.getElementsByTagName("select")[i].style.display= '';
		}
	}
	var objCover=document.getElementById(cover);
	var objId=document.getElementById(id);
	objCover.style.visibility="hidden";
	objId.style.visibility="hidden";
}
function show_selected_item_val($item){   
   var value=$item.value;
   if(value=="1"){
	   document.getElementById("a").style.display="block";
	   document.getElementById("b").style.display="none";
	   }
	   else{
		  	document.getElementById("a").style.display="none";
	   		document.getElementById("b").style.display="block";
	   } 
  }
//function show_selected_item_val_2  
function show_selected_item_val_2($item){
var value=$item.value;
if(value=="1"){
   document.getElementById("x").style.display="block";
   document.getElementById("y").style.display="none";
   document.getElementById("z").style.display="none";
   }
   else if(value=="2")
   {
   document.getElementById("x").style.display="none";
   document.getElementById("y").style.display="block";
   document.getElementById("z").style.display="none";
	}
   else{
		document.getElementById("x").style.display="none";
		document.getElementById("y").style.display="none";
		document.getElementById("z").style.display="block";
	}
} 
 //function show2   
function show2($item){
   var value=$item.value;
   if(value=="3"){
	   document.getElementById("c").style.display="block";
	   document.getElementById("d").style.display="none";
	   }
	   else{
		  	document.getElementById("c").style.display="none";
	   		document.getElementById("d").style.display="block";
	   } 
}
//function show3    
function show3(obj){
	var opt=obj.value;
	if(opt==1){
		document.getElementById('shtian').style.display='block';
		document.getElementById('shtians').style.display='none';
	}else{
		document.getElementById('shtian').style.display='none';
		document.getElementById('shtians').style.display='block';
	}
}
//function show3
function show_cg(id){		
	var objId=document.getElementById(id);
	var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.body.scrollTop;
	var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
	objId.style.top=T+"px";
	objId.style.left=L+"px";
	objId.style.visibility="visible";
	alert("a");
}
function hide_cg(id){	
	var objId=document.getElementById(id);
	objId.style.visibility="hidden";
	show_tcdg2('pop_tdcg2');
}
function hide_cg2(id){	
	var objId=document.getElementById(id);
	objId.style.visibility="hidden";
}
function show_tcdg(id){		
	var objId=document.getElementById(id);
	var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.body.scrollTop;
	var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
	objId.style.top=T+"px";
	objId.style.left=L+"px";
	objId.style.visibility="visible";
	setTimeout("hide_cg2('pop_tdcg')" , 1000);
	
}
function show_tcdg1(id){		
	var objId=document.getElementById(id);
	var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.body.scrollTop;
	var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
	objId.style.top=T+"px";
	objId.style.left=L+"px";
	objId.style.visibility="visible";
	setTimeout("hide_cg('pop_tdcg')" , 1000);
	
}
function show_tcdg2(id){		
	var objId1=document.getElementById(id);
	var T=(document.documentElement.clientHeight-objId1.clientHeight)/2+document.body.scrollTop;
	var L=(document.documentElement.clientWidth-objId1.clientWidth)/2+document.documentElement.scrollLeft;
	objId1.style.top=T+"px";
	objId1.style.left=L+"px";
	objId1.style.visibility="visible";
	setTimeout("hide_cg3('pop_tdcg2')" , 1000);
	
}
function hide_cg3(id){	
	var objId1=document.getElementById(id);
	objId1.style.visibility="hidden";
}



//工单处理隐藏层

function ClickTr(){
	$(".clickdiv").toggle(function(){
		$(this).parent().parent().next(".displaytr").show();
		$(this).find("img").attr("src","../images/jian.gif");
		$(this).parent().parent().addClass("highlight2");
		$(this).parent().parent().next(".displaytr").addClass("highlight");
	},function(){
		$(this).parent().parent().next(".displaytr").hide();
		$(this).find("img").attr("src","../images/jia.gif");
		$(this).parent().parent().removeClass("highlight2");
		$(this).parent().parent().next(".displaytr").removeClass("highlight");
	});
}

/*全选反选*/

function ClickAll() { 
$('#selectFan').click(function(){
 $('input.checkBoxSelect').attr('checked',$(':checkbox',this).attr('checked'));
	});					 
};