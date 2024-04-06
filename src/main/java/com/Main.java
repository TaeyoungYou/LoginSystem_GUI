package com;

import com.loginsystem.App;

public class Main {
    public static void main(String[] args) throws Exception {   // ignore everythings
        App.main(args);

        Thread.sleep(1000);


    }
}
/*
 * 버그 찾음 : App main을 Main main으로 호출할때, 그래픽 init 이 안되서 오류가 났다
 * 왜: App main을 Main main으로 호출하는가
 *      짐작하는데 main이 포함된 클래스는 상속을 하면, build를 해도 실행이 안된다
 * 이에 대한 해결책으로 위 같은 방법으로 한것
 * 버그 발생: 그래픽이 초기화가 안되는 것
 * 해결: main 실행하기 전, public static 필드에 선언과 초기화하는 변수가 있으면 안됨
 *      예) 난 로고(이미지)로드하고, Scanner를 필드에 초기화 했다
 * 없애니 해결, 각각 지역변수로 해줬다 필요한 곳 마다
 */