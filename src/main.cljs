(ns main
  (:require [reagent.core :as r]
            [cljs.core.async :refer (chan put! <! go go-loop timeout)]
            ["@material-ui/core/Button" :refer [Button]]
            ["toastr" :as toastr]
            ["worldwind-react-globe" :as Globe]))



(defn main-component []
  [:div
   [:h1 "This is a component"]
   [:> Button {:on-click #(toastr/success "Toast!")} "Button!"]
   [:> Globe {:layers ["usgs-topo"
                       "coordinates"
                       "view-controls"
                       "compass"]}]])


(defn mount [c]
  (r/render-component [c] (.getElementById js/document "app")))


(defn reload! []
  (mount main-component)
  (print "Hello reload!"))

(defn main! []
  (mount main-component)
  (print "Hello Main"))
