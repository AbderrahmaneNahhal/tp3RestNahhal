package ma.emsi.nahhal.tp3restnahhal;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.nahhal.tp3restnahhal.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Demande à Gemini les informations touristiques du lieu.
     *
     * @param lieu nom de la ville ou du pays
     * @return objet JSON contenant deux endroits et le prix moyen d'un repas
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String lieu) {
        return llmClient.endroitsDeVisite(lieu);
    }
}