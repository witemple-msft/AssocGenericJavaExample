package receipt;

import client.DocumentModel;
import com.azure.ai.formrecognizer.implementation.models.ApiVersion;
import com.azure.ai.formrecognizer.models.AnalyzeResult;

public final class ReceiptDocumentModel implements DocumentModel<ReceiptResult> {
    @Override
    public String getModelId() {
        return "prebuilt-receipt";
    }

    @Override
    public ApiVersion getApiVersion() {
        return ApiVersion.TWO_THOUSAND_TWENTY_TWO0130PREVIEW;
    }

    @Override
    public ReceiptResult transformAnalyzeResult(AnalyzeResult analyzeResult) {
        return new ReceiptResult();
    }
}
