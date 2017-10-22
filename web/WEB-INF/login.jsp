<%-- 
    Document   : login
    Created on : Sep 17, 2017, 6:36:06 PM
    Author     : 742227
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="sait1"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <sait1:login/>
        ${errorMessage}
        
        <sait:debug >
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
    </body>
</html>
