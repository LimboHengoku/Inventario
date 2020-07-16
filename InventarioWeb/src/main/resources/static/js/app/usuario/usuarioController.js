'use strict';

angular.module('myApp').controller('UsuarioController', UsuarioController);

function UsuarioController($scope, $filter, $window, $http, $location,
		UsuarioService) {

	var self = this;

	var headers = {
		'Accept' : 'application/json'
	};

	// Objetos
	self.dataUser = {};

	// Listas
	self.usuarios = [];
	self.sedes = [];
	self.oficinas = [];
	self.divisiones = [];
	self.estados = [];

	// variables
	self.currentPage = 0;
	self.pageSize = 10;

	// Metodos
	self.initLoad = initLoad;
	self.listarUsuarios = listarUsuarios;
	self.listarEstados = listarEstados;
	self.numberOfPages = numberOfPages;
	self.getData = getData;
	self.abrirVentanaReg = abrirVentanaReg;
	self.abrirVentanaEditar = abrirVentanaEditar;
	self.verDispositivosVinculados = verDispositivosVinculados;
	self.listaUbicaciones = listaUbicaciones;
	self.registrarUsuario = registrarUsuario;
	self.actualizarUsuario = actualizarUsuario;
	self.limpiar = limpiar;

	// inicializar metodos
	self.initLoad();

	// Metodos

	function initLoad() {
		self.listarUsuarios();
		self.listaUbicaciones();
		self.limpiar();
	}

	function listarUsuarios() {
		UsuarioService.listarUsuarios(headers).then(function(response) {
			console.log(response);
			self.usuarios = response.usuarios;
		});
	}

	function listaUbicaciones() {
		UsuarioService.listarUbicaciones(headers).then(function(response) {
			self.sedes = response.sedes;
			self.oficinas = response.oficinas;
			self.divisiones = response.divisiones;
		});
	}

	function listarEstados() {
		UsuarioService.listarEstados(headers).then(function(response) {
			console.log(response);
			self.estados = response.estados;
		});
	}

	function numberOfPages() {
		return Math.ceil(self.getData().length / self.pageSize);
	}

	function getData() {
		return $filter('filter')(self.usuarios)
	}

	function abrirVentanaReg() {
		$('#lbl_titulo_mant').text("Registrar Usuario");
		$("#Popup_modif2").modal({
			keyboard : true,
			show : true
		});
		self.limpiar();
	}

	function abrirVentanaEditar(data) {
		console.log(data);

		self.dataUser = {
			usuario : {
				idUsuario : data.idUsuario,
				nombres : data.nombres,
				ape1 : data.ape1,
				ape2 : data.ape2,
				usuRed : data.usuRed,
				usuarioUbicacion : {
					ubicacionBean : {
						sedeBean : data.usuarioUbicacionBeans[0].ubicacionBean.sedeBean,
						divisionBean : data.usuarioUbicacionBeans[0].ubicacionBean.divisionBean,
						oficinaBean : data.usuarioUbicacionBeans[0].ubicacionBean.oficinaBean
					},
					condicionBean:{
						idCondicion:data.usuarioUbicacionBeans[0].condicionBean.idCondicion
					},
					dominioBean:{
						idDominio:data.usuarioUbicacionBeans[0].dominioBean.idDominio
					}
				},
				idDivision : data.usuarioUbicacionBeans[0].ubicacionBean.divisionBean.idDivision,
				idOficina : data.usuarioUbicacionBeans[0].ubicacionBean.oficinaBean.idOficina,
				idSede : data.usuarioUbicacionBeans[0].ubicacionBean.sedeBean.idSede
			}
		};

		$('#lbl_titulo_mant').text("Editar Usuario");
		
		$("#Popup_edi2").modal({
			keyboard : true,
			show : true
		});
	}

	function registrarUsuario() {

		var id = 0;

		if (self.dataUser.usuario.idUsuario == null) {
			console.log("sin id");
			id = 0;
		} else {
			console.log("con id");
			id = self.dataUser.usuario.idUsuario;
		}

		console.log(id);

		console.log(self.dataUser);

		 UsuarioService.registrarUsuario(headers,self.dataUser,{}).then(
			function(response){
				console.log(response);
			 });
		 
		 $("#Popup_modif2").modal('hide');
		 self.listarUsuarios();
	}
	
	function actualizarUsuario() {

		 UsuarioService.registrarUsuario(headers,self.dataUser,{}).then(
			function(response){
				console.log(response);
			 });
		 
		 $("#Popup_edi2").modal({
				keyboard : true,
				show : true
			});
		 
		 $("#Popup_edi2").modal('hide');
		 self.listarUsuarios();
	}

	function verDispositivosVinculados(data) {
		console.log(data);
	}

	function limpiar() {
		self.dataUser = {};
	}

}

myApp.filter('startFrom', function() {
	return function(input, start) {
		start = +start; // parse to int
		return input.slice(start);
	}
});
