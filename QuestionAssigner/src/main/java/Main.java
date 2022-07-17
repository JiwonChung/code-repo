import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.Unit;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
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
            int numberOfQuestion = (int) Math.ceil((int) row.getCell(4).getNumericCellValue() / 10.0);
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
            int numberOfQuestion = (int) Math.ceil(row.getCell(4).getNumericCellValue() / 10.0);
            unit.setQuestionNumber(numberOfQuestion);

            unit.setAssignedTimeForAQuestion((int) row.getCell(5).getNumericCellValue());
            physicsUnits.add(unit);
        }

        // 1회차 bon
        Sheet bon_1 = fileWorkBook.getSheet("bon_1");
        for (int rowIndex = 3; rowIndex < 19; rowIndex++) {
            Row row = bon_1.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(3).getNumericCellValue());

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            physicsUnits.add(unit);
        }

        // 2회차
        Sheet bon_2 = fileWorkBook.getSheet("bon_2");
        for (int rowIndex = 3; rowIndex < 19; rowIndex++) {
            Row row = bon_2.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            int numberOfQuestion = (int) Math.ceil(row.getCell(3).getNumericCellValue() / 10.0);
            unit.setQuestionNumber(numberOfQuestion);

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            physicsUnits.add(unit);
        }

        // 3회차
        Sheet bon_3 = fileWorkBook.getSheet("bon_3");
        for (int rowIndex = 3; rowIndex < 19; rowIndex++) {
            Row row = bon_3.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            int numberOfQuestion = (int) Math.ceil(row.getCell(3).getNumericCellValue() / 10.0);
            unit.setQuestionNumber(numberOfQuestion);

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            physicsUnits.add(unit);
        }

        ArrayList<Unit> gigiUnits = new ArrayList<>();
        // 1회차 기기
        Sheet gigi_1 = fileWorkBook.getSheet("gigi_1");
        for (int rowIndex = 3; rowIndex < 13; rowIndex++) {
            Row row = gigi_1.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(3).getNumericCellValue());

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            gigiUnits.add(unit);
        }
        // 2회차
        Sheet gigi_2 = fileWorkBook.getSheet("gigi_2");
        for (int rowIndex = 3; rowIndex < 13; rowIndex++) {
            Row row = gigi_2.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(3).getNumericCellValue());

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            gigiUnits.add(unit);
        }
        // 3회차
        Sheet gigi_3 = fileWorkBook.getSheet("gigi_3");
        for (int rowIndex = 3; rowIndex < 13; rowIndex++) {
            Row row = gigi_3.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setUnitName(row.getCell(2).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(3).getNumericCellValue());

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            gigiUnits.add(unit);
        }




        int physicsTotalMin = 0;
        for (Unit u : physicsUnits) {
            physicsTotalMin += u.getAssignedTimeForAQuestion() * u.getQuestionNumber();
        }

        System.out.println("물리 단위 수: " + physicsUnits.size());

        System.out.println("물리 전체 시간 분: " + physicsTotalMin);

        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("물리 전체 시간: " + df.format(physicsTotalMin / 60.0));

        int gigi_totalMin = 0;
        for (Unit u : gigiUnits) {
            gigi_totalMin += u.getAssignedTimeForAQuestion() * u.getQuestionNumber();
        }

        System.out.println("기기 단위 수: " + gigiUnits.size());

        System.out.println("기기 전체 시간 분: " + gigi_totalMin);

        System.out.println("기기 전체 시간: " + df.format(gigi_totalMin / 60.0));


//        Gson gson = new Gson();
//        String json = gson.toJson(physicsUnits);
//        System.out.println(json);
    }
}
