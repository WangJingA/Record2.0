FROM java:8
MAINTAINER DuZhuo
ADD ./DayRecord.jar  dockerdayrecord.jar
CMD java -jar dockerdayrecord.jar
EXPOSE 8089
#将所有的jar包整合为app.jar
COPY *.jar /app.jar
#执行jar包
ENTRYPOINT ["java","-jar","app.jar"]