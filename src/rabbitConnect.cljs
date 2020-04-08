(ns rabbitConnect
  (:require ["toastr" :as toastr]
            ["rhea" :as rhea]))

(def connectionOptions {:host "127.0.0.1" :port 5672 :username "guest" :password "guest"})

(defn connect-to-broker []
  (toastr/success "Connecting to RabbitMQ!")
  (rhea/connect connectionOptions))




