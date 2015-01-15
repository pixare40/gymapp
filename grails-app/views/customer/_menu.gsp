<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#admin-menu">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                  <g:link controller="home" action="index" class="navbar-brand">Bradford Gym<br></g:link>
                  
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="admin-menu">
                <nav:menu scope="customermenu" class="nav navbar-nav"/>
              </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
</nav>
<sec:ifLoggedIn>
Welcome Back! <sec:loggedInUserInfo field="username"/> <g:link controller="logout">Log out</g:link>
</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
<g:link controller="Login" action="auth"><button type="button" class="btn btn-default navbar-btn">Sign in</button></g:link>
</sec:ifNotLoggedIn>