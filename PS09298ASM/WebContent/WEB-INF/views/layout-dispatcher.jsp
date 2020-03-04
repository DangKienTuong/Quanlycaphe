<%
String view = request.getParameter("view");
if(view.startsWith("manage/")){
pageContext.forward("layout.jsp");
}
else{
pageContext.forward("blank-layout.jsp");
}
%>