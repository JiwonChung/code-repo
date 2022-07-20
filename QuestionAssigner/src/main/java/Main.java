import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.Question;
import repository.Unit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Unit> physicsUnits = new ArrayList<>();
        final String FILE_LOCATION = "/Users/jiwon/code-repo/FILE_LOCATION/QuestionAssigner/";
        final DecimalFormat df = new DecimalFormat("0.00");

        FileInputStream file = new FileInputStream(FILE_LOCATION + "frozen.xlsx");
        Workbook fileWorkBook = new XSSFWorkbook(file);

        // 1회차 pick
        Sheet pick_first = fileWorkBook.getSheet("pick_1");
        for (int rowIndex = 3; rowIndex < 33; rowIndex++) {
            Row row = pick_first.getRow(rowIndex);

            Unit unit = new Unit();
            unit.setTimes(1);
            unit.setBookName("pick");
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
            unit.setTimes(2);
            unit.setBookName("pick");
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
            unit.setTimes(3);
            unit.setBookName("pick");
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
            unit.setTimes(1);
            unit.setBookName("bon");
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
            unit.setTimes(2);
            unit.setBookName("bon");
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
            unit.setTimes(3);
            unit.setBookName("bon");
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
            unit.setTimes(1);
            unit.setBookName("gigi");
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
            unit.setTimes(2);
            unit.setBookName("gigi");
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
            unit.setTimes(3);
            unit.setBookName("gigi");
            unit.setUnitName(row.getCell(2).getStringCellValue());
            unit.setQuestionNumber((int) row.getCell(3).getNumericCellValue());

            unit.setAssignedTimeForAQuestion((int) row.getCell(4).getNumericCellValue());
            gigiUnits.add(unit);
        }

        Gson gson = new Gson();
//        System.out.println(gson.toJson(physicsUnits));
//        System.out.println(gson.toJson(gigiUnits));



        int physics_totalMin = 0;
        for (Unit u : physicsUnits) {
            physics_totalMin += u.getAssignedTimeForAQuestion() * u.getQuestionNumber();
        }

        int gigi_totalMin = 0;
        for (Unit u : gigiUnits) {
            gigi_totalMin += u.getAssignedTimeForAQuestion() * u.getQuestionNumber();
        }

//        System.out.println("물리 전체 시간: " + df.format(physics_totalMin / 60.0));
//        System.out.println("기기 전체 시간: " + df.format(gigi_totalMin / 60.0));

        ArrayList<Question> physicsQuestions = new ArrayList<>();
        ArrayList<Question> gigiQuestions = new ArrayList<>();
        long pickIndex = 0;
        long bonIndex = 0;
        long gigiIndex = 0;
        for (Unit physicsUnit : physicsUnits) {

            if (physicsUnit.getBookName().equals("pick")) {
                for (int i = 0; i < physicsUnit.getQuestionNumber(); i++) {
                    Question question = new Question();
                    question.setId(++pickIndex);
                    question.setName("pick" + "_"
                                    + physicsUnit.getUnitName() + "_"
                                    + physicsUnit.getQuestionNumber() + "_"
                                    + physicsUnit.getTimes());
                    question.setTpq(physicsUnit.getAssignedTimeForAQuestion());
                    physicsQuestions.add(question);
                }
            }

            if (physicsUnit.getBookName().equals("bon")) {
                for (int i = 0; i < physicsUnit.getQuestionNumber(); i++) {
                    Question question = new Question();
                    question.setId(++bonIndex);
                    question.setName("bon" + "_"
                            + physicsUnit.getUnitName() + "_"
                            + physicsUnit.getQuestionNumber() + "_"
                            + physicsUnit.getTimes());
                    question.setTpq(physicsUnit.getAssignedTimeForAQuestion());
                    physicsQuestions.add(question);
                }
            }
        }

        long gigiQuestionCounter = 0;
        for (Unit gigiUnit : gigiUnits) {
            for (int i = 0; i < gigiUnit.getQuestionNumber(); i++) {
                Question question = new Question();
                question.setId(++gigiQuestionCounter);
                question.setName("gigi" + "_"
                            + gigiUnit.getUnitName() + "_"
                            + (i + 1) + "_"
                            + gigiUnit.getTimes());
                question.setTpq(gigiUnit.getAssignedTimeForAQuestion());
                gigiQuestions.add(question);
            }
        }


        int[] availableTime = {34, 33, 33, 48, 29, 23, 23};


        // 비례분배
        int totalAvailableMinutes = 0;
        for (int a : availableTime) {
            totalAvailableMinutes += a * 60;
        }

        double[] shouldStudyTime_physics_min = {0, 0, 0, 0, 0, 0, 0};
        double[] shouldStudyTime_gigi_min = {0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < availableTime.length; i++) {
            double percent = availableTime[i]*60 / (float) totalAvailableMinutes;
            double shouldStudyTimeMin = (physics_totalMin + gigi_totalMin) * percent;

            System.out.println("Week " + (i + 1));
            System.out.println("This you should study at least " + df.format(shouldStudyTimeMin / 60.0) + " hours.");
            System.out.println("Physics: " + df.format(physics_totalMin * percent / 60.0));
            shouldStudyTime_physics_min[i] = physics_totalMin * percent;
            System.out.println("Gigi: " + df.format(gigi_totalMin * percent / 60.0));
            shouldStudyTime_gigi_min[i] = gigi_totalMin * percent;
            // 물리 x 시간을 하면
            // 기기 x 시간을 하면 직류기1에서 y 문제 직류기2에서 z문제
            System.out.println("\n");
        }

        System.out.println(gson.toJson(shouldStudyTime_physics_min));
        System.out.println(gson.toJson(shouldStudyTime_gigi_min));

        ArrayList<ArrayList<Question>> physics_eachDays = new ArrayList<>();
        ArrayList<ArrayList<Question>> gigi_eachDays = new ArrayList<>();

        pickIndex = 0;
        // 일일 할당량 계산
        for (double pm : shouldStudyTime_physics_min) {
            ArrayList<Question> physics_eachDay = new ArrayList<>();
            double restTime = pm;
            for (; pickIndex < physicsQuestions.size(); pickIndex++) {
                Question question = physicsQuestions.get((int) pickIndex);
                restTime -= question.getTpq();
                if (restTime > 0) {
                    physics_eachDay.add(question);
                } else {
                    break;
                }
            }
            physics_eachDays.add(physics_eachDay);
        }

        gigiQuestionCounter = 0;
        for (double gm : shouldStudyTime_gigi_min) {
            ArrayList<Question> gigi_eachDay = new ArrayList<>();
            double restTime = gm;
            for (;gigiQuestionCounter < gigiQuestions.size(); gigiQuestionCounter++) {
                Question question = gigiQuestions.get((int) gigiQuestionCounter);
                restTime -= question.getTpq();
                if (restTime > 0) {
                    gigi_eachDay.add(question);
                } else {
                    break;
                }
            }
            gigi_eachDays.add(gigi_eachDay);
        }


        System.out.println("첫 주" +
                gson.toJson(physics_eachDays.get(0).get(0)) + "부터 " +
                gson.toJson(physics_eachDays.get(0).get(physics_eachDays.get(0).size() - 1)));
        System.out.println("막주" +
                gson.toJson(physics_eachDays.get(6).get(0)) + "부터 " +
                gson.toJson(physics_eachDays.get(6).get(physics_eachDays.get(6).size() - 1)));
        System.out.println(physics_eachDays.get(0).size());
        System.out.println(physics_eachDays.get(1).size());
        System.out.println();
        System.out.println();
        System.out.println(gigi_eachDays.size());
        System.out.println("첫 주" +
                gson.toJson(gigi_eachDays.get(0).get(0)) + "부터 " +
                gson.toJson(gigi_eachDays.get(0).get(gigi_eachDays.get(0).size() - 1)));

        System.out.println("둘째 주" +
                gson.toJson(gigi_eachDays.get(1).get(0)) + "부터 " +
                gson.toJson(gigi_eachDays.get(1).get(gigi_eachDays.get(1).size() - 1)));
//        System.out.println(gson.toJson(gigi_eachDays));

    }
}
