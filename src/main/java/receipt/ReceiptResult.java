package receipt;

import client.DocumentModel;

public final class ReceiptResult {
    public static DocumentModel<ReceiptResult> getDocumentModel() {
        return new ReceiptDocumentModel();
    }

    // Implement receipt result here
}
