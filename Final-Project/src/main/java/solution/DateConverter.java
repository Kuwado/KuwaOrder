package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    // Hàm tính toán hiệu số ngày
    public static int roundedDaysDifferenceFromToday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate inputDate = LocalDate.parse(date, formatter);
            LocalDate currentDate = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(currentDate, inputDate);
            int roundedDifference = (int) Math.ceil(daysDifference);
            return roundedDifference;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return 0;
        }
    }

    // Hàm tính ngày nhận dự kiến
    public static String addDaysToDate(int daysToAdd) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = newDate.format(formatter);
        return formattedDate;
    }

    // Hàm convert từ yyyy-MM-dd HH:mm:ss sang dd/mm/yyyy
    public static String convertDateTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(timeString, formatter);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(newFormatter);
    }

    // Hàm convert từ yyyy-mm-dd sang dd/mm/yyyy
    public static String convertDateFormat2(String inputDate) {
        // Định nghĩa định dạng của ngày tháng
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse ngày tháng từ chuỗi đầu vào
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // Chuyển đổi sang định dạng mới và trả về
        return outputFormatter.format(date);
    }

    public static void main(String[] args) {
        // Sử dụng hàm convertToStandardFormat để chuyển đổi ngày tháng
        String inputDate = "25/05/2024";
        System.out.println(roundedDaysDifferenceFromToday(inputDate));
    }
}
