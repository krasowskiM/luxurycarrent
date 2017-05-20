carRentApp.controller('rentalController', function ($scope, $http) {
    $scope.currentRental = undefined;
    $scope.rentals = [];

    $http.get('/rentals').then(function (response) {
        $scope.rentals = response.data.rentals;
        $scope.currentRental = response.data.currentRental;
        $scope.currentRental.startTime = new Date($scope.currentRental.startTime).toLocaleString();
        for(var i = 0; i < $scope.rentals.length; i++){
            $scope.rentals[i].startTime = new Date($scope.rentals[i].startTime).toLocaleString();
        }
    });

    $scope.return = function () {

    }
});