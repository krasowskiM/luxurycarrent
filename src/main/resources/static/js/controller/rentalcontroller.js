carRentApp.controller('rentalController', function ($scope, $http) {
    $scope.currentRental = undefined;
    $scope.rentals = [];

    $http.get('/rentals').then(function (response) {
        $scope.rentals = response.data;
    });
});