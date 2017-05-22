carRentApp.controller('carController', function ($scope, $http, $state) {
    $scope.cars = [];

    $http.get('api/cars').then(function (response) {
        $scope.cars = response.data;
    });

    $scope.rent = function (carId) {
        $http.put('api/rent/' + carId).then(function (response) {
            $state.reload();
        });
    };
});