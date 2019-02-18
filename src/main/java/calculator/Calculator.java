package calculator;

public class Calculator {
    StringCalculator st = new StringCalculator();
    public int add(String str) {
        //빈 문자열 예외처리
        if(str == null || str.equals(" ")) return 0;

        String[] sa = st.split(str);
        int sum = 0;

        for (String e: sa){
            int n = Integer.parseInt(e);
            if(n < 0) throw new RuntimeException("Negative number exists."); //예외처리
            sum += n;
        }
        return sum;
    }


}
