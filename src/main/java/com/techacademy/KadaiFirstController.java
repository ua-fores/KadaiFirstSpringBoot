package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    // 指定日を曜日に変換して表示する
    @GetMapping("/dayofweek/{inputDate}")
    public String dispDayOfWeek(@PathVariable String inputDate) {

        // 引数をトリミングする
        int year = Integer.parseInt(inputDate.substring(0, 4));
        int month = Integer.parseInt(inputDate.substring(4, 6));
        int day = Integer.parseInt(inputDate.substring(6));

        // Calendarクラス変数に引数の日付をセットする
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        // 出力文字列を設定する
        String dayOfWeek = null;
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
        case Calendar.SUNDAY:
            dayOfWeek = "Sunday";
            break;
        case Calendar.MONDAY:
            dayOfWeek = "Monday";
            break;
        case Calendar.TUESDAY:
            dayOfWeek = "Tuesday";
            break;
        case Calendar.WEDNESDAY:
            dayOfWeek = "Wednesday";
            break;
        case Calendar.THURSDAY:
            dayOfWeek = "Thursday";
            break;
        case Calendar.FRIDAY:
            dayOfWeek = "Fryday";
            break;
        case Calendar.SATURDAY:
            dayOfWeek = "Saturday";
            break;
        }
        return dayOfWeek;
    }

    // 足し算メソッド
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 + val2;
        return "実行結果：" + result;
    }

    // 引き算メソッド
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 - val2;
        return "実行結果：" + result;
    }

    // 掛け算メソッド
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 * val2;
        return "実行結果：" + result;
    }

    // 割り算メソッド
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 / val2;
        return "実行結果：" + result;
    }

}
