import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.Unit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Unit> physicsUnits = new ArrayList<>();
        final String FILE_LOCATION = "/Users/jiwon/code-repo/FILE_LOCATION/QuestionAssigner/";

        FileInputStream file = new FileInputStream(FILE_LOCATION + "frozen.xlsx");
        Workbook fileWorkBook = new XSSFWorkbook(file);

        // 1회차 pick
        Sheet pick_first = fileWorkBook.getSheet("pick_1");
        for (int rowIndex = 3; rowIndex < 33; rowIndex++) {
            Row row = pick_first.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(3).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(4).getNumericCellValue());
            unit.setAssignedTimeForAQuestion((int) row.getCell(5).getNumericCellValue());
            physicsUnits.add(unit);
        }

        // 2회차
        Sheet pick_second = fileWorkBook.getSheet("pick_2");
        for (int rowIndex = 3; rowIndex < 33; rowIndex++) {
            Row row = pick_second.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(3).getStringCellValue());
            int numberOfQuestion = (int) Math.ceil((int) row.getCell(4).getNumericCellValue() * 11 / 10.0);
            unit.setQuestionNumber(numberOfQuestion);

            unit.setAssignedTimeForAQuestion((int) row.getCell(5).getNumericCellValue());
            physicsUnits.add(unit);
        }
        // 3회차
        Sheet pick_third = fileWorkBook.getSheet("pick_3");
        for (int rowIndex = 3; rowIndex < 33; rowIndex++) {
            Row row = pick_second.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(3).getStringCellValue());
            int numberOfQuestion = (int) Math.ceil((int) row.getCell(4).getNumericCellValue() * 11 / 10.0);
            unit.setQuestionNumber(numberOfQuestion);

            unit.setAssignedTimeForAQuestion((int) row.getCell(5).getNumericCellValue());
            physicsUnits.add(unit);
        }

        // 1회차 bon
        // 2회차
        // 3회차

        Gson gson = new Gson();
        String json = gson.toJson(physicsUnits);
        System.out.println(json);
    }
}
