northwind.controller("customerCtrl", function ($scope, northwindHttpFacade) {
  $scope.appTitle = "Northwind Restful Application";
  $scope.customer = {customerId:'abc', companyName:'company A', contactName:'Contact A'}
  $scope.customerId = "";
  
  $scope.getCustomerByCustomerId = function (customerId) {
    northwindHttpFacade.getCustomerByCustomerId(customerId)
      .success(function (data, status, headers, config) {
    	  $scope.customer = data;
    	  $scope.message = "The customer was retrieved successfully!";
      })
      .error (function (data, status, headers, config) {
    	  switch (status) {
    	    case 500: {
    		  $scope.message = "Server error!";
    		  break;
    	    }
    	  }
    	  console.log(data, status)
      })
  };
  
});
