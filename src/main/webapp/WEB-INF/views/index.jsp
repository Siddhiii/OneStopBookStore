<%@ include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
	var prductlist = ${plist};
	
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope) {
		$scope.products = prductlist;

	});
</script>
<style>
.carousel-inner{
  width:100%;
  max-height: 5000px;
}
</style>
<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">

      <div class="item active">
        <img src="resources/images/pexels-photo-113776.jpg" style="width:100%;height:200%">
        
      </div>

      <div class="item">
        <img src="resources/images/pexels-photo-203218.jpg" style="width:100%;height:200%">
        <div class="carousel-caption">
          </div>
      </div>
    
      <div class="item">
        <img src="resources/images/pexels-photo-300412.jpg" style="width:100%;height:200%">
        <div class="carousel-caption">
         </div>
      </div>
        
        <div class="item">
       <img src="resources/images/pexels-photo-256232.jpg" style="width:100%;height:200%">
        <div class="carousel-caption">
         </div>
      </div>
  
    </div>

 
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div class="fluid -container">
  <div class=row ng-controller="myCtrl" >
  
     <div  class="col-sm-3" ng-repeat="pr in products" >
        <div class="panel panel-primary">
          <div class="panel-heading text-center">{{pr.productname}}</div>
            <div class="panel-body"><img alt="img" ng-src="./resources/ecom_images/{{pr.productid}}.jpg" class="img-responsive" width="200px" height="200px"/>
            </div>
           </div>
        </div>
     </div>
</div>

<%@ include file= "footer.jsp"%>

