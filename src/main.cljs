(ns main
  (:require [reagent.core :as r]
            [data :as data]
            [picker :as p]
            [cljs.core.async :refer (chan put! <! go go-loop timeout)]
            ["@material-ui/core" :refer [Button]]
            ["highcharts" :as Highcharts]
            ["react-highcharts/ReactHighmaps" :as ReactHighmaps]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["highcharts/modules/heatmap" :as addHeatmapModule]
            ["react-highcharts" :as ReactHighcharts]
            ["toastr" :as toastr]
            ["worldwind-react-globe" :as Globe]
            ["react-grid-layout" :as ResponsiveGridLayout]))


;;;;;;;;;;;;;;;;;;;;;;
;
; Some reference material:
;
;  https://www.freecodecamp.org/news/why-clojurescript-works-so-well-with-npm-128221d302ba/
;
;  https://github.com/shadow-cljs/shadow-cljs.github.io
;
;  https://github.com/strml/react-grid-layout
;
;  https://github.com/kirjs/react-highcharts
;      http://kirjs.github.io/react-highcharts/index.html
;      http://kirjs.github.io/react-highcharts/highmaps.html
;      http://kirjs.github.io/react-highcharts/more.html
;
;  https://github.com/whawker/react-jsx-highcharts/releases/tag/v3.6.0
;
;  http://casesandberg.github.io/react-color/
;

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
  ; learned this litte trick from:
  ;   https://github.com/whawker/react-jsx-highcharts/releases/tag/v3.6.0
  (addSankeyModule Highcharts)
  (addDependencyWheelModule Highcharts)
  (addHeatmapModule Highcharts)

  ; would this work?
  (ReactHighmaps ReactHighcharts/Highcharts)

  (mount main-component)
  (print "Hello Main"))
