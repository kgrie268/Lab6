<%-- 
    Document   : mainPage
    Created on : Sep 17, 2017, 6:36:51 PM
    Author     : 742227

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />


<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <p> Hello, ${userName} <a href="login?action=logout"> Logout</a> </p>

<c:import url="/includes/footer.html" />
