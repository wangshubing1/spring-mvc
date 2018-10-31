<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2018/10/31
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" contentType="text/html; charset=utf-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div><input type="button" onclick="req();" value="请求"/>
<script src="assets/js/jquery-3.1.1.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url:"convert",
            data:"1-wangyunfei",
            type:"POST",
            contentType:"application/x-wisely",
            success:function (data) {
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>