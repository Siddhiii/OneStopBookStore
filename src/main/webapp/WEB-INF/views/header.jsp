<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>OneStopBookStore</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script src="resources/js/bootstrap.min.js"></script>
  <style>
  input[type=text] {
    
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
}

input[type=text]:focus {
    width: 100%;
}

   </style>
 
 </head>
<body ng-app="myApp"  >
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="">OneStopBookStore</a></td>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="">Home</a></li>
           <li><a href="about">About Us</a></li>
           <li><a href="#">Spiritual</a></li>
       <li><a href="#">Frictional</a></li>
       <li><a href="#">Non-Frictional</a></li>
      <li><a href="#">Academics</a></li>
        <li><a href="#">Contact Us</a></li>
         <li><form><input type="text" name="search" placeholder="Search..">
         </form>
          
         </ul>
         
        <ul class="nav navbar-nav navbar-right">
        <c:choose>
        <c:when test="${userloggedin==true}">
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
         <li><a href="perform_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      
        </c:when>
        <c:otherwise>
         <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
         <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:otherwise>
        </c:choose>
       
      </ul>
    </div>
  </div>
</nav>
  
     