carRentApp.controller('rentalController', function ($scope, $http, $state) {
    $scope.currentRentals = [];
    $scope.rentals = [];
    $scope.retData = {};

    $http.get('api/rentals').then(function (response) {
        $scope.rentals = response.data.rentals;
        $scope.currentRentals = response.data.currentRentals;

        for(var i = 0; i < $scope.rentals.length; i++){
            $scope.rentals[i].startTime = new Date($scope.rentals[i].startTime).toLocaleString();
            $scope.rentals[i].endTime = new Date($scope.rentals[i].endTime).toLocaleString();
        }

        for(var j = 0; j < $scope.currentRentals.length; j++){
            $scope.currentRentals[j].startTime = new Date($scope.currentRentals[j].startTime).toLocaleString();
        }

        $scope.rentals.reverse();
        $scope.currentRentals.reverse();
    });

    $scope.return = function (rentalId) {
        $http.post('api/return/' + rentalId, $scope.retData).then(function () {
            $state.reload();
        });
    };
});