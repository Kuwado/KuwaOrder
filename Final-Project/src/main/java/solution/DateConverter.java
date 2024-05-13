package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DateConverter {

    // Hàm chuyển đổi từ dd/mm/yyyy sang yyyy-mm-dd
    public static String convertToStandardFormat(String dateInDDMMYYYY) {
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = inputDateFormat.parse(dateInDDMMYYYY);
            DateTimeFormatter outputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.of(
                    date.getYear() + 1900, // Để đảm bảo năm đúng với năm hiện tại
                    date.getMonth() + 1,    // Vì Month trong Java là từ 0 (tháng 1) đến 11 (tháng 12)
                    date.getDate()
            );

            String formattedDate = localDate.format(outputDateFormat);

            return formattedDate;
        } catch (ParseException e) {
            // Xảy ra lỗi khi không thể chuyển đổi ngày tháng từ chuỗi đầu vào
            System.err.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }

    // Hàm sắp xếp mảng các chuỗi ngày theo định dạng dd/mm/yyyy
    public static void sortDates(String[] dates) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate[] localDateArray = new LocalDate[dates.length];
        for (int i = 0; i < dates.length; i++) {
            localDateArray[i] = LocalDate.parse(dates[i], dateFormatter);
        }
        Arrays.sort(localDateArray);
        for (int i = 0; i < dates.length; i++) {
            dates[i] = localDateArray[i].format(dateFormatter);
        }
    }

    public static void main(String[] args) {
        // Sử dụng hàm convertToStandardFormat để chuyển đổi ngày tháng
        String inputDate = "25/05/2024";
        String standardizedDate = convertToStandardFormat(inputDate);

        if (standardizedDate != null) {
            System.out.println("Input Date (dd/mm/yyyy): " + inputDate);
            System.out.println("Standardized Date (yyyy-mm-dd): " + standardizedDate);
        }
    }
}
