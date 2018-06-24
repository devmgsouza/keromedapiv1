package br.com.projetoa.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.projetoa.DAO.DAOImpl;
import br.com.projetoa.bo.DAO;
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


@Path("/resources")
public class Resources implements DAO {
	
	

	@GET
	public String get() {
		return "ok";
	}

	
	@POST
	@Path("/SP_ATUALIZAR_STATUS_DOACAO")
	@Override
	public String SP_ATUALIZAR_STATUS_DOACAO(AtualizarStatusDoacao arg0) throws AtualizarStatusDoacaoException {

		return new DAOImpl().SP_ATUALIZAR_STATUS_DOACAO(arg0);
	}

	@GET
	@Path("/SP_BUSCAR_DOACOES")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<BuscarDoacoes> SP_BUSCAR_DOACOES(@QueryParam("id") String fb_id, @QueryParam("parametro") int parametro,
			@QueryParam("tipo")int tipo) throws BuscarDoacoesException {
	
		return new DAOImpl().SP_BUSCAR_DOACOES(fb_id, parametro, tipo);
	}
	
	@GET
	@Path("/SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS_GERAL")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS_GERAL(@QueryParam("distancia")int max, 
			@QueryParam("latitude")double latitude, @QueryParam("longitude")double longitude, 
			@QueryParam("page") int lastid, @QueryParam("id") String id)
		throws MedicamentosDisponiveisException {
		return new DAOImpl().SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS_GERAL(max, latitude, 
				longitude, lastid, id);
	}
	
	@GET
	@Path("/SP_BUSCAR_DADOS_USUARIO")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario SP_BUSCAR_DADOS_USUARIO(@QueryParam("id") String fb_id, @QueryParam("email")String email) {
		return new DAOImpl().SP_BUSCAR_DADOS_USUARIO(fb_id, email);
	}
	
	@POST
	@Path("/SP_EFETUAR_LOGIN")
	@Produces(MediaType.TEXT_PLAIN)
	public int SP_EFETUAR_LOGIN(Usuario u) throws UsuarioException {
		
		return new DAOImpl().SP_EFETUAR_LOGIN(u);
	}
	
	@POST
	@Path("/SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(
			List<String> lista, @QueryParam("distancia") int distancia, 
			@QueryParam("latitude") double latitude, 
			@QueryParam("longitude") double longitude, 
			@QueryParam("page") int lastid) 
					throws MedicamentosDisponiveisException {
		
		return new DAOImpl().SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(lista, distancia, latitude, longitude, lastid);
		
	}
	
	@POST
	@Path("/SP_CADASTRAR_MEDICAMENTO")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String SP_CADASTRAR_MEDICAMENTO(Medicamento medicamento) {
		System.out.println("CADASTRAR_MEDICAMENTO");
		 return new DAOImpl().SP_CADASTRAR_MEDICAMENTO(medicamento);
	}
	
	@GET
	@Path("/SP_BUSCAR_MEUS_ITENS")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEUS_ITENS(@QueryParam("id") String id)
			throws MedicamentosDisponiveisException {

		return new DAOImpl().SP_BUSCAR_MEUS_ITENS(id);
	}

	@GET
	@Path("/SP_BUSCAR_MEDICAMENTO_CODBARRAS")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Medicamento SP_BUSCAR_MEDICAMENTO_CODBARRAS(@QueryParam("barcode")String arg0) throws MedicamentoException {
			System.out.println("arg0");
		return new DAOImpl().SP_BUSCAR_MEDICAMENTO_CODBARRAS(arg0);
	}
	
	@GET
	@Path("/SP_BUSCAR_MEDICAMENTO_CONTEXTUAL")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Medicamento> SP_BUSCAR_MEDICAMENTO_CONTEXTUAL(@QueryParam("contexto") String arg0) throws MedicamentoException {
		
		return new DAOImpl().SP_BUSCAR_MEDICAMENTO_CONTEXTUAL(arg0);
	}

	@POST
	@Path("/SP_CADASTRAR_USUARIO")
	@Override
	public String SP_CADASTRAR_USUARIO(Usuario arg0) throws UsuarioException {
		
		return new DAOImpl().SP_CADASTRAR_USUARIO(arg0);
	}

	@POST
	@Path("/SP_DISPONIBILIZAR_MEDICAMENTO")
	@Override
	public String SP_DISPONIBILIZAR_MEDICAMENTO(DisponibilizarMedicamento arg0)
			throws DisponibilizarMedicamentoException {
		
		return new DAOImpl().SP_DISPONIBILIZAR_MEDICAMENTO(arg0);
	}

	@POST
	@Path("/SP_REGISTRAR_SOLICITACAO")
	@Override
	public String SP_REGISTRAR_SOLICITACAO(RegistrarSolicitacao arg0) throws RegistrarSolicitacaoException {
		return new DAOImpl().SP_REGISTRAR_SOLICITACAO(arg0);
	}
	
	@Deprecated
	@Override
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(List<String> arg0v, int distancia)
			throws MedicamentosDisponiveisException {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/SP_BUSCAR_USUARIO")
	@Override
	public String SP_BUSCAR_USUARIO(@QueryParam("id") String arg0) throws UsuarioException {
		
		return new DAOImpl().SP_BUSCAR_USUARIO(arg0);
	}

	@POST
	@Path("/SP_ATUALIZAR_TOKEN_FCM")
	@Override
	public void SP_ATUALIZAR_TOKEN_FCM(Usuario arg0) throws UsuarioException {
		new DAOImpl().SP_ATUALIZAR_TOKEN_FCM(arg0);
		
	}

	@POST
	@Path("/SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL")
	@Override
	public String SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL(MedicamentosDisponiveis arg0)
			throws MedicamentosDisponiveisException {
		
		return new DAOImpl().SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL(arg0);
	}

	@POST
	@Path("/SP_ATUALIZAR_USUARIO")
	@Override
	public String SP_ATUALIZAR_USUARIO(Usuario arg0) throws UsuarioException {
		
		return new DAOImpl().SP_ATUALIZAR_USUARIO(arg0);
	}


	@POST
	@Path("/SP_ATUALIZAR_USUARIOIN")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public String SP_ATUALIZAR_USUARIOIN(UsuarioIndependente arg0) throws UsuarioIndependenteException {
		return new DAOImpl().SP_ATUALIZAR_USUARIOIN(arg0);
	}


	@GET
	@Path("/SP_BUSCAR_USUARIOIN")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<UsuarioIndependente> SP_BUSCAR_USUARIOIN(@QueryParam("id")String fb_id) throws UsuarioIndependenteException {
		return new DAOImpl().SP_BUSCAR_USUARIOIN(fb_id);
	}


	@POST
	@Path("/SP_CADASTRAR_USUARIOIN")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public String SP_CADASTRA_USUARIOIN(UsuarioIndependente arg0, @QueryParam("id")String arg1) throws UsuarioIndependenteException {
		return new DAOImpl().SP_CADASTRA_USUARIOIN(arg0, arg1);
	}


	@POST
	@Path("/SP_REGISTRAR_DOACAO")
	@Consumes(MediaType.APPLICATION_JSON)
	public String SP_REGISTRAR_DOACAO(RegistrarSolicitacao r) throws RegistrarSolicitacaoException{
		
		return new DAOImpl().SP_REGISTRAR_DOACAO(r);
	}
	
	
	@Override
	public String SP_EXCLUIR_USUARIOIN(String fb_id, int pk_usuarioin) throws UsuarioIndependenteException {
	
		return new DAOImpl().SP_EXCLUIR_USUARIOIN(fb_id, pk_usuarioin);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/SP_EXCLUIR_MEDICAMENTO")
	public boolean SP_EXCLUIR_MEDICAMENTO(@QueryParam("id") String fb_id, @QueryParam("pk")int pk_mmd) throws MedicamentoException {
		
		return new DAOImpl().SP_EXCLUIR_MEDICAMENTO(fb_id, pk_mmd);
	}



}
