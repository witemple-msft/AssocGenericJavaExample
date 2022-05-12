package client;

import com.azure.ai.formrecognizer.DocumentAnalysisClient;
import com.azure.ai.formrecognizer.DocumentAnalysisClientBuilder;
import com.azure.ai.formrecognizer.models.AnalyzeResult;

import java.io.InputStream;

public class Client {
    private final DocumentAnalysisClient _client;
    public Client(DocumentAnalysisClientBuilder builder) {
        this._client = builder.buildClient();
    }

    public AnalyzeResult beginAnalyzeDocument(String modelId, InputStream input, long length) {
        return this._client.beginAnalyzeDocument(modelId, input, length).getFinalResult();
    }

    public <Result> Result beginAnalyzeDocument(Class<Result> model, InputStream input, long length) throws Exception {
        DocumentModel<Result> documentModel;
        try {
            documentModel = (DocumentModel<Result>)model.getDeclaredMethod("getDocumentModel").invoke(null);
        } catch (Exception ex) {
            throw new Exception("Failed to extract document model information from result type %s.".formatted(model.getName()));
        }

        var poller = this._client.beginAnalyzeDocument(documentModel.getModelId(), input, length);

        return documentModel.transformAnalyzeResult(poller.getFinalResult());
    }

    public AnalyzeResult beginAnalyzeDocumentFromUrl(String modelId, String documentUrl) throws Exception {
        return this._client.beginAnalyzeDocumentFromUrl(modelId, documentUrl).getFinalResult();
    }

    public <Result> Result beginAnalyzeDocumentFromUrl(Class<Result> model, String documentUrl) throws Exception {
        DocumentModel<Result> documentModel;
        try {
            documentModel = (DocumentModel<Result>)model.getDeclaredMethod("getDocumentModel").invoke(null);
        } catch (Exception ex) {
            throw new Exception("Failed to extract document model information from result type %s.".formatted(model.getName()));
        }

        var poller = this._client.beginAnalyzeDocumentFromUrl(documentModel.getModelId(), documentUrl);

        return documentModel.transformAnalyzeResult(poller.getFinalResult());
    }
}
