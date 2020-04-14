(ns rabbitPublish
  (:require ["toastr" :as toastr]
            [rabbitConnect :as rc]))

(defn publish-message []
  (rc/connect-to-broker))


