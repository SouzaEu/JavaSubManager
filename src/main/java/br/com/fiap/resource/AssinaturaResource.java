package br.com.fiap.resource;

import br.com.fiap.bo.AssinaturaBO;
import br.com.fiap.exception.AssinaturaNaoEncontradaException;
import br.com.fiap.model.Assinatura;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/assinaturas")
public class AssinaturaResource {

    private AssinaturaBO assinaturaBO = new AssinaturaBO();

    // Criar uma nova assinatura
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarAssinatura(Assinatura assinatura) {
        try {
            assinaturaBO.criarAssinatura(assinatura);
            return Response.status(Response.Status.CREATED).entity(assinatura).build();
        } catch (SQLException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // Buscar assinatura por ID de usuário
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarAssinatura(@PathParam("id") int id) {
        try {
            Assinatura assinatura = assinaturaBO.buscarAssinaturaPorUsuarioId(id);
            if (assinatura == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Assinatura não encontrada.\"}")
                        .build();
            }
            return Response.ok(assinatura).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Erro interno ao buscar assinatura.\"}")
                    .build();
        }
    }

// Atualizar assinatura
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAssinatura(@PathParam("id") int id, Assinatura assinatura) {
        try {
            assinatura.setId(id);
            assinaturaBO.atualizarAssinatura(assinatura);
            return Response.ok().build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // Deletar assinatura
    @DELETE
    @Path("/{id}")
    public Response deletarAssinatura(@PathParam("id") int id) {
        try {
            assinaturaBO.deletarAssinatura(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
