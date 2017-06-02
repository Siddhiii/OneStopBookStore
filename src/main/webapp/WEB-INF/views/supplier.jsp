<%@ include file="adminheader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var supplierlist = ${Supplierlistt}
	var app = angular.module('getSupplier', []);
	app.controller('getSupplierController', function($scope) {
		$scope.supplier =supplierlist ;//$scope.products =supplierlist should match with var supplierlist 

	});
</script>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
<c:when test="${suplistupdate==true}">
<form:form class="jumbotron" action="updatesup" method="POST"
	commandName="supplier">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierId">Supplier Id </form:label>
				<form:input path="supplierId" class="form-control disabledfield"
					readonly="true" placeholder="Enter Supplier ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierName">Supplier Name </form:label>
				<form:input path="supplierName" class="form-control disabledfield"
					placeholder="Enter Supplier Name" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierContact">Supplier Contact</form:label>
				<form:input path="supplierContact" class="form-control disabledfield"
					placeholder="Enter Supplier Contact" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierAdress">Supplier Address </form:label>
				<form:input path="supplierAdress" class="form-control disabledfield"
					placeholder="Enter Supplier Address" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="submit" class="btn btn-primary btn-block"
				value="Update" />
		</div>
	</div>
</form:form>
</c:when>

<c:otherwise>
<form:form class="jumbotron" action="SaveSupplier" method="POST" commandName="supplier">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierId">Supplier Id </form:label>
				<form:input path="supplierId" class="form-control disabledfield"
					readonly="true" placeholder="Enter Supplier ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierName">Supplier Name </form:label>
				<form:input path="supplierName" class="form-control disabledfield"
					placeholder="Enter Supplier Name" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierContact">Supplier Contact</form:label>
				<form:input path="supplierContact" class="form-control disabledfield"
					placeholder="Enter Supplier Contact" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="supplierAdress">Supplier Address </form:label>
				<form:input path="supplierAdress" class="form-control disabledfield"
					placeholder="Enter Supplier Address" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="submit" class="btn btn-primary btn-block"
				value="Add Supplier" />
		</div>
	</div>
</form:form>

</c:otherwise>
</c:choose>

<div ng-app="getSupplier" ng-controller="getSupplierController">
	<div class="col-md-12">
		<h4 align="center">Manage Suppliers</h4>
		<div id="custom-search-input">
			<div class="input-group col-md-12">
				<input type="text" class="search-query form-control"
					placeholder="Search" ng-model="seachproduct" /></span>
			</div>
		</div>

		<div class="table-responsive">
				<table id="mytable" class="table table-bordred table-striped table-hover well">
				<tr>
					<th>Supplier Id</th>
					<th>Supplier Name</th>
					<th>Supplier Contact</th>
					<th>Supplier Address</th>
					<th></th>
					</tr>
					<tr class="success"	ng-repeat="sup in supplier|filter:seachproduct"><!--sup in supplier should match with $scope.supplier -->
						<td>{{sup.supplierId}}</td>
						<td>{{sup.supplierName}}</td>
						<td>{{sup.supplierContact}}</td>
						<td>{{sup.supplierAdress}}</td>
                   <td><a  href="supfetchProductById?s_id={{sup.supplierId}}"><button type="button" class="btn btn-default btn-sm" > 
          <span class="glyphicon glyphicon-pencil"></span> Edit </button>
          
        <a  href="deletesup?s_id={{sup.supplierId}}"><button type="button" class="btn btn-default btn-sm" >
          <span class="glyphicon glyphicon-trash"></span> Delete
        </button></a>
    
				</tr>
			</table>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>