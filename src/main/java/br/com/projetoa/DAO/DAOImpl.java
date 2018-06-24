package br.com.projetoa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoa.CodeGenerator;
import br.com.projetoa.DistanciaEntrePontos;
import br.com.projetoa.PostMethod;
import br.com.projetoa.database.DatabaseAccess;
import br.com.projetoa.database.DatabaseAccessException;
import br.com.projetoa.model.AtualizarStatusDoacao;
import br.com.projetoa.model.BuscarDoacoes;
import br.com.projetoa.model.DisponibilizarMedicamento;
import br.com.projetoa.model.Medicamento;
import br.com.projetoa.model.MedicamentosDisponiveis;
import br.com.projetoa.model.RegistrarSolicitacao;
import br.com.projetoa.model.Usuario;
import br.com.projetoa.model.UsuarioIndependente;
import br.com.projetoa.model.exception.AtualizarStatusDoacaoException;
import br.com.projetoa.model.exception.BuscarDoacoesException;
import br.com.projetoa.model.exception.DisponibilizarMedicamentoException;
import br.com.projetoa.model.exception.MedicamentoException;
import br.com.projetoa.model.exception.MedicamentosDisponiveisException;
import br.com.projetoa.model.exception.RegistrarSolicitacaoException;
import br.com.projetoa.model.exception.UsuarioException;
import br.com.projetoa.model.exception.UsuarioIndependenteException;

public class DAOImpl implements br.com.projetoa.bo.DAO{
	private DatabaseAccess dbAccess = new DatabaseAccess();
	
	
	
	public int SP_EFETUAR_LOGIN(Usuario u)  throws UsuarioException{
		String SQL = "CALL SP_EFETUAR_LOGIN(?, ?)";
		Connection connection = null;	
		int retorno = 0;
	
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, u.getText_email());
			statment.setString(2, u.getText_password());
			
			
			ResultSet rs = statment.executeQuery();
			
			while(rs.next()) {
				retorno = rs.getInt("RETORNO");
			}	
			
			connection.close();
							
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}
			
			
		
		
		
		return retorno;
	}
	
	public Usuario SP_BUSCAR_DADOS_USUARIO(String fb_id, String email) {
		String SQL = "CALL SP_BUSCAR_DADOS_USUARIO(?, ?)";
		Connection connection = null;	
		Usuario u = new Usuario();
	
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, fb_id);
			statment.setString(2, email);
			
			
			ResultSet rs = statment.executeQuery();
			
			while(rs.next()) {
				
				u.setText_nome(rs.getString("text_nome"));
				u.setText_sobrenome(rs.getString("text_sobrenome"));
				u.setText_email(rs.getString("text_email"));
				u.setText_cidade(rs.getString("text_cidade"));
				u.setText_nm_rua(rs.getString("text_nm_rua"));
				u.setText_uf(rs.getString("text_uf"));
				u.setText_fone(rs.getString("text_fone"));
				u.setFb_id(rs.getString("fb_id"));
			}	
			
			connection.close();
							
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}
		
		return u;
	}
	
	@Override
	public String SP_ATUALIZAR_STATUS_DOACAO(AtualizarStatusDoacao a) throws AtualizarStatusDoacaoException {
		String SQL = "CALL SP_ATUALIZAR_STATUS_DOACAO(?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, a.getCodigo_validador());
			statment.setInt(2, a.getStatus_troca());
			statment.setInt(3, a.getQtd_doado());
			
			
			
			
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			System.out.println(retorno);
			
			
			/* SEND MESSAGE */
			List<String> gcmTokens = SP_BUSCAR_TOKEN_COD_VALIDADOR(a.getCodigo_validador());
			if (a.getStatus_troca() == 1) {
				String token_id = gcmTokens.get(1);
				new PostMethod(token_id, 1).sendRequest();
				
			} else if (a.getStatus_troca() == 2) {
				String token_id = gcmTokens.get(0);
				new PostMethod(token_id, 2).sendRequest();
				
			} else if(a.getStatus_troca() == 3) {
				String token_id_receptor = gcmTokens.get(1);
				String token_id_doador = gcmTokens.get(0);
				new PostMethod(token_id_receptor, 3).sendRequest();
				new PostMethod(token_id_doador, 3).sendRequest();
				
			}
			/* SEND MESSAGE */
			
			
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		
		System.out.println(retorno);
		return retorno;
	}

	@Override
	public List<BuscarDoacoes> SP_BUSCAR_DOACOES(String fb_id, int parametro, int tipo) throws BuscarDoacoesException {
		String SQL = "CALL SP_BUSCAR_DOACOES(?,?,?)";
		List<BuscarDoacoes> lista = new ArrayList<BuscarDoacoes>();
		Connection connection = null;
		
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, fb_id);
			statment.setInt(2, parametro);
			statment.setInt(3, tipo);
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				BuscarDoacoes doacoes = new BuscarDoacoes();
				doacoes.setPk_mmd(rs.getInt("pk_mmd"));
				doacoes.setStatus_troca(rs.getString("status_troca"));
				doacoes.setCodigo_validador(rs.getString("codigo_validador"));
				doacoes.setText_nome_comercial(rs.getString("text_nome_comercial"));
				doacoes.setQtd_solicitado(rs.getInt("qtd_solicitado"));
				doacoes.setTipo_medicamento(rs.getString("tipo_medicamento"));
				doacoes.setData_solicitacao(rs.getString("data_solicitacao"));
				doacoes.setData_troca_efetivada(rs.getString("data_troca_efetivada"));
				doacoes.setFb_id_doador(rs.getString("fb_id_doador"));
				doacoes.setLatitude(rs.getDouble("latitude"));
				doacoes.setLongitude(rs.getDouble("longitude"));
				doacoes.setText_observacao(rs.getString("text_obs"));
				lista.add(doacoes);
			}
			 
			connection.close();
		
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
		}
		
		
		
		
		return lista;
	}
	
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(List<String> lista_id, int distancia, double latitude, double longitude, int lastId)
	
			throws MedicamentosDisponiveisException {
			String SQL = "CALL SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(?,?,?,?,?)";
			List<MedicamentosDisponiveis> lista = new ArrayList<MedicamentosDisponiveis>();
			
			Connection connection = null;
		
			for (int i = 0; i < lista_id.size(); i++) {
			
			try {
				
				connection = dbAccess.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				statment.setString(1, lista_id.get(i));
				statment.setDouble(2, latitude);
				statment.setDouble(3, longitude);
				statment.setInt(4, distancia);
				statment.setInt(5, lastId);
				
				System.out.println(statment);
				 ResultSet rs = statment.executeQuery();
				 while(rs.next()) {
					 MedicamentosDisponiveis medicamento = new MedicamentosDisponiveis(
							 rs.getInt("pk_mmd"),
							 rs.getString("text_nome_comercial"),
							 rs.getString("text_apresentacao"),
							 rs.getString("nr_ean"),
							 rs.getDouble("latitude"),
							 rs.getDouble("longitude"),
							 rs.getString("data_validade"),
							 rs.getInt("qtd_disponivel"),
							 rs.getString("tipo_medicamento"),
							 rs.getString("text_principio_ativo"),
							 rs.getString("text_laboratorio"),
							 0
							  );
					 medicamento.setDistancia(
							 new DistanciaEntrePontos().calcularDistancia(latitude, longitude, medicamento.getLatitude(), medicamento.getLongitude(), 900, 900));
							lista.add(medicamento);		 
				 } 
				connection.close();
			
			} catch (SQLException e) {
				System.err.println(e.getMessage() + ", " + e.getCause());
			    
			} catch (DatabaseAccessException e) {
				 System.err.println(e.getMessage() + ", " + e.getCause());
			}
			
			}
			
			return lista;

	}

	@Override
	public Medicamento SP_BUSCAR_MEDICAMENTO_CODBARRAS(String c) throws MedicamentoException {
		String SQL = "CALL SP_BUSCAR_MEDICAMENTO_CODBARRAS(?)";
		Connection connection = null;	
	
		Medicamento medicamento = null;
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, c);
			
			ResultSet rs = statment.executeQuery();
			
			while(rs.next()) {
					medicamento = new Medicamento(
							rs.getInt("pk_medicamento"),
							rs.getString("text_nome_comercial"),
							rs.getString("text_principio_ativo"),
							rs.getString("text_laboratorio"),
							rs.getString("text_tarja"),
							rs.getString("text_apresentacao"),
							rs.getString("nr_ean"),
							rs.getString("text_classe"),
							rs.getString("url_imagem")
							);
			}	
			
			connection.close();
							
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}
			
			
		return medicamento;
	}

	@Override
	public List<Medicamento> SP_BUSCAR_MEDICAMENTO_CONTEXTUAL(String c) throws MedicamentoException {
		String SQL = "CALL SP_BUSCAR_MEDICAMENTO_CONTEXTUAL(?)";
		Connection connection = null;	
		List<Medicamento> lista = new ArrayList<>();
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, c);
			
			ResultSet rs = statment.executeQuery();
			
			while(rs.next()) {
					Medicamento medicamento = new Medicamento(
							0,
							rs.getString("text_nome_comercial"),
							null,
							null,
							null,
							rs.getString("text_apresentacao"),
							rs.getString("nr_ean"),
							null,
							null
							);
					
					lista.add(medicamento);
			}	
			
			connection.close();
							
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}
			
			
		return lista;
	}

	@Override
	public String SP_CADASTRAR_USUARIO(Usuario u) throws UsuarioException {
		String SQL = "CALL SP_CADASTRAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, u.getText_nome());
			statment.setString(2, u.getText_sobrenome());
			statment.setString(3, u.getText_cpf());
			statment.setString(4, u.getText_cnpj());
			statment.setString(5, u.getText_razao_social());
			statment.setString(6, u.getText_nm_rua());
			statment.setDouble(7, u.getLatitude());
			statment.setDouble(8, u.getLongitude());
			statment.setString(9, u.getText_email());
			statment.setString(10, u.getText_fone());
			statment.setString(11, u.getText_nr_residencia());
			statment.setString(12, u.getText_cidade());
			statment.setString(13, u.getText_uf());
			
			if (u.getFb_id().equals("#null")) {
				retorno = new CodeGenerator().GerarCodigoRand(64);
				statment.setString(14, retorno);
			} else {
				statment.setString(14, u.getFb_id());
			}
			
			if (u.getData_nascimento().equals("#null")) {
				statment.setString(15, null);
			} else {
				statment.setString(15, u.getData_nascimento());
			}
			statment.setString(16, u.getToken_gcm());
			statment.setInt(17, u.getTipo_conta());
			statment.setString(18, u.getText_password());
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			
			
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = "ERRO";
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = "ERRO";
		}
		
		
		
		return retorno;
	}

	@Override
	public String SP_DISPONIBILIZAR_MEDICAMENTO(DisponibilizarMedicamento d)
			throws DisponibilizarMedicamentoException {
		
		String SQL = "CALL SP_DISPONIBILIZAR_MEDICAMENTO(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, d.getFb_id());
			statment.setInt(2, d.getFk_medicamento());
			statment.setInt(3, d.getQtd_disponivel());
			statment.setDouble(4, d.getNr_valor_unit());
			statment.setString(5, d.getData_validade());
			statment.setInt(6, d.getTipo_medicamento());
			statment.setDouble(7, d.getLatitude());
			statment.setDouble(8, d.getLongitude());
			statment.setString(9, d.getText_observacao());


			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
				
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		} 
		
		System.out.println(retorno);
	
		
		return retorno;
	}
	
	@Override
	public String SP_REGISTRAR_SOLICITACAO(RegistrarSolicitacao s) throws RegistrarSolicitacaoException {
		String SQL = "CALL SP_REGISTRAR_SOLICITACAO(?,?,?,?,?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, s.getFb_id_solicitante());
			statment.setInt(2, s.getFk_medicamento_solicitado());
			statment.setInt(3, s.getQtd_solicitado());
			statment.setString(4, new CodeGenerator().GerarCodigoRand(6));
			statment.setDouble(5, s.getNr_valor());
			statment.setDouble(6, s.getLatitude());
			statment.setDouble(7, s.getLongitude());
	
			
			
			ResultSet rs = statment.executeQuery();
			System.out.println(statment);
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
				
			}
			if (retorno.equals("SOLICITAÇÃO ENVIADA")) {
				
				String token_id = SP_BUSCAR_TOKEN_USUARIO(s.getFk_medicamento_solicitado());
				
				new PostMethod(token_id, 0).sendRequest();
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		} catch (UsuarioException e) {
				System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		
		System.out.println(retorno);
	
		
		return retorno;
	}

	@Override
	public String SP_BUSCAR_USUARIO(String u) throws UsuarioException {
		String SQL = "CALL SP_BUSCAR_USUARIO(?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, u);
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("count");
			}
				connection.close();	
			} catch (SQLException e) {	
					System.err.println(e.getMessage() + ", " + e.getCause());
					retorno = e.getMessage();
				    
			} catch (DatabaseAccessException e) {
					 System.err.println(e.getMessage() + ", " + e.getCause());
					 retorno = e.getMessage();
			}
				
		return retorno;
	}

	@Override
	public void SP_ATUALIZAR_TOKEN_FCM(Usuario u) throws UsuarioException {
		String SQL = "CALL SP_ATUALIZAR_TOKEN_FCM(?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, u.getFb_id());
			statment.setString(2, u.getToken_gcm());
			
			System.out.println(statment);
			statment.executeQuery();
			retorno = "1";
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		System.out.println(retorno);
	}

	/**
	 * 
	 * @param pk_mmd
	 * @return
	 * @throws UsuarioException
	 */
	private String SP_BUSCAR_TOKEN_USUARIO(int arg0) throws UsuarioException {
		String SQL = "CALL SP_BUSCAR_TOKEN_USUARIO(?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setInt(1, arg0);
		
	
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("token_gcm");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}

	
		
		return retorno;
	}

	/**
	 * 
	 * @param Codigo Validador
	 * @return
	 * @throws UsuarioException
	 */
	private List<String> SP_BUSCAR_TOKEN_COD_VALIDADOR(String codigo) {
		String SQL = "CALL SP_BUSCAR_TOKEN_COD_VALIDADOR(?)";
		Connection connection = null;	
		
		List<String> retorno = new ArrayList<>();
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, codigo);
		
	
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno.add(rs.getString("token_doador"));
				retorno.add(rs.getString("token_receptor"));
				
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}

		return retorno;
	}

	@Override
	public String SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL(MedicamentosDisponiveis u)
			throws MedicamentosDisponiveisException {
		String SQL = "CALL SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL(?,?, ?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setInt(1, u.getPk_mmd());
			statment.setString(2, u.getData_validade());
			statment.setInt(3, u.getQtd_disponivel());
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		System.out.println(retorno);
		return retorno;
	}
	
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS_GERAL(int max, double latitude, 
			double longitude, int lastid, String id)
		throws MedicamentosDisponiveisException {
		String SQL = "CALL SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS_GERAL(?, ?, ?, ?, ?)";
		List<MedicamentosDisponiveis> lista = new ArrayList<MedicamentosDisponiveis>();
		
		Connection connection = null;
	
	
		
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setDouble(1, latitude);
			statment.setDouble(2, longitude);
			statment.setInt(3, max);
			statment.setInt(4,  lastid);
			statment.setString(5, id);
			System.out.println(statment);
			 ResultSet rs = statment.executeQuery();
			 while(rs.next()) {
				 MedicamentosDisponiveis medicamento = new MedicamentosDisponiveis(
						 rs.getInt("pk_mmd"),
						 rs.getString("text_nome_comercial"),
						 rs.getString("text_apresentacao"),
						 rs.getString("nr_ean"),
						 rs.getDouble("latitude"),
						 rs.getDouble("longitude"),
						 rs.getString("data_validade"),
						 rs.getInt("qtd_disponivel"),
						 rs.getString("tipo_medicamento"),
						 rs.getString("text_principio_ativo"),
						 rs.getString("text_laboratorio"),
						 0
						  );
				 medicamento.setDistancia(
						 new DistanciaEntrePontos().calcularDistancia(latitude, longitude, medicamento.getLatitude(), medicamento.getLongitude(), 900, 900));
				 if (medicamento.getDistancia() <= max) {
					 lista.add(medicamento); 
				 }					 
			 } 
			connection.close();
		
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
		}
		
		
		
		return lista;
	}
	
 	public List<MedicamentosDisponiveis> SP_BUSCAR_MEUS_ITENS(String id)
			throws MedicamentosDisponiveisException {
		String SQL = "CALL SP_BUSCAR_MEUS_ITENS(?)";
		List<MedicamentosDisponiveis> lista = new ArrayList<MedicamentosDisponiveis>();
		
		Connection connection = null;
	
	
		
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, id);
			
			ResultSet rs = statment.executeQuery();
			 while(rs.next()) {
				 MedicamentosDisponiveis medicamento = new MedicamentosDisponiveis(
						 rs.getInt("pk_mmd"),
						 rs.getString("text_nome_comercial"),
						 rs.getString("text_apresentacao"),
						 rs.getString("nr_ean"),
						 rs.getDouble("latitude"),
						 rs.getDouble("longitude"),
						 rs.getString("data_validade"),
						 rs.getInt("qtd_disponivel"),
						 rs.getString("tipo_medicamento"),
						 rs.getString("text_principio_ativo"),
						 rs.getString("text_laboratorio"),
						 0
						  );
				 lista.add(medicamento);				 
			 } 
			 System.out.println(lista.size());
			connection.close();
		
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
		}
		

		
		return lista;
	}

	@Override
	public String SP_ATUALIZAR_USUARIO(Usuario u) throws UsuarioException {
		String SQL = "CALL SP_ATUALIZAR_USUARIO(?,?,?,?,?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, u.getFb_id());
			statment.setString(2, u.getText_nr_residencia());
			statment.setString(3, u.getText_nm_rua());
			statment.setString(4, u.getText_cidade());
			statment.setString(5, u.getText_fone());
			statment.setString(6, u.getText_uf());
			statment.setString(7, u.getText_email());
			
			System.out.println(statment);
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		System.out.println(retorno);
		return retorno;
	}

	@Deprecated
	@Override
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(List<String> arg0, int arg1)
			throws MedicamentosDisponiveisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SP_ATUALIZAR_USUARIOIN(UsuarioIndependente arg0) throws UsuarioIndependenteException {
		
		return null;
	}

	@Override
	public List<UsuarioIndependente> SP_BUSCAR_USUARIOIN(String arg0) throws UsuarioIndependenteException {
		List<UsuarioIndependente> lista = new ArrayList<>();
		String SQL = "CALL SP_BUSCAR_USUARIOIN(?)";
		Connection connection = null;	
	
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, arg0);
	
			
			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				UsuarioIndependente u = new UsuarioIndependente();
				u.setNomeCompleto(rs.getString("text_nomecompleto"));
				/*
				u.setEndereco(rs.getString("text_endereco"));
				u.setDataNascimento(rs.getString("data_nascimento"));
				u.setCpf(rs.getString("text_cpf"));
				u.setRg(rs.getString("text_rg"));
				u.setCidade(rs.getString("text_cidade"));
				u.setUf(rs.getString("text_uf"));
				u.setFk_usuario(rs.getInt("fk_usuario"));
				*/
				u.setPk_usuarioin(rs.getInt("pk_usuarioin"));
				lista.add(u);
			}
			connection.close();
			
			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			
		}
		
		return lista;
	}

	@Override
	public String SP_CADASTRA_USUARIOIN(UsuarioIndependente u, String fb_id) throws UsuarioIndependenteException {
		String SQL = "CALL SP_CADASTRAR_USUARIOIN(?,?,?,?,?,?,?,?,?, ?)";
		Connection connection = null;	
		String retorno = "NÃO FOI POSSÍVEL REALIZAR O CADASTRO";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, fb_id);
			statment.setString(2, u.getNomeCompleto());
			statment.setString(3, u.getEndereco());
			
			if (u.getDataNascimento().equals("__/__/____")) {
				statment.setString(4, null);
			} else {
				statment.setString(4, u.getDataNascimento());
			}
			
			
			statment.setString(5, u.getCpf());
			statment.setString(6, u.getRg());
			statment.setString(7, u.getTelefone());
			statment.setString(8, u.getCidade());
			statment.setString(9, u.getUf());
			statment.setString(10, u.getIdade());
			
			ResultSet rs = statment.executeQuery();
			System.out.println("statment");
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			connection.close();
			
		
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
		
		}
		System.out.println(retorno);
		return retorno;

	}

	@Override
	public String SP_EXCLUIR_USUARIOIN(String arg0, int arg1) throws UsuarioIndependenteException {		
	String SQL = "CALL SP_EXCLUIR_USUARIOIN(?,?)";
	Connection connection = null;	
	String retorno = "0";
	try {
		
		connection = dbAccess.getConnection();
		PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
		statment.setString(1, arg0);
		statment.setInt(2, arg1);
		
		ResultSet rs = statment.executeQuery();
		while(rs.next()) {
			retorno = rs.getString("RETORNO");
		}
		connection.close();
		
	} catch (SQLException e) {
		System.err.println(e.getMessage() + ", " + e.getCause());
		retorno = e.getMessage();
	    
	} catch (DatabaseAccessException e) {
		 System.err.println(e.getMessage() + ", " + e.getCause());
		 retorno = e.getMessage();
	}
	System.out.println(retorno);
	return retorno;
}
	
	public String SP_REGISTRAR_DOACAO(RegistrarSolicitacao r) throws RegistrarSolicitacaoException{
		String SQL = "CALL SP_REGISTRAR_DOACAO(?,?,?,?,?,?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, r.getTokenfb_doador());
			statment.setInt(2, r.getFk_medicamento_solicitado());
			statment.setInt(3, r.getQtd_solicitado());
			statment.setString(4, new CodeGenerator().GerarCodigoRand(6));
			statment.setDouble(5, r.getNr_valor());
			statment.setDouble(6, r.getLatitude());
			statment.setDouble(7, r.getLongitude());
			statment.setInt(8, r.getFk_usuarioin());

			
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		System.out.println(retorno);
		
		return retorno;
	
		
	}

	public String SP_CADASTRAR_MEDICAMENTO(Medicamento m) {
		String SQL = "CALL SP_CADASTRAR_MEDICAMENTO(?,?,?,?,?,?,?,?)";
		Connection connection = null;	
		String retorno = "0";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, m.getText_nome_comercial());
			statment.setString(2, m.getText_principio_ativo());
			statment.setString(3, m.getText_laboratorio());
			statment.setString(4, m.getText_apresentacao());
			statment.setString(5, m.getText_tarja());
			if (m.getNr_ean().equals("") || m.getNr_ean() == null) {
				statment.setString(6, new CodeGenerator().GerarCodigoRand(10));
			} else {
				statment.setString(6, m.getNr_ean());
			}			
			
			statment.setString(7, m.getText_classe());
			statment.setString(8, m.getUrl_image());

			System.out.println(statment);
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				retorno = rs.getString("RETORNO");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			retorno = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 retorno = e.getMessage();
		}
		System.out.println(retorno);
		
		return retorno;
	}
	
	
	public boolean SP_EXCLUIR_MEDICAMENTO(String fb_id, int pk_mmd) throws MedicamentoException {
		String SQL = "CALL SP_EXCLUIR_MEDICAMENTO(?,?)";
		Connection connection = null;	
		boolean retorno = false;
		String mensagem = "";
		try {
			
			connection = dbAccess.getConnection();
			PreparedStatement statment = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statment.setString(1, fb_id);
			statment.setInt(2, pk_mmd);
		
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				mensagem = rs.getString("RETORNO");
			}
			connection.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + ", " + e.getCause());
			mensagem = e.getMessage();
		    
		} catch (DatabaseAccessException e) {
			 System.err.println(e.getMessage() + ", " + e.getCause());
			 mensagem = e.getMessage();
		}

		if(mensagem.equals("CADASTRO ATUALIZADO")) {
			retorno = true;
		}
		
		
		return retorno;
		
	}


	
	
}
