(ns rabbitConnect
  (:require ["toastr" :as toastr]
            ["rhea" :as rhea]))

(def connectionOptions {:host "127.0.0.1" :port 5672 :username "guest" :password "guest" :transport "tcp"})
(def conn (rhea/create_connection (clj->js connectionOptions)))

(defn connect-to-broker []

  (try
    (rhea/on (clj->js "sendable") (fn [context] (toastr/success "sendable")))
    (toastr/success "rhea on worked!")
    (.connect conn)
    ;(rhea/create_connection (clj->js connectionOptions))
    (toastr/success "success")
    true

    (catch js/Error e
      (toastr/error e)
      false)))


