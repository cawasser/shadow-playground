(ns rabbitConnect
  (:require ["toastr" :as toastr]))

(defn connect-to-broker []
  (toastr/success "Connecting to RabbitMQ!"))


