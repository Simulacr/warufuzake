<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String[] workspaces = null;
    String prevWorkspace = null;
    if(request.getCookies() != null)
        for(Cookie cookie: request.getCookies()){
            if("workspaces".equals(cookie.getName()))
                workspaces = cookie.getValue().split("-");
            if("workspace".equals(cookie.getName()))
                prevWorkspace = cookie.getValue();
        }
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
  <<link href='http://fonts.googleapis.com/css?family=Griffy' rel='stylesheet' type='text/css'>
  <style type="text/css">
    BODY {
      background: url('javax.faces.resource/image/mikusabbath.jpg') no-repeat scroll center 0 #000000;
      position: absolute;
      top:0;
      bottom: 0;
      left: 0;
      right: 0;
    }

    .loginBlock {
      position:absolute;
      vertical-align:middle;
      text-align: center;
      bottom: 20px;
      left: 41%;
      width:290px;
    }

    .label {
      color: white;
      font-family: 'Griffy', cursive;
      text-align: center;
      font-size: 18px;
    }

    INPUT {
      width: 100%;
      font-size: 18px;
      padding: 0;
      text-align: center;
    }

    /***FIRST STYLE THE BUTTON***/
    .submitbutton {
      position: absolute;
      top: 0;
      bottom: 0;
      border:2px groove #444;
      cursor:pointer; /*forces the cursor to change to a hand when the button is hovered*/
      padding: 0;
      /*style to the text inside the button*/
      color:#fff;
      font-family: 'Griffy', cursive;
      letter-spacing:.1em;
      font-variant:small-caps;
      /*add a drop shadow to the button*/
      -webkit-box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;
      -moz-box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;        ,
      box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;
      /*give the background a gradient - see cssdemos.tupence.co.uk/gradients.htm for more info*/
      background-color: #222; /*required for browsers that don't support gradients*/
      background: -webkit-gradient(linear, left top, left bottom, from(#999999), to(#222));
      background: -webkit-linear-gradient(top, #999999, #222);
      background: -moz-linear-gradient(top, #999999, #222);
      background: -o-linear-gradient(top, #999999, #222);
      background: linear-gradient(top, #999999, #222);
    }

    .buttonLeft {
      /*give the corners a small curve*/
      -webkit-border-radius: 15px 0 0 15px;
      -moz-border-radius: 15px 0 0 15px;
      border-radius: 15px 0 0 15px;
      left: 0;
      width: 50%;
    }

    .buttonRight {
      /*give the corners a small curve*/
      -webkit-border-radius: 0 15px 15px 0;
      -moz-border-radius: 0 15px 15px 0;
      border-radius: 0 15px 15px 0;
      right: 0;
      width: 50%;
    }

    /***NOW STYLE THE BUTTON'S HOVER AND FOCUS STATES***/
    .submitbutton:hover, .submitbutton:focus {
      color:#edebda;
      /*reduce the spread of the shadow to give a pushed effect*/
      -webkit-box-shadow: rgba(0, 0, 0, .25) 0 1px 0;
      -moz-box-shadow: rgba(0, 0, 0, .25) 0 1px 0;
      box-shadow: rgba(0, 0, 0, .25) 0 1px 0;
    }
  </style>
</head>
<script>
  function onEnter() {
    if(event.keyCode == 13)
      document.formLogin.sibmit();
  }
</script>
<body>

<c:if test="${not empty param.error}">
	<p style="color: red;"> <spring:message code="label.loginerror" />
	: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </p>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />" name="formLogin">
<div class="loginBlock">
<table style="width: 100%">
  <tr>
    <td align="right"><div class="label">Login</div></td>
  </tr>
	<tr>
		<td><input type="text" name="j_username" /></td>
	</tr>
  <tr>
    <td align="right"><div class="label">Password</div></td>
  </tr>
	<tr>
		<td><input type="password" name="j_password" onkeypress="onEnter()"/></td>
	</tr>
    <%if(workspaces != null){%>
        <tr>
		<td align="right"><spring:message code="label.workspace" /></td>
                <td><select name="workspace">
                    <option value="Default">
                        <spring:message code="label.default" />
                    </option>
                    <%for(String workspace: workspaces){%>
                        <option value="<%=workspace%>"
                    <%if(workspace.equals(prevWorkspace)){%> selected <%}%>>
                            <%=workspace%>
                        </option>
                    <%}%>
                </select></td>
	</tr>
    <%}%>
	<%--<tr>--%>
		<%--<td align="right"><spring:message code="label.remember" /></td>--%>
		<%--<td><input type="checkbox" name="_spring_security_remember_me" /></td>--%>
	<%--</tr>--%>
	<tr>
		<td align="right">
      <div style="position: absolute; bottom: 0; height: 30px;width: 100%">
        <input type="submit" value="Login" class="submitbutton buttonLeft"/>
		    <input type="submit" value="Reset" class="submitbutton buttonRight"/>
      </div>
      <div style="visibility: hidden; height: 30px; width: 0"></div>
    </td>
	</tr>
</table>
</div>
</form>
</body>
</html>