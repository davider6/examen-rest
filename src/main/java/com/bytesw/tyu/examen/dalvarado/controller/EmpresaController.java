package com.bytesw.tyu.examen.dalvarado.controller;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bytesw.tyu.examen.dalvarado.dao.EmpresaDAO;
import com.bytesw.tyu.examen.dalvarado.model.Empresa;
import com.bytesw.tyu.examen.dalvarado.model.MethodResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/empresa")
@RequiredArgsConstructor
@Validated
public class EmpresaController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",
        produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public Empresa getEmpresa(
	    @PathVariable Long id)
	     {
		try {
			
			EmpresaDAO dao = new EmpresaDAO();
			
		    return dao.getEmpresa(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		    return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "",
	        produces = "application/json")
		@ResponseStatus(code = HttpStatus.OK)
		@ResponseBody
		public List<Empresa> getEmpresas()
		     {
			try {
				
				EmpresaDAO dao = new EmpresaDAO();
				
			    return dao.getEmpresas();
			}
			catch (Exception e) {
				e.printStackTrace();
			    return null;
			}
		}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "",
	        produces = "application/json")
		@ResponseStatus(code = HttpStatus.OK)
		@ResponseBody
		public MethodResponse deleteEmpresa(@PathVariable  Long id)
		     {
			try {
				
				EmpresaDAO dao = new EmpresaDAO();
				
			    return dao.deleteEmpresa(id);
			}
			catch (Exception e) {
				e.printStackTrace();
			    return null;
			}
		}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json",
    produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
		@ResponseBody
		public MethodResponse createEmpresa(@RequestBody Empresa emp)
		     {
			try {
				
				EmpresaDAO dao = new EmpresaDAO();
				
			    return dao.createEmpresa(emp);
			}
			catch (Exception e) {
				e.printStackTrace();
			    return null;
			}
		}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json",
		    produces = "application/json", value = "/{id}")
			@ResponseStatus(code = HttpStatus.OK)
				@ResponseBody
				public MethodResponse updateEmpresa(
						@PathVariable Long id,
						@RequestBody Empresa emp)
				     {
					try {
						
						EmpresaDAO dao = new EmpresaDAO();
						
					    return dao.updateEmpresa(id, emp);
					}
					catch (Exception e) {
						e.printStackTrace();
					    return null;
					}
				}

}
