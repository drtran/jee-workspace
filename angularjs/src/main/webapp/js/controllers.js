parking.controller("customerCtrl", function ($scope) {
  $scope.appTitle = "Customer Information";
  $scope.customers = [
                 {customerId:'abc', companyName:'company A', contactName:'Contact A'},
                 {customerId:'bcd', companyName:'company B', contactName:'Contact B'},
                 {customerId:'cde', companyName:'company B', contactName:'Contact C'}];
  $scope.park = function (customer) {
    $scope.customers.push(customer);
    delete $scope.customer;
  };
});
