package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class TestStringCalculator {
    StringCalculator sc;
    @Before
    public void before(){
        sc = new StringCalculator();
    }
    @Test
    public void test_split(){
        String[] expected = {"1","2","3"};

        //기본 구분자가 입력인 경우
        String input1 = "1,2:3";
        String[] actual1 = sc.split(input1);

        assertArrayEquals(expected, actual1);

        //커스텀 구분자인 경우
        String input2 = "//;\n1;2;3";
        String[] actual2 = sc.split(input2);

        assertArrayEquals(expected, actual2);


    }


    //정규표현식 테스트
    @Test
    public void testRegixBasicSplitor(){
        String regix = "[:,]";
        // , 인 경우
        Pattern pt1= Pattern.compile(regix);
        Matcher mt1 = pt1.matcher("1,2");

        assertEquals("only existing , case fail",true, mt1.find());

        // : 인 경우
        Pattern pt2 = Pattern.compile(regix);
        Matcher mt2= pt2.matcher("1:2");

        assertEquals("only existing : case fail",true, mt2.find());

        //그 외의 문자가 들어간 경우
        Pattern pt3 = Pattern.compile(regix);
        Matcher mt3= pt3.matcher("1;2");

        assertEquals("other splitor char case fail",false, mt3.find());

        //,와 :가 같이 쓰인 경우
        Pattern pt4 = Pattern.compile(regix);
        Matcher mt4= pt4.matcher("1:2,3");

        String str = "1:2,3";
        String[] sa = str.split(regix);

        String[] expected = {"1", "2","3"};
        assertArrayEquals("Both of basic splitor case fail",expected, sa);
    }
}
