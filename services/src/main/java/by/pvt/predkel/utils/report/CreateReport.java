package by.pvt.predkel.utils.report;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.utils.optional.Transliterator;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.util.List;

/**
 * Класс в котором добавляем в список объектов для отчета таблицы и графики
 */
public class CreateReport {
    private Building build;
    private WordprocessingMLPackage wordMLPackage;
    private MyChart chart;

    public MyChart getChart() {
        return chart;
    }

    public WordprocessingMLPackage getWordMLPackage() {
        return wordMLPackage;
    }

    public CreateReport(Building building) {
        build = building;
    }

    public void create(String filepath) throws Exception {
        wordMLPackage = WordprocessingMLPackage.createPackage();

        TableWithMergedCells tables = new TableWithMergedCells();
        List<Object> t = tables.createTables(build);
        for (Object temp : t) {
            wordMLPackage.getMainDocumentPart().addObject(temp);
        }
        chart = new MyChart(build);
        chart.outputChart(wordMLPackage, filepath);

        wordMLPackage.save(new java.io.File(filepath + Transliterator.transliterate(build.getNameOfBuilding()) + ".docx"));
    }
}
