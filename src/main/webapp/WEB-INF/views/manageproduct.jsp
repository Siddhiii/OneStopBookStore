<%@ include file="adminheader.jsp"%>

<script>
	var productlist = ${prodlist}
	var supplierl = ${Supplierlistt}
	var category1 = ${categolist}
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope) {
		$scope.products = productlist;
		 $scope.supplier=supplierl;
		 $scope.category = category1;

	});
</script>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div ng-app="myApp">
<div class="container">
<c:choose>
<c:when test="${prolistupdate==true}">
<form:form class="jumbotron" action="updateprod" method="POST"  commandName="mp" enctype="multipart/form-data">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productid">ID: </form:label>
				<form:input path="productid" class="form-control disabledfield"
					readonly="true" placeholder="Enter Product ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="product_img">Product Image: </form:label>
				<form:input path="product_img" class="form-control" type="file"
					 ></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productname">Name: </form:label>
				<form:input path="productname" class="form-control disabledfield"
					placeholder="Enter Product name" required="required"></form:input>
			</div>
		</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productprice">price: </form:label>
				<form:input path="productprice" class="form-control disabledfield"
					placeholder="Enter Product ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group" ng-controller="myCtrl">
				<form:label path="supplierId">Supplier Id </form:label>
				<form:select path="supplierId" class="form-control">
					<option ng-repeat="sup in supplier" value="{{sup.supplierId}}">{{sup.supplierName}}</option>
			</form:select>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group" ng-controller="myCtrl">
				<form:label path="categoryid">Category Name </form:label>
				<form:select path="categoryid" class="form-control">
				<option ng-repeat="cat in category" value="{{cat.categoryid}}">{{cat.categoryname}}</option>
			</form:select>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="description">desc: </form:label>
				<form:input path="description" class="form-control disabledfield"
					placeholder="Enter Product desc" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="submit" class="btn btn-primary btn-block"
				value="Update Product" />
		</div>
	</div>
</form:form>
</c:when>
<c:otherwise>
<form:form class="jumbotron" action="addproduct" method="POST" 
	commandName="mp" enctype="multipart/form-data">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productid">ID: </form:label>
				<form:input path="productid" class="form-control disabledfield"
					readonly="true" placeholder="Enter Product ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="product_img">Product Image: </form:label>
				<form:input path="product_img" class="form-control" type="file"
				 required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productname">Name: </form:label>
				<form:input path="productname" class="form-control disabledfield"
					placeholder="Enter Product name" required="required"></form:input>
			</div>
		</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="productprice">price: </form:label>
				<form:input path="productprice" class="form-control disabledfield"
					placeholder="Enter Product Price" required="required"></form:input>
			</div>
		</div>	
		<div class="col-sm-4">
			<div class="form-group" ng-controller="myCtrl">
				<form:label path="supplierId">Supplier Name </form:label>
				<form:select path="supplierId" class="form-control">
				<option ng-repeat="sup in supplier" value="{{sup.supplierId}}">{{sup.supplierName}}</option>
			</form:select>
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group" ng-controller="myCtrl">
				<form:label path="categoryid">Category Name </form:label>
				<form:select path="categoryid" class="form-control">
				<option ng-repeat="cat in category" value="{{cat.categoryid}}">{{cat.categoryname}}</option>
			</form:select>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="description">desc: </form:label>
				<form:input path="description" class="form-control disabledfield"
					placeholder="Enter Product desc" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="submit" class="btn btn-primary btn-block"
				value="Add Product" />
		</div>
	</div>
</form:form>
</c:otherwise>
</c:choose>
</div>
<div ng-app="myApp" ng-controller="myCtrl">
	<div class="col-md-12">
		<h4 align="center">Manage Products</h4>
		<div id="custom-search-input">
			<div class="input-group col-md-12">
				<input type="text" class="search-query form-control"
					placeholder="Search" ng-model="seachproduct" /></span>
			</div>
		</div>

		<div class="table-responsive">
			<table id="mytable"
				class="table table-bordred table-striped table-hover">
				<tr>
				    
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Supplier Id</th>
					<th>Category Id</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Product Status</th>
					<th>Product Image</th>
					
					<th></th>
					<th>Edit/Delete</th>
					<th>Enable/Disable</th>
					

				</tr>
				<tr class="success" ng-repeat="prod in products|filter:seachproduct">
					<td>{{prod.productid}}</td>
					<td>{{prod.productname}}</td>
					<td>{{prod.supplierId}}</td>
					<td>{{prod.categoryid}}</td>
					<td>{{prod.description}}</td>
					<td>{{prod.productprice}}</td>
					<td>{{prod.productstatus}}</td>
						<td><img src="./resources/ecom_images/{{prod.productid}}.jpg" width="50px" height="50px"/><td>
				
			<td> <a  href="fetchProductById?id={{prod.productid}}"><button type="button" class="btn btn-default btn-sm" > 
          <span class="glyphicon glyphicon-pencil"></span> Edit </button>
        <a  href="delete?id={{prod.productid}}"><button type="button" class="btn btn-default btn-sm" >
          <span class="glyphicon glyphicon-trash"></span> Delete
        </button></a></td>
        <td> <a  href="enableprod?id={{prod.productid}}"><button type="button" class="btn btn-default btn-sm" > 
          <span class="glyphicon glyphicon-ok-circle"></span> Enable </button>
        <a  href="disableprod?id={{prod.productid}}"><button type="button" class="btn btn-default btn-sm" >
          <span class="glyphicon glyphicon-ban-circle"></span> Disable
        </button></a></td>
    
				</tr>
			</table>
		</div>
	</div>
</div>
</div>

<%@ include file="adminfooter.jsp"%>