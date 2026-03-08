import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class AISorthat {

    // --- CONFIGURATION ---
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String MODEL = "stepfun/step-3.5-flash:free";

    public static String callSortingHat(String name, String dis) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(15))
                    .build();

            String prompt = "You are the Hogwarts Sorting Hat. Student: " + name + 
                            ". Traits: " + dis + ". Pick a house (Gryffindor, Slytherin, Ravenclaw, Hufflepuff) " +
                            "and give a littel bit long sentence reason. Format: House | Reason [Don't add text style for the output]";

            String safePrompt = prompt.replace("\"", "\\\"").replace("\n", "\\n");

            String jsonBody = "{"
                + "\"model\": \"" + MODEL + "\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"" + safePrompt + "\"}],"
                + "\"temperature\": 0.8"
                + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("HTTP-Referer", "http://localhost") 
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // Sending the request to OpenRouter
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return parseContent(response.body());
            } else {
                return "Error | Ministry of Magic signal lost (Status " + response.statusCode() + ")";
            }

        } catch (Exception e) {
            return "Error | Magic Failed: " + e.getMessage();
        }
    }

    private static String parseContent(String jsonResponse) {
        try {
            // Find the "content" field in the raw JSON response
            int start = jsonResponse.indexOf("\"content\":\"") + 11;
            int end = jsonResponse.indexOf("\"", start);
            String content = jsonResponse.substring(start, end);
            
            // Clean up JSON escape characters for the UI display
            return content.replace("\\n", " ").replace("\\\"", "\"").trim();
        } catch (Exception e) {
            return "Error | Could not read the Hat's mind.";
        }
    }
}