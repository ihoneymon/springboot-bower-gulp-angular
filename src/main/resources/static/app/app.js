var myModule = angular.module('LearnAngular', []);

myModule.controller('ItemCtrl', function (ItemService) {
  var index = this;

  index.getItems = ItemService.getItems();
  index.createItem = function () {
    ItemService.getItems().push({
      title: 'new use',
      description: 'New This: Something',
      type: 'new'
    });
  }
});


myModule.service('ItemService', function () {
  var service = this,
    items = [{
      title: '1st use',
      description: 'First Story: bower',
      type: 'Package Manager'
		  }, {
      title: '2nd use',
      description: 'First Story: gulp',
      type: 'BuildTool'
		  }, {
      title: '3rd use',
      description: 'First Story: angular',
      type: 'MVVM Framework'
		  }];

  service.getItems = function () {
    return items;
  };
});

myModule.directive('item', function () {
  return {
    scope: true,
    replace: true,
    template: '<div><h4>{{item.title}}</h4><p>{{item.description}}</p></div>'
  }
});