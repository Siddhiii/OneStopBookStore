<%@ include file="adminheader.jsp"%>

<script>
	var categorylist = ${categolist}
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope) {
		$scope.category = categorylist;

	});
</script>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
<c:when test="${catlistupdate==true }">
<form:form class="jumbotron" action="updatecate" method="POST"
	commandName="cat">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categoryid">ID: </form:label>
				<form:input path="categoryid" class="form-control disabledfield"
					readonly="true" placeholder="Enter Category ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categoryname">Name: </form:label>
				<form:input path="categoryname" class="form-control disabledfield"
					placeholder="Enter Category name" required="required"></form:input>
			</div>
		</div>
		
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categorydescription">desc: </form:label>
				<form:input path="categorydescription" class="form-control disabledfield"
					placeholder="Enter Category description" required="required"></form:input>
			</div>
		</div>
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="submit" class="btn btn-primary btn-block"
				value="Edit Product" />
		</div>
	</div>
</form:form>
</c:when>
<c:otherwise>
<form:form class="jumbotron" action="addcat" method="POST"
	commandName="cat">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categoryid">ID: </form:label>
				<form:input path="categoryid" class="form-control disabledfield"
					readonly="true" placeholder="Enter Product ID" required="required"></form:input>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categoryname">Name: </form:label>
				<form:input path="categoryname" class="form-control disabledfield"
					placeholder="Enter Product name" required="required"></form:input>
			</div>
		</div>
		
	</div>
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-4">
			<div class="form-group">
				<form:label path="categorydescription">desc: </form:label>
				<form:input path="categorydescription" class="form-control disabledfield"
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
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Category Status</th>
					<th> </th>

				</tr>
				<tr class="success" ng-repeat="cate in category|filter:seachproduct">
					<td>{{cate.categoryid}}</td>
					<td>{{cate.categoryname}}</td>
					<td>{{cate.categorydescription}}</td>
					<td>{{cate.categorystatus}}</td>
					
                  <td> <a  href="catfetchProductById?id={{cate.categoryid}}"><button type="button" class="btn btn-default btn-sm" > 
          <span class="glyphicon glyphicon-pencil"></span> Edit </button>
          
        <a  href="deletecat?id={{cate.categoryid}}"><button type="button" class="btn btn-default btn-sm" >
          <span class="glyphicon glyphicon-trash"></span> Delete
        </button></a></td>
        
         <td> <a  href="enable?id={{cate.categoryid}}"><button type="button" class="btn btn-default btn-sm" > 
          <span class="glyphicon glyphicon-ok-circle"></span> Enable </button>
          
        <a  href="disable?id={{cate.categoryid}}"><button type="button" class="btn btn-default btn-sm" >
          <span class="glyphicon glyphicon-ban-circle"></span> Disable
        </button></a></td>
    
				</tr>
			</table>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>
