carRentApp.controller('paymentController', function ($scope, $http, $state) {
    $scope.paymentAmount = undefined;

    $scope.performPayment = function () {
        if ($scope.paymentAmount === undefined) {
            $scope.paymentError = {message: 'You have to put some value in!'};
        } else if (isNaN($scope.paymentAmount.amount)) {
            $scope.paymentError = {message: 'This is not a number value!'};
        } else {
            $http.post('api/payment', $scope.paymentAmount).then(function () {
                $state.reload();
            });
        }
    };
});