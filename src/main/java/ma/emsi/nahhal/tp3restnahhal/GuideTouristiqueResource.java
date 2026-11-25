package ma.emsi.nahhal.tp3restnahhal;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Retourne le lieu demandé dans un tableau JSON.
     *
     * @param lieu nom de la ville ou du pays
     * @return tableau contenant le lieu
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(
            @PathParam("ville_ou_pays") String lieu) {
        return new String[]{lieu};
    }
}