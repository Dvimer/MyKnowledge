"# MyKnowledge" 


Матрица компетенций
http://grompe.org.ru/static/prog_comp_matrix_ru.html


org.jsonschema2pojo - convert json2Pogo
  <build>
                <plugins>
                    <plugin>
                        <groupId>org.jsonschema2pojo</groupId>
                        <artifactId>jsonschema2pojo-maven-plugin</artifactId>
                        <version>${jsonschema2pojo-maven-plugin.version}</version>
                        <configuration>
                            <sourceDirectory>${project.basedir}/src/main/resources/json/file.json</sourceDirectory>
                            <targetPackage>ru.dvimer.json.items</targetPackage>
                            <useCommonsLang3>true</useCommonsLang3>
                            <sourceType>json</sourceType>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>generate</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
