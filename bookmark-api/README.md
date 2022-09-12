### Create Docker Image using Springboot Maven Plugin

Run the below command:  <br>
```shell
foo@bar:~$ ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=blitzstriker/bookmark-api
```
You can also provide the image name in the pom.xml file inside the `configuration` tag inside plugin and then directly run the above command without mentioning the image name.  <br>
```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <image>
                        <name>blitzstriker/bookmark-api</name>
                    </image>
                    ...
                </configuration>
            </plugin>
        </plugins>
    </build>
```