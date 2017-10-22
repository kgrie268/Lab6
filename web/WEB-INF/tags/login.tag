<%-- 
    Document   : login
    Created on : Oct 21, 2017, 2:44:19 PM
    Author     : 742227
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
      <form  action="login" name= "ageCal" method="post">
            <p>Username:  <input type ="text" name="userName" value="${userName}"></p>
            <p>Password:  <input type ="text" name="passWord" value=""></p>
            <input type ="submit" value="Login" > 
            <p><input name="checkBox" value="add" type="checkbox" ${checked}> Remember Me :)</p>
            </form>