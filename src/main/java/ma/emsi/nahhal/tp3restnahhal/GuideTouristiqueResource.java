package ma.emsi.nahhal.tp3restnahhal;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.nahhal.tp3restnahhal.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Retourne les informations touristiques du lieu au format JSON.
     *
     * @param lieu ville ou pays demandé
     * @param nombre nombre d'endroits à visiter, 2 par défaut
     * @return informations touristiques générées par Gemini
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String lieu,
            @QueryParam("nb") @DefaultValue("2") int nombre) {

        if (nombre < 1) {
            throw new BadRequestException(
                    "Le paramètre nb doit être supérieur ou égal à 1.");
        }

        return llmClient.endroitsDeVisite(lieu, nombre);
    }
}