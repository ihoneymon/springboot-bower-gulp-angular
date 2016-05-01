var myModule = angular.module('LearnAngular', []);

myModule.controller('IndexCtrl', function () {
  var index = this;

  index.useThings = [{
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
  
  index.createThings = function() {
	index.useThings.push({
	  title: 'new use',
	  description: 'New This: jqGrid',
	  type: 'grid'
	});
  };
});