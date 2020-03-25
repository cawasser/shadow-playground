(ns main
  (:require [reagent.core :as r]
            [data :as data]
            [picker :as p]
            [cljs.core.async :refer (chan put! <! go go-loop timeout)]
            ["@material-ui/core" :refer [Button]]
            ["highcharts" :as Highcharts]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["react-highcharts" :as ReactHighcharts]
            ["toastr" :as toastr]
            ["worldwind-react-globe" :as Globe]
            ["react-grid-layout" :as ResponsiveGridLayout]))


(def picker? (r/atom false))

(defn main-component []
  (fn []
    [:div
     [:> Button {:variant  "contained"
                 :color    "primary"
                 :on-click #(toastr/success "Toast!")} "Toast!"]
     [:> Button {:variant  "contained"
                 :color    "secondary"
                 :on-click #(swap! picker? not)} "Picker!"]

     [p/picker picker?]

     [:> ResponsiveGridLayout
      {:className "layout" :cols 12}

      [:div {:key "1" :data-grid {:x 0 :y 0 :w 4 :h 3}}
       [:> ReactHighcharts {:config {:title  {:text "Line Chart"}
                                     :chart  {:type "line"}
                                     :series data/line-data}}]]

      [:div {:key "2" :data-grid {:x 4 :y 0 :w 4 :h 3}}
       [:> ReactHighcharts {:config {:title  {:text "Sankey Chart"}
                                     :chart  {:type "sankey"}
                                     :series data/sankey-data-2}}]]

      [:div {:key "3" :data-grid {:x 0 :y 3 :w 4 :h 3}}
       [:> ReactHighcharts {:config {:title  {:text "Dependency Wheel Chart"}
                                     :chart  {:type "dependencywheel"}
                                     :series data/sankey-data}}]]

      [:div {:key "4" :data-grid {:x 4 :y 3 :w 4 :h 3}}
       [:> Globe {:layers ["usgs-topo"
                           "coordinates"
                           "view-controls"
                           "compass"]}]]]]))


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
