package ma.emsi.nahhal.tp3restnahhal.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClient {

    private final GuideTouristique guide;

    public LlmClient() {
        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "La variable d'environnement GEMINI_KEY n'est pas définie.");
        }

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.3)
                .build();

        guide = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }

    public String endroitsDeVisite(String lieu) {
        return guide.chat(lieu);
    }
}