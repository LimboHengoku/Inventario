'use strict';

angular.module('myApp').factory('UsuarioService', UsuarioService);

function UsuarioService($http, $q){
	
	var URL_PRINCIPAL = 'http://192.168.1.11:8080/InventarioRest';
	
	var urlListarUsuario = URL_PRINCIPAL + '/usuario/listar';
	var urlListaUbicaciones = URL_PRINCIPAL + '/ubicacion/listar';
	var urlRegistrarUsuario = URL_PRINCIPAL + '/usuario/registrar';
	var urlListarEstados = URL_PRINCIPAL + '/estado/listar';
	
	var factory = {
		listarUsuarios:listarUsuarios,
		listarUbicaciones:listarUbicaciones,
		registrarUsuario:registrarUsuario
	};
	
	return factory;
	
	function listarUsuarios(_headers){
		var deferred = $q.defer();
		
		$http.get(urlListarUsuario,{
			headers:_headers
		}).then(
		   function(response){
			   deferred.resolve(response.data);
		   },
		   function(error){
			   console.log(error);
		   }
		);	
		
		return deferred.promise;
	}
	
	function listarUbicaciones(_headers){
		var deferred = $q.defer();
		
		$http.get(urlListaUbicaciones,{
			headers:_headers
		}).then(
		   function(response){
			   deferred.resolve(response.data);
		   },
		   function(error){
			   console.log(error);
		   }
		);		
		
		return deferred.promise;
	}
	
	function registrarUsuario(_headers,_data,_params){
		var deferred = $q.defer();
		
		$http.post(urlRegistrarUsuario,_data,{
			headers:_headers,
			params:_params
		}).then(
			function(response){
				deferred.resolve(response.data);
			},
			function(error){
				console.log(error);
			}
		);
		
		return deferred.promise;
	}
	
}