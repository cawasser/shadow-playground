(ns mapping.highcharts-mapping
  (:require ["@highcharts/map-collection/custom/world.geo.json" :as world-geo]
            ["@highcharts/map-collection/countries/au/au-all.geo.json" :as aus-geo]))


; trying to follow the react-highcharts example for maps at:
;
; http://kirjs.github.io/react-highcharts/highmaps.html
;
;  all Highmaps "map" are in one npm package:
;
; https://www.highcharts.com/docs/maps/map-collection
;

(def world-map-data
  {:chart         {:map      world-geo
                   :zoomType "xy"}
   :title         {:text "World Map"}
   :legend        {:enabled true}
   :plotOptions   {:dataLabels {:enabled true
                                :color   "white"
                                :style   {:fontWeight "bold"}}}
   :mapNavigation {:enabled       true
                   :buttonOptions {:verticalAlign "bottom"}}
   :series [{}]})


(def aus-map-data
  {:chart         {:map      aus-geo
                   :zoomType "xy"}
   :title         {:text "Australia"}
   :legend        {:enabled true}
   :plotOptions   {:dataLabels {:enabled true
                                :color   "white"
                                :style   {:fontWeight "bold"}}}
   :mapNavigation {:enabled       true
                   :buttonOptions {:verticalAlign "bottom"}}
   :series [{}]})
