(ns data
  (:require [cljs-time.core :as t]))


(def line-data
  {:title  {:text "Line Chart"}
   :chart  {:type :line}
   :series [{:name "trace 1"
             :data [5, 25, 50, 120, 150, 200, 426, 660, 869, 1060,
                    1605, 2471, 3322, 4238, 5221, 6129, 7089, 8339, 9399, 10538,
                    11643, 13092, 14478, 15915, 17385, 19055, 21205, 23044, 25393, 27935,
                    30062, 32049, 33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000,
                    37000, 35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
                    21000, 20000, 19000, 18000, 18000, 17000, 16000, 15537, 14162, 12787,
                    12600, 11400, 5500, 4512, 4502, 4502, 4500, 4500]}
            {:name "trace 2"
             :data [6, 11, 32, 110, 235,
                    369, 640, 1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468,
                    20434, 24126, 27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342,
                    26662, 26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
                    24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586, 22380,
                    21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950, 10871, 10824,
                    10577, 10527, 10475, 10421, 10358, 10295, 10104, 9914, 9620, 9326,
                    5113, 5113, 4954, 4804, 4761, 4717, 4368, 4018]}]})


(def depwheel-data
  {:title  {:text "Dependency Wheel Chart"}
   :chart  {:type "dependencywheel"}
   :series [{:keys ["from" "to" "weight"]
             :data [["Oil" "Transportation" 94]
                    ["Natural Gas" "Transportation" 3]
                    ["Coal" "Transportation" 0]
                    ["Renewable" "Transportation" 0]
                    ["Nuclear" "Transportation" 3]
                    ["Oil" "Industrial" 41]
                    ["Natural Gas" "Industrial" 40]
                    ["Coal" "Industrial" 7]
                    ["Renewable" "Industrial" 11]
                    ["Nuclear" "Industrial" 0]
                    ["Oil" "Residential & Commercial" 17]
                    ["Natural Gas" "Residential & Commercial" 76]
                    ["Coal" "Residential & Commercial" 1]
                    ["Renewable" "Residential & Commercial" 7]
                    ["Nuclear" "Residential & Commercial" 0]
                    ["Oil" "Electric Power" 1]
                    ["Natural Gas" "Electric Power" 18]
                    ["Coal" "Electric Power" 48]
                    ["Renewable" "Electric Power" 11]
                    ["Nuclear" "Electric Power" 22]]}]})


(def sankey-data
  {:title  {:text "Sankey Chart"}
   :chart  {:type "sankey"}
   :series [{:keys ["from" "to" "weight"]
             :data [["Brazil" "Portugal" 5]
                    ["Brazil" "France" 1]
                    ["Brazil" "Spain" 1]
                    ["Brazil" "England" 1]
                    ["Canada" "Portugal" 1]
                    ["Canada" "France" 5]
                    ["Canada" "England" 1]
                    ["Mexico" "Portugal" 1]
                    ["Mexico" "France" 1]
                    ["Mexico" "Spain" 5]
                    ["Mexico" "England" 1]
                    ["USA" "Portugal" 1]
                    ["USA" "France" 1]
                    ["USA" "Spain" 1]
                    ["USA" "England" 5]
                    ["Portugal" "Angola" 2]
                    ["Portugal" "Senegal" 1]
                    ["Portugal" "Morocco" 1]
                    ["Portugal" "South Africa" 3]
                    ["France" "Angola" 1]
                    ["France" "Senegal" 3]
                    ["France" "Mali" 3]
                    ["France" "Morocco" 3]
                    ["France" "South Africa" 1]
                    ["Spain" "Senegal" 1]
                    ["Spain" "Morocco" 3]
                    ["Spain" "South Africa" 1]
                    ["England" "Angola" 1]
                    ["England" "Senegal" 1]
                    ["England" "Morocco" 2]
                    ["England" "South Africa" 7]
                    ["South Africa" "China" 5]
                    ["South Africa" "India" 1]
                    ["South Africa" "Japan" 3]
                    ["Angola" "China" 5]
                    ["Angola" "India" 1]
                    ["Angola" "Japan" 3]
                    ["Senegal" "China" 5]
                    ["Senegal" "India" 1]
                    ["Senegal" "Japan" 3]
                    ["Mali" "China" 5]
                    ["Mali" "India" 1]
                    ["Mali" "Japan" 3]
                    ["Morocco" "China" 5]
                    ["Morocco" "India" 1]
                    ["Morocco" "Japan" 3]]}]})


(defn heatmap-data* []
  [{:name "Fruit Production per Continent"
    :keys ["x" "y" "value"]
    :data [[0, 0, 10], [0, 1, 19], [0, 2, 8],
           [0, 3, 24], [0, 4, 67], [1, 0, 92],
           [1, 1, 58], [1, 2, 78], [1, 3, 117],
           [1, 4, 48], [2, 0, 35], [2, 1, 15],
           [2, 2, 123], [2, 3, 64], [2, 4, 52],
           [3, 0, 72], [3, 1, 132], [3, 2, 114],
           [3, 3, 19], [3, 4, 16], [4, 0, 38],
           [4, 1, 5], [4, 2, 8], [4, 3, 117],
           [4, 4, 115], [5, 0, 88], [5, 1, 32],
           [5, 2, 12], [5, 3, 6], [5, 4, 120],
           [6, 0, 13], [6, 1, 44], [6, 2, 88],
           [6, 3, 98], [6, 4, 96], [7, 0, 31],
           [7, 1, 1], [7, 2, 82], [7, 3, 32],
           [7, 4, 30], [8, 0, 85], [8, 1, 97],
           [8, 2, 123], [8, 3, 64], [8, 4, 84],
           [9, 0, 47], [9, 1, 114], [9, 2, 31],
           [9, 3, 48], [9, 4, 91]]}])

(def heatmap-data
  {:title       {:text "Heatmap Chart"}
   :chart       {:type            "heatmap"
                 :zoomType        "xy"
                 :marginTop       40
                 :marginBottom    80
                 :plotBorderWidth 1}
   :xAxis       {:categories ["Apples" "Avocados" "Bananas" "Oranges" "Peaches" "Pears" "Plums" "Prunes" "Starfruit" "Tangerine"]}
   :yAxis       {:categories ["North America" "South America" "Africa" "Europe" "Asia" "Australia" "Antarctica"]
                 :title      ""
                 :reversed   true}
   :colorAxis   {:min      0
                 :minColor "#FFFFFF"
                 :maxColor "#006400"}                       ;Highcharts.getOptions().colors[0]}
   :legend      {:align         "right"
                 :layout        "vertical"
                 :margin        0
                 :verticalAlign "top"
                 :y             25
                 :symbolHeight  280}
   :plotOptions {:series {:dataLabels {:enabled true :color "#000000"}}}
   :series      (heatmap-data*)})



(defn- rose-data* [name xs max-qty]
  {:name name
   :data (into []
           (for [y (range (count xs))]
             [(get xs y) (rand-int max-qty)]))})


(def hours ["0000h" "0100h" "0200h" "0300h" "0400h" "0600h"
            "0700h" "0800h" "0900h" "1000h" "1100h"])


(def rose-data
  {:title       "12-hour Usage Data"
   :chart       {:type     "column"
                 :polar    true
                 :zoomType "x"}
   :pane        {:size "85%"}
   :xAxis       {:categories        hours
                 :tickmarkPlacement "on"
                 :title             {:text "x-axis" :allowDecimals false}}
   :yAxis       {:title          {:text "y-axis" :allowDecimals false}
                 :endOnTick      false
                 :showLastLabel  true
                 :reversedStacks false}
   :legend      {:align         "right"
                 :verticalAlign "top"
                 :layout        "vertical"}
   :plotOptions {:series {:stacking       :normal
                          :groupPadding   0
                          :pointPlacement "on"}
                 :column {:dataLabels   {:enabled false :format ""}
                          :pointPadding 0.2}}
   :series      [(rose-data* "Apple" hours 200)
                 (rose-data* "Pears" hours 200)
                 (rose-data* "Grapes" hours 200)
                 (rose-data* "Oranges" hours 200)
                 (rose-data* "Bananas" hours 200)]})


(def timeline-data {:data  [{:id  1 :start (t/now)
                             :end (t/plus (t/now) (t/months 1)) :name "Demo Task 1"}
                            {:id  2 :start (t/plus (t/now) (t/months 1))
                             :end (t/plus (t/now) (t/months 1) (t/weeks 2) (t/days 4) (t/hours 9)) :name "Demo Task 2"}]

                    :links [{:id 1 :start 1 :end 2}
                            {:id 2 :start 1 :end 3}]})


(def md-data
  "# Live demo
Changes are automatically rendered as you type.

## Table of Contents

* Implements [GitHub Flavored Markdown](https://github.github.com/gfm/)
* Renders actual, \"native\" React DOM elements
* Allows you to escape or skip HTML (try toggling the checkboxes above)
* If you escape or skip the HTML, no `dangerouslySetInnerHTML` is used! Yay!

## HTML block below
<blockquote>
   This blockquote will change based on the HTML settings above.
</blockquote>")