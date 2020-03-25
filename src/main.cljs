(ns main
  (:require [reagent.core :as r]
            [data :as data]
            [cljs.core.async :refer (chan put! <! go go-loop timeout)]
            ["@material-ui/core" :refer [Button]]
            ["highcharts" :as Highcharts]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["react-highcharts" :as ReactHighcharts]
            ["toastr" :as toastr]
            ["worldwind-react-globe" :as Globe]))



(defn main-component []
  [:div
   [:> Button {:on-click #(toastr/success "Toast!")} "Button!"]

   [:> ReactHighcharts {:config {:title  {:text "Line Chart"}
                                 :chart  {:type "line"}
                                 :series data/line-data}}]

   [:> ReactHighcharts {:config {:title  {:text "Sankey Chart"}
                                 :chart  {:type "sankey"}
                                 :series data/sankey-data-2}}]

   [:> ReactHighcharts {:config {:title  {:text "Dependency Wheel Chart"}
                                 :chart  {:type "dependencywheel"}
                                 :series data/sankey-data-2}}]

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
  (addSankeyModule Highcharts)
  (addDependencyWheelModule Highcharts)
  ;(withHighcharts main-component Highcharts)
  (mount main-component)
  (print "Hello Main"))
