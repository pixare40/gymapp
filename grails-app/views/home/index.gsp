<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Welcome to Bradford Gym</title>
    <r:require modules="bootstrap" />
  </head>
  <body class="body">
      <div class="container">
          <g:render template="menu"/>
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active" >
      <img src="/GymApp/static/images/slideshow/carousel_04.jpg" alt="Gym1" style="width:100%;">
      <div class="carousel-caption">
        Excellent Facilities
      </div>
    </div>
    <div class="item">
      <img  src="/GymApp/static/images/slideshow/carousel_06.jpg" alt="Gym1" style="width:100%;">
      <div class="carousel-caption">
        Excellent Facilities
      </div>
    </div>
    <div class="item">
      <img src="/GymApp/static/images/slideshow/carousel_08.jpg" alt="Gym1" style="width:100%;">
      <div class="carousel-caption">
        Excellent Facilities
      </div>
    </div>
    <div class="item">
      <img src="/GymApp/static/images/slideshow/carousel_09.jpg" alt="Gym1" style="width:100%;">
      <div class="carousel-caption">
        Excellent Facilities
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
      </div>
  </body>
</html>
