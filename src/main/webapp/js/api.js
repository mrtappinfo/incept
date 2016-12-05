var api = (function() {
	var timerReset;
	var apiFailed = false;
	$.support.cors = true;

	var _session = null;

	function prepareRequest(method, args) {
		//var session = getSession();
		var url;


		switch (method) {

		case "createRecruiterProfile":
			return {
			url: config.apiServer() + "recruiterform/Create",
			data: JSON.stringify(args),
			dataType: "json",
			contentType: 'application/json',
			type: "POST"
		};

		case "saveRise":
		return {
			url:  "/saveRise",
			data: JSON.stringify(args),
			dataType: "json",
			contentType: 'application/json',
			type: "POST"
		};
		
		default:
			alert("Error. Requested method is not implemented.");
		return null;
		}
	}

	


	function commonNetworkErrorCallback(externalCB, request) {
		return function(xhr, textStatus, errorThrown) {
			//reqTracker.del(request);

			// normalize error object:
			if (xhr.response) {
				xhr.status = xhr.response;
			}
			if (xhr.errorMessage) {
				xhr.statusText = xhr.errorMessage;
			} else if (xhr.message) {
				xhr.statusText = xhr.message;
			}

			if (!apiFailed) {
				apiFailed = true;
				var preventDefault = false;
				if (externalCB) {
					preventDefault = externalCB(xhr);
					if (typeof(preventDefault) != 'undefined' && preventDefault == false) {
						// default behavior:
							if ((xhr.status == 0 && xhr.statusText == 'error') || xhr.status == 504) {
								alert("An error occurred during connection to server.\n" + "Please check your Internet connection and try again.");
							} else if (xhr.status == 250 || xhr.status == 500 || xhr.status == 501 || xhr.status == 502 || xhr.status == 503 || xhr.status == 504 || xhr.status == 505 || xhr.status == 505 || xhr.status == 506 || xhr.status == 507 || xhr.status == 508 || xhr.status == 509 || xhr.status == 'failure') {
								alert(xhr.statusText);
								if (xhr.status == 250)
									location.reload();
							} else {}
					}
				} else
					alert("Application failed to process the request, please contact support");
			}
		};
	}

	// public api:
	return {
		/**
		 * Execute a server method with parameters
		 *
		 * @param method -
		 *            logical method name
		 * @param args -
		 *            arguments object
		 * @param successCb -
		 *            success callback
		 * @param errorCb -
		 *            error callback e.x.: api.execute("gatewayListGet", {userID:
		 *            123}, function(data){alert(data);}, function(){});
		 */
		execute: function(method, args, successCb, errorCb) {

			// translate method and arguments to jQuery request structure:
			var request = prepareRequest(method, args);
			if (!request)
				return null; // execution might be cancelled or UI redirected for

			var xhr;

			console.info('inside xhr............');
			if (request.url && request.type == "GET") {
				var index = request.url.indexOf('?');
				if (index != -1) {
					request.url = request.url.substring(0, index + 1) + "random=" + Math.random() + "&" + request.url.substring(index + 1, request.url.length);
				} else
					request.url = request.url + "?random=" + Math.random();
			}

			//Override the MIME type of the request
			request.beforeSend = function(xhr) {
				xhr.overrideMimeType("application/json; charset=UTF-8");
			};

			if (request.data) {
				console.info('inside request data............');
				request.contentType = "application/json; charset=utf-8";

				console.log(JSON.stringify(request));
				request.data = JSON.stringify(JSON.parse(request.data));
			}


			xhr = $.ajax(request);
		
			var xhrError = commonNetworkErrorCallback(errorCb, xhr);

			xhr.done(
					function(data, textStatus, xhr) {

						//alert(textStatus);

						//alert(JSON.stringify(data));

						// this is actually an error:
						if (((data === "undefined") || (data.statusCode !== undefined && data.statusCode != 0 && data.statusCode != 200 && data.statusCode != "success")) && (data.statusCode != 503 && data.statusCode != 502 && data.statusCode != 500 && data.statusCode != 250 && data.statusCode != 'failed')) {
							// this is actually an error:
							xhrError(data);
							return;
						}

						if (successCb) {

							if (data.errorMessage)
								data.message = data.errorMessage;

							if (data.status == 503 || data.errorCode == 503) {
								data.data = {};
								data.data["typ"] = "info";
								data.data["txt"] = (data.statusDetails) ? data.statusDetails : "No Data Available";

							} else if (data.status == 502 || data.errorCode == 502) {
								data.data = {};
								data.data["typ"] = "error";
								data.data["txt"] = (data.errorMessage) ? data.errorMessage : "Invalid Request Payload";

							} else if (data.status == 500 || data.status == 250 || data.errorCode == 500 || data.errorCode == 250) {
								data.data = {};
								data.data["typ"] = "error";
								data.data["txt"] = (data.errorMessage) ? data.errorMessage : "Application failed to process the request, please contact support";

							} else {
								
								data.data = {};
							    data.data["typ"] = "success";
								data.data["txt"] = data.statusDetail;
							}
							
							 console.info(data.data);
						
							 successCb(data.data, textStatus, xhr);
						}
					}).fail(xhrError);
		}


	};
})();
