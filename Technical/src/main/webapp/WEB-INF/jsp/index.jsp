<%@page import="desu.nya.shared.utils.UserUtils"%>
<% 
    if(UserUtils.getCurrentPreferences() == null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
%>
