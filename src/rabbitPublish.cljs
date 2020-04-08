(ns rabbitPublish
  (:require ["toastr" :as toastr]
            [rabbitConnect :as rc]))

(defn publish-message []
  (toastr/success "Publishing to RabbitMQ!")
  (rc/connect-to-broker))


