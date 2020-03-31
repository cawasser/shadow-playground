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
   :series        [{:data       [["eu" (rand-int 101)]
                                 ["oc" (rand-int 101)]
                                 ["af" (rand-int 101)]
                                 ["as" (rand-int 101)]
                                 ["na" (rand-int 101)]
                                 ["sa" (rand-int 101)]]
                    :name       "Tons produced"
                    :states     {:hover {:color "#BADA55"}}
                    :dataLabels {:enabled true
                                 :format  "{point.name}"}}
                   {:type  "mappoint"
                    :name  "Cities"
                    :color "#000000"
                    :data  [{:name "Canberra"
                             :lat  -35.2809
                             :lon  149.13}
                            {:name "Brisbane"
                             :lat  -27.47012
                             :lon  153.021072}
                            {:name "Geraldton"
                             :lat  -28.782387
                             :lon  114.607513}
                            {:name "Wagga Wagga"
                             :lat  -35.117275
                             :lon  147.356522}
                            {:name "Orlando"
                             :lat  28.538336
                             :lon  -81.379234}
                            {:name "San Diego"
                             :lat  32.715736
                             :lon  -117.161087}
                            {:name "Dulles"
                             :lat  38.951666
                             :lon  -77.448055}]}]})


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
   :series        [{:name         "Basemap"
                    :borderColor  "#A0A0A0"
                    :nullColor    "rgba(200 200 200 0.3)"
                    :showInLegend false}
                   {:name                "Separators"
                    :type                "mapline"
                    :nullColor           "#707070"
                    :showInLegend        false
                    :enableMouseTracking false}
                   {:type  "mappoint"
                    :name  "Cities"
                    :color "#000000"
                    :data  [{:name       "Canberra"
                             :lat        -35.2809
                             :lon        149.13
                             :dataLabels {:align "left" :x 5 :verticalAlign "middle"}}
                            {:name "Brisbane"
                             :lat  -27.47012
                             :lon  153.021072}
                            {:name "Geraldton"
                             :lat  -28.782387
                             :lon  114.607513}
                            {:name       "Wagga Wagga"
                             :lat        -35.117275
                             :lon        147.356522
                             :dataLabels {:align "right" :y 5 :verticalAlign "middle"}}]}]})
