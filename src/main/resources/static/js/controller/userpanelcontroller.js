carRentApp.controller('userPanelController', function ($scope, $state) {


    $scope.logout = function () {
        $state.go('/');
    };
});