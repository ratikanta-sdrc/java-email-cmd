# java-email-cmd
This is a java maven project which will send email by running the jar file with parameters

## Instruction to generate the jar file

Clone the project

Change the `localRepository` location of maven `settings.xml` if required.

```shell
<localRepository>D:\Ratikanta\artifacts1</localRepository>
```

Run following command

```shell
mvn clean compile assembly:single
mvn exec:java -Dexec.mainClass="javacmdemail.Main" -s "C:\apache-maven-3.3.3\conf\settings.xml"
```

Here _-Dexec.mainClass_ is main class of your java project. Give fully qualified(with package) class name.

After _-s_ give path to maven `settings.xml`.

Executable jar file will be generated in the `target` folder.

Make a json file like the following `javacmdemail.json` (name can be anything).

Can sent email to multiple id. The ids should be separated by comma. 

Can sent email with one attachment.

```shell
{
	"fromUsername": "abc@gmail.com",
	"password": "abc@123",
	"toEmailId": "ratikanta@sdrc.co.in, anirudha@sdrc.co.in",
	"subject": "Test subject",
	"body": "Test body",
    "attachmentPath": "/Users/SDRC-PROD/projects/TED/",
    "attachmentName": "TED-09-jun-2020-1933.backup"
}
```

Run it like the following command to send email with json file as parameter.

```shell
java -jar javacmdemail-1.1.0-jar-with-dependencies.jar "d:/ratikanta/json/java/javacmdemail.json"
```

Here, the parameter is the json file where the input data(from email id, password, to email id etc) is present 

Feel free to raise an issue if you face any problem