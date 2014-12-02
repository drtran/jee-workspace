northwind.factory("northwindHttpFacade", function ($http) {
  var _getCustomerByCustomerId = function(customerId) {
	  return $http.get("/MongoRS/services/customers/" + customerId);
  };
  
  return {
	  getCustomerByCustomerId: _getCustomerByCustomerId
  }
});