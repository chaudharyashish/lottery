<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Register Yourself...</h2>
        
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" 
                            class="form-control" 
                            placeholder="First Name"
                            autofocus="true" />
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="lastName" 
                            class="form-control" 
                            placeholder="Last Name" />
                
               <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

		<spring:bind path="mobileNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="mobileNumber" 
                            class="form-control" 
                            placeholder="Mobile Number" />
                
               <form:errors path="mobileNumber"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="emailId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="emailId" 
                            class="form-control" 
                            placeholder="Email Address" />
                
               <form:errors path="emailId"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="address1">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="address1" 
                            class="form-control" 
                            placeholder="Address Line 1" />
                
               <form:errors path="address1"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="address2">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="address2" 
                            class="form-control" 
                            placeholder="Address Line 2" />
                
               <form:errors path="address2"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="city" 
                            class="form-control" 
                            placeholder="City" />
                
               <form:errors path="city"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="state">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                            path="state" 
                            class="form-control" 
                            placeholder="State" />
                
               <form:errors path="state"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="pincode">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text"
                			id="pincode"
                            path="pincode" 
                            class="form-control" 
                            placeholder="Pincode"/>
                
               <form:errors path="pincode"></form:errors>
            </div>
        </spring:bind>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function loadCityandState() {
		var client = new XMLHttpRequest();
		client.open("GET", "http://api.zippopotam.us/in/"+$("#pincode").val(), true);
		client.onreadystatechange = function() {
			if(client.readyState == 4) {
				alert(client.responseText);
			};
		};
	
		client.send();
	}
</script>
</body>
</html>
