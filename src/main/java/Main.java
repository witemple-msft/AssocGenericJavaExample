import client.Client;
import receipt.ReceiptResult;

import com.azure.ai.formrecognizer.DocumentAnalysisClientBuilder;
import com.azure.core.credential.AzureKeyCredential;

public class Main {
    public static void main(String[] args) throws Exception {
        var client = new Client(new DocumentAnalysisClientBuilder()
                .credential(new AzureKeyCredential("e935ed31ff2a4bd4ba5c127800475d06"))
                .endpoint("https://paulhsu-fr.cognitiveservices.azure.com"));

        var result = client.beginAnalyzeDocumentFromUrl(
                ReceiptResult.class,
                "https://raw.githubusercontent.com/Azure/azure-sdk-for-java/main/sdk/formrecognizer/azure-ai-formrecognizer/src/samples/resources/sample-forms/receipts/contoso-allinone.jpg"
        );

        System.out.println("Got a %s.".formatted(result.getClass().getName()));
    }
}
