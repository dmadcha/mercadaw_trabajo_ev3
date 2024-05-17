package es.etg.daw.prog.mercadaw.model.util.export;

public class DocumentoFactory {
    public static ExportableUtil obtener(Exportable exportable) {
        if (exportable == Exportable.EXCEL) {
            return new ExcelUtil();
        } else {
            return new PDFUtil();
        }
    }
}
