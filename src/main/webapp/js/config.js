var config = (function () {
	 console.info('config started............');
  //var context = 'http://ec2-54-174-72-242.compute-1.amazonaws.com:8080';
	// var context = 'http://localhost:8080';
    return {
    	apiServer: function () {
    		 return "/rest/";
           // return context + "/recruiter/rest/";
        }
    };
})();
