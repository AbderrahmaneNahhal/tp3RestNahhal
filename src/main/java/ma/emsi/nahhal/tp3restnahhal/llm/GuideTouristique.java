package ma.emsi.nahhal.tp3restnahhal.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique.
            L'utilisateur indique une ville ou un pays et un nombre d'endroits.
            Réponds en français avec exactement le nombre d'endroits demandé
            et une estimation du prix moyen d'un repas dans la devise du pays.

            N'utilise pas Markdown. Réponds uniquement avec un objet JSON :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            Le tableau endroits_a_visiter doit contenir exactement
            le nombre d'éléments demandé.
            """)
    String chat(String demande);
}