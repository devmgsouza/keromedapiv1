package br.com.projetoa.bo;

import java.util.List;

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

public interface  DAO {
	
	public String SP_ATUALIZAR_STATUS_DOACAO(AtualizarStatusDoacao statusDoacao) throws AtualizarStatusDoacaoException;
	public List<BuscarDoacoes> SP_BUSCAR_DOACOES(String fb_id, int parametro, int tipo) throws BuscarDoacoesException;
	public Medicamento SP_BUSCAR_MEDICAMENTO_CODBARRAS(String codBarras) throws MedicamentoException;
	public List<Medicamento> SP_BUSCAR_MEDICAMENTO_CONTEXTUAL(String contexto) throws MedicamentoException;
	public List<MedicamentosDisponiveis> SP_BUSCAR_MEDICAMENTOS_DISPONIVEIS(List<String> fb_ids, int distancia) throws MedicamentosDisponiveisException;
	public String SP_CADASTRAR_USUARIO(Usuario usuario) throws UsuarioException;
	public String SP_DISPONIBILIZAR_MEDICAMENTO(DisponibilizarMedicamento medicamento) throws DisponibilizarMedicamentoException;
	public String SP_REGISTRAR_SOLICITACAO(RegistrarSolicitacao solicitacao) throws RegistrarSolicitacaoException;
	public String SP_BUSCAR_USUARIO(String fb_id) throws UsuarioException;
	public void SP_ATUALIZAR_TOKEN_FCM(Usuario usuario) throws UsuarioException;
	public String SP_ATUALIZAR_MEDICAMENTO_DISPONIVEL(MedicamentosDisponiveis medicamento) throws MedicamentosDisponiveisException;
	public String SP_ATUALIZAR_USUARIO(Usuario usuario) throws UsuarioException;
	
	
	public String SP_CADASTRA_USUARIOIN(UsuarioIndependente usuario, String fb_id) throws UsuarioIndependenteException;
	public List<UsuarioIndependente> SP_BUSCAR_USUARIOIN(String fb_id) throws UsuarioIndependenteException;
	public String SP_EXCLUIR_USUARIOIN(String fb_id, int pk_usuarioin) throws UsuarioIndependenteException;
	public String SP_ATUALIZAR_USUARIOIN(UsuarioIndependente usuario) throws UsuarioIndependenteException;
	

}
