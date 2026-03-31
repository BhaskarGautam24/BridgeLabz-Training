interface ReportExporter{
    void export();
    default void exportToJSON(){
        System.out.println("Exporting report to JSON format");
    }
}
class CSVExporter implements ReportExporter{
    public void export(){
        System.out.println("Exporting report to CSV");
    }
}
class PDFExporter implements ReportExporter {
    public void export(){
        System.out.println("Exporting report to PDF");
    }
}
public class Report{
    public static void main(String[] args){
        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();
        csv.export();
        csv.exportToJSON();
        pdf.export();
        pdf.exportToJSON();
    }
}

