package com.anacleto.paths;

import com.anacleto.persistence.model.Pessoa;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Path("/pessoa")
public class PessoaPath {

    /* com mapa
    private static final Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
    static {
        pessoas.put(1, new Pessoa("Jose Antonio"));
        pessoas.put(2, new Pessoa("Anderson James"));
        pessoas.put(3, new Pessoa("Silva Pereira"));
    } */


    private List<Pessoa> pessoas;

    {
        pessoas = asList(new Pessoa("Jose Antonio"), new Pessoa("Anderson James"), new Pessoa("Silva Pereira"));
    }

    @GET
    @Path("oi")
    @Produces("application/json")
    public Response oi() {
        return Response.ok(new Gson().toJson("Hello World")).build();

        // the return bellow does not require @Produces annotation
        //return Response.status(Response.Status.OK).entity("Hello World second method").type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("listar")
    @Produces("application/json")
    public Response listar() {
        return Response.ok(new Gson().toJson(pessoas)).build();
    }

    @GET
    @Path("buscar/{nome}")
    @Produces("application/json")
    public Response buscar(@PathParam("nome") String nome){
        int index = pessoas.indexOf(new Pessoa(nome));
       // Pessoa pessoa = pessoas.get(index);
        /*
        if (index < 1) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada!").type(MediaType.APPLICATION_JSON_TYPE).build();
        } */

        return Response.ok(new Gson().toJson(pessoas.get(index))).build();
    }
}
