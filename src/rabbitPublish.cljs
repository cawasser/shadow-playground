(ns rabbitPublish
  (:require ["toastr" :as toastr]))

(defn publish-message []
  (toastr/success "Publishing to RabbitMQ!"))


