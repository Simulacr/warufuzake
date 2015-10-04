<%@page import="desu.nya.shared.utils.UserUtils"%>
<%@ page import="desu.nya.web.utils.NavigationUtils" %>
<%
    String location;
    if(UserUtils.getCurrentPreferences() != null){
        location = "/mavenproject/index";
        response.addCookie(new Cookie("workspaces", UserUtils.getWorkspaceString()));
        NavigationUtils.switchWorkspace(request.getParameter("workspace"));
    }
    else
        location = "/mavenproject/login.jsp";

%>
<SCRIPT language="JavaScript1.2" type="text/javascript">
    top.location = "<%=location%>";
</SCRIPT>
<HTML><HEAD></HEAD><BODY></BODY></HTML>
