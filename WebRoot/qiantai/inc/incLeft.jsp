<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
   String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">    
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
      
      
      <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
     
      <script type="text/javascript">
            function login()
	        {
	           if(document.userLogin.userName.value=="")
	           {
	               alert("请输入账号");
	               return;
	           }
	           if(document.userLogin.userPw.value=="")
	           {
	               alert("请输入密码");
	               return;
	           }
	           document.getElementById("indicator").style.display="block";
	           loginService.login(document.userLogin.userName.value,document.userLogin.userPw.value,1,callback);
	        }
	        
	        function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data!="no")//返回的data就是用户的id
			    {
			        alert("通过验证,登录成功");
			        window.location.reload();
			    }
			}
	        
	        function gerenzhuye()
			{
			    var targetWinUrl="<%=path %>/auser/index.jsp";
				var targetWinName="newWin";
				var features="width="+screen.width+" ,height="+screen.height+" ,toolbar=yes, top=0, left=0, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes";
				var new_win=window.open(targetWinUrl,targetWinName,features);
			}
	        
	        
	        
	        function userLogout()
	        {
	            document.getElementById("indicator1").style.display="block";
	            loginService.userLogout(callback1);
	        }
	        function callback1(data)
			{
			    document.getElementById("indicator1").style.display="none";
			    if(data=="no")
			    {
			        alert("系统错误，请联系管理员");
			    }
			    if(data=="yes")
			    {   
			        alert("安全退出系统");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			    
			}
			
			function userReg()
	       {
	                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
	                var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
	       }
      </script>
  </head>
  
  <body>
        <TABLE border=0 cellSpacing=0 cellPadding=0>
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>用户登陆</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		             <c:if test="${sessionScope.user==null}">
		                    <form name="userLogin" method="POST" action="">
							      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0">
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="right" width="31%" height="30" style="font-size: 11px;">账号：</td>
							            <td align="left" width="69%"><input type="text" name="userName" style="width: 100px;"/></td>
							          </tr>
							          <tr>
							            <td align="right" height="30" style="font-size: 11px;">密码：</td>
							            <td align="left"><input type="password" name="userPw" style="width: 100px;"/></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="5"></td>
							          </tr>
							          <tr>
							            <td align="right" height="30" style="font-size: 11px;">&nbsp;</td>
							            <td align="left">
							               <input type="button" value="登 录" onclick="login()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
										   &nbsp;
										   <input type="reset" value="注册" onclick="userReg()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
							               <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
							            </td>
							          </tr>
							      </table>
						    </form>
						    </c:if>
						    <c:if test="${sessionScope.user!=null}">
						        <br/>
						        &nbsp;&nbsp;&nbsp;&nbsp;欢迎您：${sessionScope.user.userName } &nbsp;&nbsp;&nbsp;&nbsp;
							    <a href="#" onclick="userLogout()">安全退出</a> &nbsp;&nbsp;&nbsp;&nbsp;
							    <img id="indicator1" src="<%=path %>/img/loading.gif" style="display:none"/>
							    <br/><br/>
							    &nbsp;&nbsp;&nbsp;&nbsp;
							    <a href="#" onclick="gerenzhuye()">个人中心</a> &nbsp;&nbsp;&nbsp;&nbsp;
							    <br/><br/><br/>
							</c:if>
		          </TD>
		        </TR>
		        <tr><td height="20"></td></tr>
		        <!-- -->
		        
		        
		        <!--  
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>查询</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                     <form action="<%=path %>/chongwuRes.action" name="form1" method="post">
						        <table>
						            <tr>
						                <td>
						                    <input type="text" name="mingcheng" size="14"/>
						                </td>
						                <td>
						                    <input type="button" value="查询" onclick="c()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;"/>
						                </td>
						            </tr>
						        </table>
						     </form>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="5"></td></tr>
		         -->
		        
		        
		        <TR>
		          <TD class=b vAlign=top>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178>
		              <TR>
				          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
				             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>联系我们</font>
				          </TD>
				      </TR>
		            </TABLE>
		            <TABLE border=0 cellSpacing=3 cellPadding=3 width=178>
		              <TR>
		                <TD height=6 vAlign=middle width="100%">
		                    
		                </TD>
		              </TR>
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <FONT color=#ff0000><IMG src="<%=path %>/img/dot.gif" width=9 height=9>
		                       &nbsp;&nbsp;&nbsp;  
		                       <a href="#"><FONT color=#ff0000>地址：北京环海大厦2547</FONT></A>
		                    </FONT>
		                </TD>
		              </TR>
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <FONT color=#ff0000><IMG src="<%=path %>/img/dot.gif" width=9 height=9>
		                       &nbsp;&nbsp;&nbsp;  
		                       <a href="#"><FONT color=#ff0000>电话：13899999999</FONT></A>
		                    </FONT>
		                </TD>
		              </TR>
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <FONT color=#ff0000><IMG src="<%=path %>/img/dot.gif" width=9 height=9>
		                       &nbsp;&nbsp;&nbsp;  
		                       <a href="#"><FONT color=#ff0000>传真：010-45678912</FONT></A>
		                    </FONT>
		                </TD>
		              </TR>
		            </TABLE>
		          </TD>
		        </TR>
		        <tr><td height="10"></td></tr>
		        
		        
		        
		        
		        
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>网站日历</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                     <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="5"></td></tr>
		        <!-- -->
		</TABLE> 
  </body>
</html>
