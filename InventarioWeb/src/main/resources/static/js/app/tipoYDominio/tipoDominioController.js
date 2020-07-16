'use strict';

angular.module('myApp').controller('TipoYDominioController',TipoYDominioController);

function TipoYDominioController($scope,$filter,$window,TipoYDominioService){
	
	var self = this;
	
	var headers = {
	    'Accept': 'application/json'
	};
	
	// listas
	self.listaTiposYDom = [];
	
	//parametros
	self.dataTipoDom = {
		descripcion:"",
		flag:""
	};
	
	self.regTipoDominio={
		flag:"",
		
			id:0,
			tipo:"",
			fecha:"2020-05-12"
		
	};
	
	self.currentPage = 0;
	self.pageSize = 10;
	self.q = '';
	
	// metodos
	self.listarTiposAndDom = listarTiposAndDom;
	self.initLoad = initLoad; 
	self.abrirDialogModif = abrirDialogModif;
	self.registrarTiposAndDominio = registrarTiposAndDominio;
	self.numberOfPages = numberOfPages;
	self.getData = getData;
	
	
	self.initLoad();
	
	function listarTiposAndDom(){
		TipoYDominioService.listarTiposAndDominios(headers).then(
			function(response){
				console.log(response);
				self.listaTiposYDom = response.listaTipoYDominio;
			}
		);
	}
	
	function initLoad(){
		self.listarTiposAndDom();
	}
	
	function registrarTiposAndDominio(){		
		console.log(self.regTipoDominio);
		
	TipoYDominioService.registrarTiposAndDominio(headers,
				self.regTipoDominio,{}).then(
		
			function(response){
				console.log(response);
				
				$("#Popup_guardar").modal('hide');
				
				self.regTipoDominio={
					flag:"",
						id:0,
						tipo:"",
						fecha:""
					
				};
				
				listarTiposAndDom();
			}
				
		);
	}
	
	function abrirDialogModif(data){
		console.log(data);
		console.log(data.id);
	
		
		$("#Popup_modif").modal({
			keyboard:true,
			show:true
		});
	}
	
	
	function numberOfPages(){
        return Math.ceil(self.getData().length/self.pageSize);                
    }
	
	function getData () {
		return $filter('filter')(self.listaTiposYDom)	
	}
	
}


myApp.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});
