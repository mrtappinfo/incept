'use strict';

var angular = require('angular');

// dataservice factory
angular
    .module('mdm.services')
    .factory('mdmDataService', dataservice);

dataservice.$inject = ['$http'];

function dataservice($http) {
  return {
    get: get,
    post: post
  };

  function get(req) {
    var req = {
      method: 'GET',
      url: req.url,
      params: req.params
    };

    return $http(req)
      .then(fetchCompleteSuccess)
      .catch(fetchCompleteFailed);

    function fetchCompleteSuccess(response) {
      return response.data;
    }

    function fetchCompleteFailed(error) {
      return error;
    }
  }

  function post(req) {
    var req = {
      method: 'POST',
      url: req.url,
      data: req.data
    };

    return $http(req)
      .then(submitCompleteSuccess)
      .catch(submitCompleteFailed);

    function submitCompleteSuccess(response) {
      return response.data;
    }

    function submitCompleteFailed(error) {
      logger.error('XHR Failed for getAvengers.' + error.data);
    }
  }
}
