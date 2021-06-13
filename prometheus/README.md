Start the spring boot app.  
Metrics should then be available via  
http://localhost:8080/actuator/prometheus

Increment a counter via  
http://localhost:8080/increaseCounter/bc1

Start the prometheus test docker container with
```
docker run -p 9090:9090 -v `pwd`/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```

`prometheus.yml` must contain the ip of the local host to
get the data from within the docker container.
