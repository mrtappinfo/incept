<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="snaplync">
<head ng-app="snaplync">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SnapLync</title>
<base href="/dashboard">
<link href="lib/bootstrap.min.css" rel="stylesheet" type="text/css"  />
<link href="lib/bootstrap-slider.css" rel="stylesheet" type="text/css"/>
<link href="lib/font-awesome.min.css" rel="stylesheet">

<!-- Select2 theme -->
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.css">
<link href="lib/select.min.css" type="text/css"  />
<link href="css/style.css" rel="stylesheet" type="text/css"  />
	
<!--link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800' rel='stylesheet' type='text/css'-->

	
	

</head>

<body ng-controller="mainController">

<header>
  <div class="container">
  
     <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">SnapLync</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
     
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{user.email}}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Profile</a></li>
            <li><a target="_self" href="/auth/logout">Logout</a></li>
          </ul>
        </li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  
  </div>

</header>

<!--End Header-->

 <div class="main-container">
   <section data-ui-view></section>
     
 </div>
 
<!--End Slider--> 

<div class="heading text-center">SnapLync helps people to find better paying jobs</div>
<!--End heading-->  



 
 <footer>
<div class="footer">
<ul class="footer-top">
<li><a href="#">Home</a></li>
<li><a href="#">Employers</a></li>
<li><a href="#">Sales</a></li>
<li><a href="#">Contractors</a></li>
<li><a href="#">Companies</a></li>
<li><a href="#">About</a></li>
<li><a href="#">Support</a></li>
<li><a href="#">Blog</a></li>
<li><a  href="#">Careers</a></li></ul>

<ul class="footer-bottom">
<li>&copy; 2015 Snaplync, Inc. All Rights Reserved.</li>
<li><a href="#">Privacy</a></li>
<li><a href="#">Terms</a></li>
<li>•</li>
<li><a href="#">Facebook</a></li>
<li><a href="#">Twitter</a></li>
<li><a href="#">LinkedIn</a></li>
<li><a href="#">Glassdoor</a></li>
<li><a href="#">YouTube</a></li>
<li><a href="#">Google+</a></li>
</ul>
</div>

 
 </footer>
 
 
 <!--End Footer--> 
 <script src="lib/jquery.min.js"></script>
    <script src="lib/angular.js"></script>
    <script src="lib/angular-resource.js"></script>
    <script src="lib/angular-cookies.js"></script>
    <script src="lib/angular-animate.js"></script>
    <script src="lib/angular-touch.js"></script>
    <script src="lib/angular-sanitize.js"></script>
    <script src="lib/angular-ui-router.js"></script>
    <script src="lib/ui-utils.js"></script>
    <script src="lib/ui-bootstrap-tpls.js"></script>
    <script src="lib/bootstrap.js"></script>
    <script src="lib/jasny-bootstrap.min.js"></script>
    <script src="lib/select.min.js"></script>
    <script src="lib/angular-http-loader.js"></script>
    <script src="lib/bootstrap-slider.min.js"></script>
    
	<script>
		var user = ${user};
		var session = ${session};
		var roles = ${roles};
		var industries = ${industries};
		var skills = ${skills};
	</script>
	<script src="js/app.js"></script>
	<script src="js/jobseeker.client.controller.js"></script>
	<script src="js/recruiter.client.controller.js"></script>

</body>
</html>
