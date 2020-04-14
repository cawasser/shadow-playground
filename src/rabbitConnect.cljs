(ns rabbitConnect
  (:require ["toastr" :as toastr]
            ["rhea" :as rhea]))

(def connectionOptions {:host "127.0.0.1" :port 5672 :username "guest" :password "guest" :transport "tcp"})

(defn connect-to-broker []

  (try
    (rhea/connect (clj->js connectionOptions))
    (toastr/success "success")
    true

    (catch js/Error e
      (toastr/error e)
      false)))


