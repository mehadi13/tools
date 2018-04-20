var app = angular.module("studentApp", []);
app.controller("studentController", function ($scope,$http) {
    var url = "http://localhost:8080";

    $http.get(url).success(function (response) {
        $scope.students = response;
    });
    // $scope.students = [
    //     {
    //         "Name": "Mahesh Parashar",
    //         "RollNo": 101,
    //         "Percentage": "80%"
    //     },

    //     {
    //         "Name": "Dinkar Kad",
    //         "RollNo": 201,
    //         "Percentage": "70%"
    //     },

    //     {
    //         "Name": "Robert",
    //         "RollNo": 191,
    //         "Percentage": "75%"
    //     },

    //     {
    //         "Name": "Julian Joe",
    //         "RollNo": 111,
    //         "Percentage": "77%"
    //     }
    // ];
    $scope.spice = 'very';

    $scope.chiliSpicy = function () {
        $scope.spice = 'chili';
    };

    $scope.list = [];
    $scope.submit = function () {
        console.log($scope.user);
        // if ($scope.text) {
        //     $scope.list.push(this);
        //     $scope.text = '';
        // }
    };
    // { id: 'choice1' }, { id: 'choice2' }
    $scope.choices = [];

    $scope.addNewChoice = function () {
        var newItemNo = $scope.choices.length + 1;
        $scope.choices.push({ 'id': 'choice' + newItemNo });
    };

    $scope.removeChoice = function () {
        var lastItem = $scope.choices.length - 1;
        $scope.choices.splice(lastItem);
    };

    $scope.formMode = true;
    $scope.changeMode = function () {
        $scope.formMode = $scope.formMode ? false : true;
    };
});