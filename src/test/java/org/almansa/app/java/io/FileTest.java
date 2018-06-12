package org.almansa.app.java.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest {
    @Test
    public void fileClass() throws IOException {
        // java.io
        // '파일' 및 '디렉토리 경로'의 추상적 표현
        // 상대 경로도 포함가능하다.
        // Serializable, Comparable<File>

        File dir = new File("D:\\Temp");

        System.out.println("경로 일 경우");
        System.out.println(dir.isFile());
        System.out.println(dir.isDirectory());
        System.out.println(dir.isAbsolute());
        System.out.println(dir.getPath()); // 표준경로 가져오기
        System.out.println(dir.getCanonicalPath()); // 표준경로 가져오기
        System.out.println(dir.getAbsolutePath()); // 추상경로 가져오기
        System.out.println(dir.getTotalSpace()); // 경로의 파티션의 총공간 가져요기
        System.out.println(dir.getFreeSpace()); // 경로의 파티션의 여유공간가져오기
        System.out.println(dir.getParent()); // 부모경로가져오기 (바로 상위 경로 리턴)
        System.out.println(dir.getParentFile().getPath()); // 부로경로 File 인스턴스로 가져오기

        File file = new File("D:\\Temp\\test.html");
        System.out.println("파일 일 경우");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isAbsolute());
        System.out.println(file.getPath()); // 표준경로 가져오기
        System.out.println(file.getCanonicalPath()); // 표준경로 가져오기
        System.out.println(file.getAbsolutePath()); // 추상경로 가져오기
        System.out.println(file.getTotalSpace()); // 경로의 파티션의 총공간 가져요기_ 경로이건 파일이건 같은 파티션이면 같은 사이즈를 리턴
        System.out.println(file.getFreeSpace()); // 경로의 파티션의 여유공간가져오기
        System.out.println(file.getParent()); // 부모경로가져오기 (바로 상위 경로 리턴)
        System.out.println(file.getParentFile().getPath()); // 부로경로 File 인스턴스로 가져오기

        File abstractDir = new File("..");
        System.out.println("상대 경로일 경우");
        System.out.println(abstractDir.isFile());
        System.out.println(abstractDir.isDirectory());
        System.out.println(abstractDir.isAbsolute()); // false
        System.out.println(abstractDir.getPath()); // 표준경로 가져오기
        System.out.println(abstractDir.getCanonicalPath()); // 표준경로 가져오기
        System.out.println(abstractDir.getAbsolutePath()); // 추상경로 가져오기
        System.out.println(abstractDir.getTotalSpace()); // 경로의 파티션의 총공간 가져요기_ 경로이건 파일이건 같은 파티션이면 같은 사이즈를 리턴
        System.out.println(abstractDir.getFreeSpace()); // 경로의 파티션의 여유공간가져오기
        System.out.println(abstractDir.getParent()); // 부모경로가져오기 (바로 상위 경로 리턴)
        System.out.println(abstractDir.getParentFile().getPath()); // 부로경로 File 인스턴스로 가져오기
    }

    @Test
    public void listMethodTest() {
        // File 클래스의 list(), listFiles() 메소드
        // 가르키는 것이 파일이면 null을 리턴하는 것에 주의
        File file = new File("D:\\Temp\\");

        for (String item : file.list()) {
            System.out.println(item); // 파일명, 디렉토리명만 가져온다.
        }

        for (File item : file.listFiles()) {
            System.out.println(item);
        }

        // 이 메소드는 FileFilter라는 함수형 인터페이스를 인자로 받는다.
        // 람다등을 이용하여 적절한 필터링을 구현할 수 있다.
        file.listFiles((pathName) -> (pathName.isDirectory()));
    }
}
