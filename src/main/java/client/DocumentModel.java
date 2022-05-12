package client;

import com.azure.ai.formrecognizer.implementation.models.ApiVersion;
import com.azure.ai.formrecognizer.models.AnalyzeResult;

public interface DocumentModel<Result> {
    String getModelId();
    ApiVersion getApiVersion();
    Result transformAnalyzeResult(AnalyzeResult analyzeResult);
}
