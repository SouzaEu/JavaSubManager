package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.UsuarioNaoEncontradoException;
import br.com.fiap.model.Usuario;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UsuarioBO {

    private static final Logger LOGGER = Logger.getLogger(UsuarioBO.class.getName());
    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para registrar um novo usuário com validações
    public void registrarUsuario(Usuario usuario) throws SQLException, IllegalArgumentException {
        if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().isEmpty()) {
            throw new IllegalArgumentException("O nome completo é obrigatório.");
        }
        if (!validarEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("O email é inválido.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres.");
        }

        // Hash da senha antes de salvar no banco
        String senhaHash = hashSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);

        LOGGER.info("Registrando usuário com email: " + usuario.getEmail());

        Usuario usuarioExistente = usuarioDAO.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("O email já está em uso.");
        }

        usuarioDAO.inserir(usuario);
    }

    // Método para realizar a autenticação de um usuário
    public Usuario autenticarUsuario(String email, String senha) throws SQLException, UsuarioNaoEncontradoException {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha são obrigatórios.");
        }

        Usuario usuario = usuarioDAO.buscarPorEmail(email);
        if (usuario == null || !usuario.getSenha().equals(hashSenha(senha))) {
            throw new UsuarioNaoEncontradoException("Email ou senha incorretos.");
        }

        LOGGER.info("Usuário autenticado: " + email);
        return usuario;
    }

    // Buscar um usuário por ID
    public Usuario buscarPorId(int id) throws SQLException, UsuarioNaoEncontradoException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        LOGGER.info("Buscando usuário com ID: " + id);
        Usuario usuario = usuarioDAO.buscarPorId(id);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        return usuario;
    }

    // Atualizar as informações de um usuário
    public void atualizarUsuario(Usuario usuario) throws SQLException, IllegalArgumentException {
        if (usuario.getId() <= 0) {
            throw new IllegalArgumentException("ID de usuário inválido.");
        }
        if (!validarEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("O email é inválido.");
        }

        LOGGER.info("Atualizando informações do usuário com ID: " + usuario.getId());
        usuarioDAO.atualizar(usuario);
    }

    // Deletar um usuário
    public void deletarUsuario(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de usuário inválido.");
        }

        LOGGER.info("Deletando usuário com ID: " + id);
        usuarioDAO.deletar(id);
    }

    // Método para validar email
    private boolean validarEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    // Método para hash da senha
    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer hash da senha.", e);
        }
    }
}
