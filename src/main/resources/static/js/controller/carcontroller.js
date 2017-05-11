carRentApp.controller('carController', function ($scope, $http) {
    $scope.cars = [];

    $http.get('/cars', function (response) {
        $scope.cars = response.data;
    })
});