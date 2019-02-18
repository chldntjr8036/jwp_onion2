package calculator;

import java.util.List;

public class StringCalculator {

    public String[] split(String str) {
        String splitor;
        //커스텀 문자를 포함하는 경우
        if(str.startsWith("//")){
            splitor = String.valueOf(str.charAt(2));
            str = str.substring(4);
        }else{ splitor = "[:,]"; }
        return str.split(splitor);
    }



}
