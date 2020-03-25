(ns picker
  (:require ["react-color" :refer [CompactPicker]]))


(defn picker [picker?]
  (if @picker?
    [:> CompactPicker
     {:style            {:top "5px" :left "10px"}
      :color            "green"
      :onChangeComplete #(swap! picker? not)}]
    [:div]))
