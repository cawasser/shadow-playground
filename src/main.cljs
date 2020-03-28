(ns main
  (:require [reagent.core :as r]
            [data :as data]
            [picker :as p]
            [cljs.core.async :refer (chan put! <! go go-loop timeout)]
            ["@material-ui/core" :refer [Button]]
            ["react-highcharts/ReactHighmaps" :as ReactHighmaps]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["highcharts/modules/heatmap" :as addHeatmapModule]
            ["react-highcharts" :as ReactHighcharts]
            ["toastr" :as toastr]
            ["worldwind-react-globe" :as Globe]
            ["react-grid-layout" :as ResponsiveGridLayout]

            [mapping.highcharts-mapping :as mapping]))

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
       [:> ReactHighcharts {:config data/line-data}]]

      [:div {:key "2" :data-grid {:x 4 :y 0 :w 4 :h 3}}
       [:> ReactHighcharts {:config data/depwheel-data}]]

      [:div {:key "3" :data-grid {:x 0 :y 3 :w 4 :h 3}}
       [:> ReactHighcharts {:config data/sankey-data}]]

      [:div {:key "5" :data-grid {:x 0 :y 3 :w 4 :h 3}}
       [:> ReactHighcharts {:config data/heatmap-data}]]

      [:div {:key "6" :data-grid {:x 6 :y 3 :w 4 :h 3}}
       [:> ReactHighmaps {:config mapping/world-map-data}]]

      [:div {:key "7" :data-grid {:x 6 :y 3 :w 4 :h 3}}
       [:> ReactHighmaps {:config mapping/aus-map-data}]]

      [:div {:key "4" :data-grid {:x 4 :y 3 :w 4 :h 3}}
       [:> Globe {:layers ["usgs-topo"
                           "coordinates"
                           "view-controls"
                           "compass"]
                  :latitude 28.538336
                  :longitude -81.379234
                  :altitude 35000}]]]]))


(defn mount [c]
  (r/render-component [c] (.getElementById js/document "app")))


(defn reload! []
  (mount main-component)
  (print "Hello reload!"))

(defn main! []
  (addSankeyModule ReactHighcharts/Highcharts)
  (addDependencyWheelModule ReactHighcharts/Highcharts)
  (addHeatmapModule ReactHighcharts/Highcharts)

  (mount main-component)
  (print "Hello Main"))
