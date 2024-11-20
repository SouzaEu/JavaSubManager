package br.com.fiap.bo;

import br.com.fiap.dao.AssinaturaDAO;
import br.com.fiap.model.Assinatura;

import java.sql.SQLException;
import java.util.logging.Logger;

public class AssinaturaBO {

    private static final Logger LOGGER = Logger.getLogger(AssinaturaBO.class.getName());
    private AssinaturaDAO assinaturaDAO;

    public AssinaturaBO() {
        this.assinaturaDAO = new AssinaturaDAO();
    }

    // Criar uma nova assinatura
    public void criarAssinatura(Assinatura assinatura) throws SQLException {
        if (assinatura.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("ID de usuário inválido.");
        }
        if (assinatura.getTipoPlano() == null || assinatura.getTipoPlano().isEmpty()) {
            throw new IllegalArgumentException("Tipo de plano é obrigatório.");
        }

        LOGGER.info("Criando assinatura para usuário ID: " + assinatura.getUsuarioId());
        assinaturaDAO.inserir(assinatura);
    }

    // Buscar uma assinatura por ID de usuário
    public Assinatura buscarAssinaturaPorUsuarioId(int usuarioId) throws SQLException {
        if (usuarioId <= 0) {
            throw new IllegalArgumentException("ID de usuário inválido.");
        }

        LOGGER.info("Buscando assinatura para usuário ID: " + usuarioId);
        Assinatura assinatura = assinaturaDAO.buscarPorId(usuarioId);
        if (assinatura == null) {
            LOGGER.warning("Nenhuma assinatura encontrada para o ID: " + usuarioId);
        }
        return assinatura;
    }

    // Atualizar assinatura
    public void atualizarAssinatura(Assinatura assinatura) throws SQLException {
        if (assinatura.getId() <= 0) {
            throw new IllegalArgumentException("ID de assinatura inválido.");
        }

        LOGGER.info("Atualizando assinatura ID: " + assinatura.getId());
        assinaturaDAO.atualizar(assinatura);
    }

    // Deletar assinatura
    public void deletarAssinatura(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de assinatura inválido.");
        }

        LOGGER.info("Deletando assinatura ID: " + id);
        assinaturaDAO.deletar(id);
    }
}
