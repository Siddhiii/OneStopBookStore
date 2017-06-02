<%@ include file="adminheader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var userregister = ${userreg}
	var app = angular.module('myAppr', []);
	app.controller('myCtrl', function($scope) {
		$scope.register =userregister ;//$scope.products =supplierlist should match with var supplierlist 

	});
</script>

<script type='text/javascript'>

<script type="text/javascript">
function confirmpassword() {
    var password = document.getElementById("userpassword").value;
    var confirmPassword = document.getElementById("userconfirmpassword").value;
    if (userpassword != userconfirmpassword)
    {
        alert("Passwords do not match.");
        return false;
    }
    return true;
}
</script>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form class="jumbotron" action="register1" method="POST" commandName="ur"><!-- action = controller -->
	
			
		
		
			<div class="form-group">
				<form:label path="username">Username </form:label>
				<form:input path="username" class="form-control disabledfield"
					placeholder="Enter Username" required="required"></form:input>
			</div>
		
		<div class="form-group">
							<form:label  path="userpassword">Password:</form:label>
							<form:password path="userpassword" id="password" class="form-control" placeholder="Enter Password" required="required" pattern="^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#~$%^&*_]).{8,}$" title="The password must contain at least one number and one uppercase and lowercase letter and one special character like !,@,#,~,$,%,^,&,*,_ only, and at least 8 or more characters"></form:password>
						</div>	
						<div class="form-group">
							<form:label  path="userconfirmpassword">Confirm Password:</form:label>
							<form:password  path="userconfirmpassword" onkeyup="confirmpassword(); return false;" class="form-control" placeholder="Re-enter Password" required="required"></form:password>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
			<div class="form-group">
				<form:label path="userfirstname">First Name:</form:label>
				<form:input path="userfirstname" class="form-control disabledfield"
					placeholder="Enter your First name" required="required"></form:input>
			</div>
		
		<div class="form-group">
				<form:label path="userlastname">Last Name:</form:label>
				<form:input path="userlastname" class="form-control disabledfield"
					placeholder="Enter your Last name" required="required"></form:input>
			</div>
		
			<div class="form-group">
							<form:label  path="useremailid">E-mail:</form:label>
							<form:input  path="useremailid" class="form-control" type="email" placeholder="Enter Email ID" required="required" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter valid mail ID"></form:input>
						</div>
						
						<div class="form-group">
							<form:label  path="useraddr">Address:</form:label>
							<form:textarea  path="useraddr" rows="3" class="form-control" placeholder="Enter Address" required="required"></form:textarea>
						</div>
						<div class="form-group">
							<form:label  path="state">State:</form:label>
							<form:input  path="state" class="form-control" placeholder="Enter State" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label  path="city">City:</form:label>
							<form:input  path="city" class="form-control" placeholder="Enter City" required="required"></form:input>
						</div>
						<div class="form-group">	
							<form:label  path="pincode">Pincode:</form:label>
							<form:input  path="pincode" class="form-control" placeholder="Enter Pincode" required="required" pattern="^[1-9][0-9]{5}$" title="Please enter a valid pincode"></form:input>
						</div>
						
						
						
						<input  class="btn btn-primary btn-block" type="submit" value="Submit">
						</form:form>					
	




<%@ include file="adminfooter.jsp"%>