carRentApp.controller('carController', function ($scope, $http) {
    $scope.cars = [];

    $http.get('/cars').then(function (response) {
        $scope.cars = response.data;
    });

    $scope.rent = function (carId) {
        $http.put('/rent/' + carId).then(function (response) {

        });
    }
});