<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<title>Select Lottery Number</title>
</head>
<body>
	<form:form modelAttribute="userForm" method="POST" action="selectLotteryNumbers">
	<div>
		<h3>Filters</h3>
		<input type="text" id="startingNumber" placeholder="Starting Number" />
		<input type="text" id="endingNumber" placeholder="Ending Number" />
		<input type="button" onclick="filterlottery()" value="Search" />
		<hr/>
		<hr/>
		<div id="lotteries">
		<%-- <table>
		<c:forEach items="${lotteryList}" var="lottery" varStatus="status">
			<tr>
				<td>
					<input type="checkbox" name="selectedLotteries" value="${lottery.id}"/>${lottery.lotteryNumber}
				</td>
			</tr>
		</c:forEach>
		</table> --%>
		<form:hidden path="id"/>
		<form:hidden path="firstName"/>
		<form:hidden path="lastName"/>
		<form:hidden path="mobileNumber"/>
		<form:hidden path="emailId"/>
		<form:hidden path="address1"/>
		<form:hidden path="address2"/>
		<form:hidden path="city"/>
		<form:hidden path="state"/>
		<form:hidden path="pincode"/>
		
		<form:checkboxes items="${lotteryList}" itemLabel="lotteryNumber" path="selectedLotteries"/>
		</div>
<%-- 		<form:checkboxes id="lotteries" items="${lotteryList}" path="selectedLotteries" /> --%>
		
	</div>
	<input type="submit">
	</form:form>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	function filterlottery() {
		var startingNumber = $("#startingNumber").val();
		var endingNumber = $("#endingNumber").val();
		var data = {start:startingNumber, end:endingNumber};
		 $.get("filterLotteryNumbers",{start:startingNumber, end:endingNumber}, function(data, status){
		        console.log("Data length: " + data.length + "\nStatus: " + status);
		        $("#lotteries").empty();
		        var checkboxTags="";
		        $.each(data, function(index,item){
		        	checkboxTags += "<span><input id='selectedLotteries"+index+"' name='selectedLotteries' type='checkbox' value='"+item.id+"'><label for='selectedLotteries"+index+"'>"+ item.lotteryNumber +"</label></span>";
		        });
		        
		        $("#lotteries").append(checkboxTags);
		    });
	}
</script>
</html>