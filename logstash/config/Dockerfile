# Use the official Logstash image as a base
FROM logstash:8.15.2

# Set the working directory
WORKDIR /usr/share/logstash

USER logstash

# Download PostgreSQL JDBC driver
RUN curl -o /usr/share/logstash/vendor/postgres-driver.jar https://jdbc.postgresql.org/download/postgresql-42.7.3.jar

# Copy your custom pipeline and config files into the image
COPY . config/
