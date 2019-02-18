# 문자열 계산기 2장 정리

***

## 정규 표현식 Capturing group

*  ((A)(B(C)))인 정규표현식이 있다고 하자. 각 A,B,C에는 그룹핑할 조건들이 들어간다.
숫자일 경우 \d나 영어 소문자 집합의 경우 \[a-z\]등이다. 
* 그룹의 번호지어지는데 열린 괄호를 기준으로 왼쪽에서 오른쪽으로 번호 붙여진다.
    1. ((A)(B(C)))
    2. (A)
    3. (B(C))
    4. (C)  가 된다.
0번 그룹은 항상 문자열 전체를 뜻한다. 그룹개수를 셀 때 0번 그룹은 포함되지 않는다.


예제를 보자.

출처 : https://www.tutorialspoint.com/javaregex/javaregex_capturing_groups.htm

```
public class RegexMatches {
   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(.*)(\\d+)(.*)";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
      } else {
         System.out.println("NO MATCH");
      }
   }
}
```

Output
```
Found value: This order was placed for QT3000! OK?
Found value: This order was placed for QT300
Found value: 0
```

***

* 위의 예제는 언핏봐서는 이해하기 힘들다. 두번쨰 그룹의 조건이 \d이기 때문에 3000 전까지가
첫번쨰 그룹일거라고 생각했었기 때문. 
* 내부적으로 선행되어 있는 조건이 더 우선되기 때문에. (그리고 일단 두번째 조건 자체가 고정된 조건이 아니라
동적인 조건이기 때문이다.)두번쨰 그룹은 0이 되고 첫 번쨰 그룹은 마지막 0전까지가 된다.

* 정규 표현식을 바꿔보면 이해가 쉽다. (.\*)(\\d{4})(.\*)로 바꾸면 두번쨰 그룹은 3000이 된다.


## 내 구현과 달랐던 점, 느낀점.

### 책의 구현은 메소드를 작게 나누고 메소드마다 명확한 하나의 책임이 있다. 나는 그렇지 못했다.