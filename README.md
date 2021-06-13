Demo application using spring boot which publishes metrics to be used by prometheus.

The `de.mobilcom.prometheus_demo.DemoController` manages a multi dimensional counter.

To run locally:
* start the spring boot app
* start a prometheus server, see `prometheus/README.md`
* increase some counter via  
  http://localhost:8080/increaseCounter/tag1
* display metrics on  
  http://localhost:9090/graph?g0.expr=demo_counter_total&g0.tab=0&g0.stacked=0&g0.range_input=1h