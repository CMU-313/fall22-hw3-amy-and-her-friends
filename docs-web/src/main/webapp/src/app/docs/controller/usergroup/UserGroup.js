'use strict';

/**
 * User/group controller.
 */
angular
  .module('docs')
  .controller('UserGroup', function (Restangular, $scope, $state) {
    // Load users
    Restangular.one('user/list')
      .get({
        sort_column: 1,
        asc: true,
      })
      .then(function (data) {
        $scope.users = data.users;
      });

    // Load groups
    Restangular.one('group')
      .get({
        sort_column: 1,
        asc: true,
      })
      .then(function (data) {
        $scope.groups = data.groups;
      });

    // Open a user
    $scope.openUser = function (user) {
      $state.go('user.profile', { username: user.username });
    };

    // Open a group
    $scope.openGroup = function (group) {
      $state.go('group.profile', { name: group.name });
    };

    /**
     * Add a review.
     */
    $scope.addReview = function () {
      Restangular.one('review')
        .put($scope.review)
        .then(function (data) {
          $scope.reviews.push({
            id: data.id,
            applicant_name: $scope.review.applicantName,
            notes: $scope.review.notes,
            score: $scope.review.score,
          });
          $scope.review = { applicantName: '', notes: '', score: '1' };
        });
    };
  });
