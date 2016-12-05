<!DOCTYPE html>
<html lang="en" ng-app="snaplync">
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

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home" ng-controller="profileController">
<div class="page-wrap">
  <header id="siteheader">
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
          <a class="navbar-brand" href="index.html"><strong>InfoIncept</strong></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li class="login">Welcome <a href="#">LanaDig@gmail.com</a>
            </li>
          </ul>
          </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  <div class="main-content" >
    <div class="container">
      <div class="main-info" >
    
        <div class="infoshow"> Your Current  Compensation <span>{{jobseeker_salary}}</span>
        </div>
        <div class="infoshow"> Your requested hike  % <span>{{jobseeker_hike}}%</span>
        </div>
        <div class="infoshow"> Average Raise Possible <span>0%</span>
        </div>
        <div class="infoshow"> Max Salary Possible <span>{{maxSalaryPossible}}</span>
        </div>
      </div>
      <div class="rangebar" >
        <div class="range-bar">
          <div class="range-slider">
            <div class="spanvalue">
              <h2 class="rangetxt">My Salary <span class="range-slider__value mmg"> {{jobseeker_salary}</span> K</h2>
            </div>
            <input ng-model="user.salary" class="range-slider__range" type="range" value="0" min="0" max="280" step="1">
            <div class="number-range">
              <ul>
                <li>0K</li>
                <li>40K</li>
                <li>80K</li>
                <li>120K</li>
                <li>160K</li>
                <li>200K</li>
                <li>240K</li>
                <li>280K</li>
              </ul>
            </div>
          </div>
        </div>
        <!-- /.range-bar-->
        
        <div class="range-bar range2">
          <div class="range-slider">
            <div class="spanvalue">
              <h2 class="rangetxt">My new raise percentage <span class="range-slider__value mmg">{{jobseeker_hike}}</span>%</h2>
            </div>
            <input ng-model="user.hike" class="range-slider__range" type="range" value="0" min="0" max="100" step="1">
            <div class="number-range2">
             <ul>
                 <li>0%</li>
                <li>5%</li>
                <li>25%</li>
                <li>50%</li>
                <li>75%</li>
                <li>100%</li>
              </ul>
            </div>
          </div>
        </div>
        <!-- /.range-bar-->
        <div class="section-bottom-button text-center">
          <a href="" ng-click="sendrise()" class="btn btn-link-1">Submit Again</a>
        </div>	
      </div>
      <div class="search-result">
        <h3> Belows is your potential increase in compensation</h3>
      
      <div id ="elements"  class="searchset" ng-repeat="recruiter in recruiters track by $index">
          <h4> {{recruiter.recruiterName}}</h4>	
          <div class="progress">
            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow={{recruiter.averageHike}}
             aria-valuemin="0" aria-valuemax="100" style="width:{{recruiter.averageHike}}%"> {{recruiter.averageHike}}% </div>
          </div>
          <p>{{recruiter.recruiterCompanyName}}</p>
          <p><a href={{recruiter.recruiterLinkedInURL}} target="_blank">{{recruiter.recruiterLinkedInURL}}</a>
          </p>
          <p><strong>Hiring :</strong>  {{recruiter.recruiterName}}
          </p>
          <p><strong>For:</strong>  {{recruiter.recruiterIndustry1}}
          </p>
          <p><strong>Top Clients: </strong>   {{recruiter.recruiterClient1}}
          </p>
          <p><strong>Skills:</strong>   {{recruiter.recruiterSkill1}}
          </p>
          <p class="small-space">&nbsp;</p>
        
		  <p><strong>Accepting calls:</strong>
            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> {{recruiter.isAcceptingPhone}} </p>
            
          <p><strong>Accepting Resumes:</strong>
            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> {{recruiter.isActive}}</p>
          <p>
            <strong>Contact before:</strong> 
            <span class="infodate"></span> {{recruiter.recruiterExpirationDate}} </p>
          <p>
            <strong>Call :</strong> {{recruiter.recruiterPhoneNo}}
          </p>
          <div class="bottom-button ">
            <a class="btn btn-link-1" href="" ng-click="sendmessage('Immediately')">I am interested - Immediately </a>
            <a class="btn btn-link-1" href="" ng-click="sendmessage('Later')">Later - In few weeks</a>
            <a class="btn btn-link-1" href="" ng-click="sendmessage('No')">No - Not interested</a>
          </div>
        </div>
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
      <div class="col-sm-6">
        &copy; 2016 InfoIncept. All rights reserved. </div>
      <div class="col-sm-6 booton-links">
        <a  href="javascript:;">About</a>
        <a  href="javascript:;">Privacy Policy</a>
      </div>
    </div>
  </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script>
var rangeSlider = function(){
  var slider = $('.range-slider'),
     range = $('.range-slider__range') ,
      value = $('.range-slider__value');
    
  slider.each(function(){

   value.each(function(){
      var value = $(this).parents(".spanvalue").siblings(".range-slider__range").attr('value');
      $(this).html(value);
    });

    range.on('input', function(){
      $(this).siblings(".spanvalue").children(".rangetxt").children(value).html(this.value);
    });
  });
};

rangeSlider();

var recruiters = ${recruiters};
var jobseeker_hike = ${jobseeker_hike};
var jobseeker_salary = ${jobseeker_salary};
var maxSalaryPossible = ${maxSalaryPossible};


</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
    <script src="js/api.js"></script>
	<script src="js/appRoutes.js"></script>
	<script src="js/config.js"></script>
    <script src="js/profile.controller.js"></script> 
</body>
</html>