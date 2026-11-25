package ma.emsi.nahhal.tp3restnahhal.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique.
            Réponds en français avec exactement deux principaux endroits
            à visiter dans la ville ou le pays demandé et une estimation
            du prix moyen d'un repas dans la devise du pays.

            N'utilise pas Markdown. Réponds uniquement avec un objet JSON
            respectant exactement cette structure :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    String chat(String lieu);
}