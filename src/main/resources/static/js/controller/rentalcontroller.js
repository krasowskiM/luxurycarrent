carRentApp.controller('rentalController', function ($scope, $http) {
    // $scope.currentRental = undefined;
    $scope.rentals = [];

    $http.get('api/rentals').then(function (response) {
        $scope.rentals = response.data.rentals;
        if(response.data.currentRental.rentalId !== 0){
            $scope.currentRental = response.data.currentRental;
            $scope.currentRental.startTime = new Date($scope.currentRental.startTime).toLocaleString();
        }
        for(var i = 0; i < $scope.rentals.length; i++){
            $scope.rentals[i].startTime = new Date($scope.rentals[i].startTime).toLocaleString();
            $scope.rentals[i].endTime = new Date($scope.rentals[i].endTime).toLocaleString();
        }
    });

    $scope.return = function (rentalId) {
        $http.post('api/return/' + rentalId).then(function () {

        });
    }
});