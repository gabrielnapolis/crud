package com.imob.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imob.util.ConnectionFactory;

public class ImobDAO extends ConnectionFactory {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void inserir(Imob a1) {
		String sql = "INSERT INTO imod (id, cidade, setor, descricao, valor) VALUES (?, ?, ?, ?, ?)";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, a1.getId());
			ps.setString(2, a1.getCidade());
			ps.setString(3, a1.getSetor());
			ps.setString(4, a1.getDescricao());
			ps.setFloat(5, a1.getValor());
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
	}

	public List<Imob> listar() {
		List<Imob> listImob = null;
		String sql = "SELECT id, cidade, setor, descricao, valor FROM imob ORDER BY id";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listImob = new ArrayList<Imob>();
			while (rs.next()) {
				Imob m = new Imob();
				m.setId(rs.getInt("id"));
				m.setCidade(rs.getString("cidade"));
				m.setSetor(rs.getString("setor"));
				m.setDescricao(rs.getString("descricao"));
				m.setValor(rs.getFloat("valor"));
				listImob.add(m);
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
		return listImob;
	}

	public void delete(Imob m) {
		String sql = "DELETE FROM imob WHERE id = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, m.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
	}

	public void update(Imob m) {
		String sql = "UPDATE imob SET cidade = ?, setor = ?," + " descricao = ?, valor = ? WHERE id = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getCidade());
			ps.setString(2, m.getSetor());
			ps.setString(3, m.getDescricao());
			ps.setFloat(4, m.getValor());
			ps.setLong(5, m.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}

	}

	public Imob selectByID(Long id){
		Imob m = null;
		String sql = "SELECT id, cidade, setor, descricao, valor "
					+ "FROM imob WHERE id = ?";
					
			try {
				con = getConnection();
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				rs = ps.executeQuery();
				m = new Imob();
				
				if(rs.next()){
					m.setId(rs.getInt("id"));
					m.setCidade(rs.getString("cidade"));
					m.setSetor(rs.getString("setor"));
					m.setDescricao(rs.getString("descricao"));
					m.setValor(rs.getFloat("valor"));
				}	
		
			}catch(Exception e){
				System.err.println("---------------------");
				System.err.println("Erro: " + e.getMessage());
				e.printStackTrace();
				System.err.println("---------------------");
			}
			return m;
		}

	}
