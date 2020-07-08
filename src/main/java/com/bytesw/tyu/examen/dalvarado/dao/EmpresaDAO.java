package com.bytesw.tyu.examen.dalvarado.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bytesw.tyu.examen.dalvarado.model.Empresa;
import com.bytesw.tyu.examen.dalvarado.model.MethodResponse;

public class EmpresaDAO {
	
	public Empresa getEmpresa( long id ) throws SQLException {
		
		com.bytesw.tyu.examen.dalvarado.dbmanager.Connection dbm = new com.bytesw.tyu.examen.dalvarado.dbmanager.Connection();
		
		Empresa emp = new Empresa();
		
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = dbm.getConn();
			
			pstm = conn.prepareStatement("SELECT ID, NOMBRE, NIT, FUNDACION, DIRECCION FROM EMPRESA WHERE ID = ?");
			pstm.setLong(1, id);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				emp.setId(id);
				emp.setName(rs.getString("NOMBRE"));
				emp.setNit(rs.getString("NIT"));
				emp.setFundacion(rs.getDate("FUNDACION"));
				emp.setDireccion(rs.getString("DIRECCION"));
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs !=null)
				rs.close();
			
			if (pstm != null)
				pstm.close();
			
			if (conn != null)
				conn.close();
		}
		
		return emp;
	}
	
	public List<Empresa> getEmpresas() throws SQLException {
		
		com.bytesw.tyu.examen.dalvarado.dbmanager.Connection dbm = new com.bytesw.tyu.examen.dalvarado.dbmanager.Connection();
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = dbm.getConn();
			
			pstm = conn.prepareStatement("SELECT ID, NOMBRE, NIT, FUNDACION, DIRECCION FROM EMPRESA");
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Empresa emp = new Empresa();
				
				emp.setId(rs.getLong("ID"));
				emp.setName(rs.getString("NOMBRE"));
				emp.setNit(rs.getString("NIT"));
				emp.setFundacion(rs.getDate("FUNDACION"));
				emp.setDireccion(rs.getString("DIRECCION"));
				
				empresas.add(emp);
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs !=null)
				rs.close();
			
			if (pstm != null)
				pstm.close();
			
			if (conn != null)
				conn.close();
		}
		
		return empresas;
	}
	
    public MethodResponse deleteEmpresa( long id ) throws SQLException {
		
		com.bytesw.tyu.examen.dalvarado.dbmanager.Connection dbm = new com.bytesw.tyu.examen.dalvarado.dbmanager.Connection();
		
		MethodResponse res = new MethodResponse();
		
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = dbm.getConn();
			
			pstm = conn.prepareStatement("DELETE FROM EMPRESA WHERE ID = ?");
			pstm.setLong(1, id);
			
			if ( pstm.executeUpdate() > 0) {
				res.setCode("OK");
				res.setMessage("La empresa "+id+" ha sido eliminada exitosamente.");
			}else {
				res.setCode("ERROR");
				res.setMessage("La empresa "+id+" no ha podido ser eliminada.");
			}		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs !=null)
				rs.close();
			
			if (pstm != null)
				pstm.close();
			
			if (conn != null)
				conn.close();
		}
		
		return res;
	}
    
    public MethodResponse createEmpresa( Empresa emp ) throws SQLException {
		
		com.bytesw.tyu.examen.dalvarado.dbmanager.Connection dbm = new com.bytesw.tyu.examen.dalvarado.dbmanager.Connection();
		
		MethodResponse res = new MethodResponse();
		
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		int rs = 0;
		
		try {
			conn = dbm.getConn();
			
			pstm = conn.prepareStatement("INSERT INTO EMPRESA (NOMBRE, NIT, FUNDACION, DIRECCION) VALUES (?,?,?,?)");
			pstm.setString(1, emp.getName());
			pstm.setString(2, emp.getNit());
			pstm.setDate(3, new java.sql.Date(emp.getFundacion().getTime()));
			pstm.setString(4, emp.getDireccion());
			
			rs = pstm.executeUpdate();
			
			if (rs > 0) {
				
				res.setCode("OK");
				res.setMessage("Empresa creada exitosamente");
				
				Empresa tmp = new Empresa();
				
				tmp.setName(emp.getName());
				tmp.setNit(emp.getNit());
				tmp.setFundacion(emp.getFundacion());
				tmp.setDireccion(emp.getDireccion());
				
				res.setEmp(emp);
				
			} else {
				res.setCode("ERROR");
				res.setMessage("Error creando empresa");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (pstm != null)
				pstm.close();
			
			if (conn != null)
				conn.close();
		}
		
		return res;
	}
    
    public MethodResponse updateEmpresa( Long id, Empresa emp ) throws SQLException {
		
		com.bytesw.tyu.examen.dalvarado.dbmanager.Connection dbm = new com.bytesw.tyu.examen.dalvarado.dbmanager.Connection();
		
		MethodResponse res = new MethodResponse();
		
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		int rs = 0;
		
		try {
			conn = dbm.getConn();
			
			pstm = conn.prepareStatement("UPDATE EMPRESA SET NOMBRE=?, NIT=?, FUNDACION=?, DIRECCION=? WHERE ID = ?");
			pstm.setString(1, emp.getName());
			pstm.setString(2, emp.getNit());
			pstm.setDate(3, new java.sql.Date(emp.getFundacion().getTime()));
			pstm.setString(4, emp.getDireccion());
			pstm.setLong(5, id);
			
			rs = pstm.executeUpdate();
			
			if (rs > 0) {
				
				res.setCode("OK");
				res.setMessage("Empresa modificada exitosamente");
				
				Empresa tmp = new Empresa();
				
				tmp.setId(id);
				tmp.setName(emp.getName());
				tmp.setNit(emp.getNit());
				tmp.setFundacion(emp.getFundacion());
				tmp.setDireccion(emp.getDireccion());
				
				res.setEmp(emp);
				
			} else {
				res.setCode("ERROR");
				res.setMessage("Error modificando empresa");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (pstm != null)
				pstm.close();
			
			if (conn != null)
				conn.close();
		}
		
		return res;
	}

}
