package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    //import option + shift +enter


    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapps/";
        //오류가 나는 이유 : webapps 라는 디렉토리가 없어 오류가 남 (webapps 디렉토리 생성해주기)
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        //톰켓을 8080포트로 실행 할것이다
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        //루트인 webapps에서 찾는다
        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}