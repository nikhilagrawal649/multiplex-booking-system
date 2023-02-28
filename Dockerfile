FROM isahl/openjdk17:amd64
COPY target/Multiplex-Booking-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/Multiplex-Booking-0.0.1-SNAPSHOT.jar"]