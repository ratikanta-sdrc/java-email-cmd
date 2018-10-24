# java-email-cmd
This is a java maven project which will send email by running the jar file with parameters

## Instruction to generate the jar file

Please run the fillowing command

```shell
mvn clean compile assembly:single
mvn exec:java -Dexec.mainClass="javacmdemail.Main" -s "C:\apache-maven-3.3.3\conf\settings.xml"
```

Here _-Dexec.mainClass_ is main class of your java project. Please give fully qualified(with package) class name.

After _-s_ give path to `settings.xml`

Change the `localRepository` location of `settings.xml`

```shell
<localRepository>D:\Ratikanta\artifacts1</localRepository>
```