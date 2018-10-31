<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" contentType="text/html; charset=utf-8">
        <title>SSE Demo</title>
    </head>
    <body>
        <div id="msgFromPush"></div>
        <script type="text/javascript" src="assets/js/jquery-3.1.1.js"></script>
        <script type="text/javascript">
                if (!!window.EventSource) {
                    var source = new EventSource('push');
        s = ' ';
        /* message event listener */
        source.addEventListener('message', function(e) {
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        });

        /* open event listener */
        source.addEventListener('open', function(e) {
            console.log("Connection is open");
        }, false);

        /* error event listener */
        source.addEventListener('error', function(e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("Connection is closed");
            } else {
                console.log("e.readyState");
            }
        }, false);
    } else {
        console.log("Your web browser dosen't support EventSource.");
    }
</script>
</body>
</html>