<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>InfoIncept</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/mainstyle.css" rel="stylesheet"> 
<link href="css/style.css" rel="stylesheet" type="text/css"  />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home">
<div class="page-wrap">
  <header id="siteheader">
    <nav class="navbar navbar-default">
      <div class="container-fluid"> 
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="index.html"><strong>InfoIncept</strong></a> </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login?profile=jobseeker">new consultants</a></li>
            <li><a href="login?profile=recruiter">recruiters</a></li>
          </ul>
          </li>
          </ul>
        </div>
        <!-- /.navbar-collapse --> 
      </div>
      <!-- /.container-fluid --> 
    </nav>
  </header>
  
  
  <div class="main-content">
    <div class="container">
      <div class="form-box">
        <div class="form-top">
          <div class="form-top-left">
            <h3>Enter your email </h3>
          </div>
        </div>
        <div class="form-bottom">
          <form id = "form" class="mail-form text-center" method="post" action="/save" role="form">
            <div class="form-group">
              <label for="form-email" class="sr-only">Email</label>
              <input type="text" id="form-email" class="form-email form-control" ng-model="user.email" placeholder="Email..." name="email">
            </div>
             <button onclick = "submitData()" class="btn btn2" type="submit">Sign me up!</button> 
           <!--    <input class="button" type="button" ng-click="signUp()" value="Sign me up!"> -->
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- /maincontent --> 
</div>
<!-- /page-wrap -->

<footer class="site-footer footer">
  <div class="container">
    <div class="row">
      <div class="col-sm-6"> &copy; 2016 InfoIncept. All rights reserved. </div>
      <div class="col-sm-6 booton-links"> <a  href="javascript:;">About</a> <a  href="javascript:;">Privacy Policy</a> </div>
    </div>
  </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.min.js"></script>
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
<script src="js/app.js"></script>
<script src="js/signup.controller.js"></script>


<script>

function submitData() {
	
	
	 //var form = document.getElementById("form");
	/*  
	 var email = document.getElementById("form-email").value;
	 
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);

	    for(var key in params) {
	        if(params.hasOwnProperty(key)) {
	            var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", key);
	            hiddenField.setAttribute("value", params[key]);

	            form.appendChild(hiddenField);
	         }
	    }

	    document.body.appendChild(form);
	    form.submit();
	
	var email = document.getElementById("form-email").value;
	
	$.ajax({
	    method: 'POST',
	    url: '/savejobseekeremail',
	    data: {email:email},
	    }).then(function(response){
	    	
	    	alert('inside success call back');
			//$rootScope.user = response.data;
		   // $state.transitionTo('/index');
		    //$scope.submitting = false;
		}, function errorCallback(response) {
			alert('inside failure call back');
			
			alert(response);
			alert(response.data)
			//$scope.submitting = false;
		}); */
	//post("/public/jobseeker/data", {hike:hike,salary: salary});

}
</script>
</body>
</html>