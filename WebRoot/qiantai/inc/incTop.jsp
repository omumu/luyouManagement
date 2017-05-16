<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
         
        function getOffsetTop (el, p)
        {
		    var _t = el.offsetTop;
		    while (el = el.offsetParent) 
		    {
		        if (el == p) break;
		        _t += el.offsetTop;
		    }
            return _t;
        };

		function getOffsetLeft (el, p) 
		{
		    var _l = el.offsetLeft;
		    while (el = el.offsetParent) 
		    {
		        if (el == p) break;
		        _l += el.offsetLeft;
		    }
		    return _l;
		};
        var tt;
        var curMenu;
		function mouseover (th, menu) 
		{
		    if (tt) clearTimeout(tt);
		    displayMenu(false);
		    menu = document.getElementById('menu' + menu);
		
		    menu.style.left = getOffsetLeft(th) + 'px';
		    menu.style.top = getOffsetTop(th) + th.offsetHeight + 'px';
		
		    curMenu = menu;
		    displayMenu(true);
		}
		function mouseout () 
		{
		    tt = setTimeout('displayMenu(false)', 200);
		}
		function _mouseover () 
		{
		    if (tt) clearTimeout(tt);
		    displayMenu(true);
		}
		function _mouseout () 
		{
		    displayMenu(false);
		}
		function displayMenu (display) 
		{
		    if (curMenu) 
		    {
		        curMenu.style.display = display ? 'block' : 'none';
		    }
		}
		function doZoom(size)
		{
			document.getElementById('textbody').style.fontSize=size+'px'
		}
		
      </script>
      
      
      <style type="text/css">
        
        UL,ol,li,dl,dt,dd 
		{
			padding:0px;
			margin:0px;
			list-style-type: none;
		}
		a
		{
			text-decoration: none;
		}
		.menu 
		{
			MARGIN: auto auto;//这句很重要,起的作用是--让这个导航栏居中
			TEXT-ALIGN: left;
			background-image: url(/mhwz/images/nav_bj.jpg);
			
		}
		.menu A 
		{
			DISPLAY: block; 
			FLOAT: left; 
			PADDING-BOTTOM: 0px; 
			COLOR: #fff; 
			PADDING-TOP: 0px;
		}
		.menu A:hover
		{
			PADDING-RIGHT: 15px; 
			background-repeat: repeat-x;
			background-position: left top; 
			COLOR: #ffff00;
		}
		.menu .select 
		{
			PADDING-RIGHT: 15px; 
			BACKGROUND: url(/mhwz/images/nav_link.jpg);
			background-repeat: repeat-x;
			background-position: left top; 
		}
		DIV.menu 
		{
			
		}
		DIV.menu-list 
		{
			BORDER-RIGHT: #d6d6d6 1px solid; 
			PADDING-RIGHT: 0px; BORDER-TOP: #d6d6d6 1px solid; 
			DISPLAY: none; PADDING-LEFT: 0px; 
			BACKGROUND: #fff; FILTER: alpha(opacity=80); 
			PADDING-BOTTOM: 5px; BORDER-LEFT: #d6d6d6 1px solid; 
			WIDTH: 120px; 
			PADDING-TOP: 0px; 
			BORDER-BOTTOM: #d6d6d6 1px solid; 
			POSITION: absolute; 
			opacity: 0.8;
		}
		DIV.menu-list UL 
		{
			PADDING-RIGHT: 0px; 
			PADDING-LEFT: 0px; 
			PADDING-BOTTOM: 0px; 
			MARGIN: 0px; 
			PADDING-TOP: 0px;
		}
		DIV.menu-list UL LI 
		{
			PADDING-RIGHT: 0px; 
			PADDING-LEFT: 0px; 
			PADDING-BOTTOM: 0px; 
			MARGIN: 0px; 
			PADDING-TOP: 0px;
		}
		DIV.menu-list UL LI 
		{
			MARGIN: 5px 5px 0px; 
			LIST-STYLE-TYPE: none;
		}
		DIV.menu-list UL LI A 
		{
			DISPLAY: block; 
			WIDTH: 100%; 
			CURSOR: pointer; 
			COLOR: #000; 
			LINE-HEIGHT: 25px; 
			HEIGHT: 25px; 
			TEXT-ALIGN: center; 
			TEXT-DECORATION: none;
		}
		DIV.menu-list UL LI A SPAN 
		{
			DISPLAY: block; 
			WIDTH: 100%; 
			HEIGHT: 100%
		}
		DIV.menu-list UL LI A:hover 
		{
			BACKGROUND: url(/mhwz/images/nav_hover.jpg);
			background-repeat: repeat-x;
			background-position: left top; 
			COLOR: black;
		}
		DIV.menu-list UL LI A:hover SPAN 
		{
		
		}
     </style>
  </head>
  
  <body>
       <TABLE border=0 cellSpacing=0 cellPadding=0 width=772 height=125 bgColor=#ffffff align=center style="background-image: url('<%=path %>/img/logo.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD height=80 width=772 align=center>
			     &nbsp;
		    </TD>
		  </TR>
		</TABLE>
       <TABLE  border=0 cellSpacing=0 cellPadding=0 width=772 align=center style="background-image: url('<%=path %>/img/banner.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD>
		         <DIV class=menu style="margin-top: 1px;width: 772px;height:25px; line-height: 25px;">
					<A href="<%=path %>/jingdianAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
					    text-decoration: none;font-family: 楷体;color: black  ">旅游景点
					</A> 
				    <A href="<%=path %>/xianluAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">旅游线路
				    </A> 
				    <A href="<%=path %>/jiudianAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">餐馆信息
				    </A> 
				    
				    <A href="<%=path %>/binguanAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">宾馆信息
				    </A> 
				    <A href="<%=path %>/xinwenAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">新闻资讯
				    </A>
				    <A href="<%=path %>/liuyanAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">留言板
				    </A> 
				    <A href="<%=path %>/youjiAll.action" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">游记信息
				    </A> 
			      <A href="<%=path %>/activityDetailForUser.action?page=1" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">活动信息
				    </A> 
				    <A href="<%=path %>/qiantai/weather/weather.jsp" style="font-size: 14px;font-weight: 700;PADDING-LEFT: 15px;
				        text-decoration: none;font-family: 楷体;color: black  ">查询天气
				    </A> 
				 </DIV>
		    </TD>
		  </TR>
	   </TABLE>
  </body>
</html>
