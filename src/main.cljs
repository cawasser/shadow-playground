(ns main
  (:require [reagent.core :as r]
            [cljs-time.core :as t]
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
            ["react-gantt-timeline" :default TimeLine]

            [mapping.highcharts-mapping :as mapping]
            [carousel :as carousel]))

;;;;;;;;;;;;;;;;;;;;;;
;
; Some reference material:
;
; Shadow-cljs and using npm:
;  https://www.freecodecamp.org/news/why-clojurescript-works-so-well-with-npm-128221d302ba/
;
;  https://github.com/shadow-cljs/shadow-cljs.github.io
;
; Grid:
;  https://github.com/strml/react-grid-layout
;
; ReactHighcharts:
;  https://github.com/kirjs/react-highcharts
;      http://kirjs.github.io/react-highcharts/index.html
;      http://kirjs.github.io/react-highcharts/highmaps.html
;      http://kirjs.github.io/react-highcharts/more.html
;
; Highmaps:
;  https://www.highcharts.com/docs/maps/map-collection
;  http://kirjs.github.io/react-highcharts/highmaps.html
;
; Accessing extended Highcharts types:
;  https://github.com/whawker/react-jsx-highcharts/releases/tag/v3.6.0
;
; CompactPicker (color picker):
;  http://casesandberg.github.io/react-color/
;
; TimeLine (gantt):
;  https://github.com/guiqui/react-timeline-gantt
;  https://codesandbox.io/s/3x8nl16p65
;
; cljs-time:
;  https://github.com/andrewmcveigh/cljs-time
;  http://www.andrewmcveigh.com/cljs-time/latest/index.html
;
; Carousel
;  https://github.com/express-labs/pure-react-carousel
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

     [:div
      [:> ResponsiveGridLayout
       {:className "layout" :cols 12}

       ;[:div {:key "1" :data-grid {:x 0 :y 0 :w 4 :h 3}}
       ; [:> ReactHighcharts {:config data/line-data}]]
       ;
       ;[:div {:key "2" :data-grid {:x 4 :y 0 :w 4 :h 3}}
       ; [:> ReactHighcharts {:config data/depwheel-data}]]
       ;
       ;[:div {:key "3" :data-grid {:x 0 :y 3 :w 4 :h 3}}
       ; [:> ReactHighcharts {:config data/sankey-data}]]
       ;
       ;[:div {:style {:width "400px" :height "350px"}
       ;       :key "4" :data-grid {:x 4 :y 3 :w 4 :h 3}}
       ; [:> Globe {:layers    ["usgs-topo"
       ;                        "coordinates"
       ;                        "view-controls"
       ;                        "compass"]
       ;            :latitude  28.538336
       ;            :longitude -81.379234
       ;            :altitude  35000}]]
       ;
       ;[:div {:key "5" :data-grid {:x 0 :y 3 :w 4 :h 3}}
       ; [:> ReactHighcharts {:config data/heatmap-data}]]
       ;
       ;[:div {:key "6" :data-grid {:x 6 :y 3 :w 4 :h 3}}
       ; [:> ReactHighmaps {:config mapping/world-map-data}]]
       ;
       ;[:div {:key "7" :data-grid {:x 6 :y 3 :w 4 :h 3}}
       ; [:> ReactHighmaps {:config mapping/aus-map-data}]]
       ;
       [:div {:style {:width "650px" :height "400px"}
              :key "8" :data-grid {:x 6 :y 3 :w 4 :h 3}}
        [:p "Timeline"]
        [:div {:class "time-line-container"
               :style {:width "650px" :height "400px"}}
         [:> TimeLine {:data  [{:id 1 :start (t/now)
                                :end (t/plus (t/now) (t/months 1)) :name "Demo Task 1"}
                               {:id 2 :start (t/plus (t/now) (t/months 1))
                                :end (t/plus (t/now) (t/months 1) (t/weeks 2) (t/days 4) (t/hours 9)) :name "Demo Task 2"}]

                       :links [{:id 1 :start 1 :end 2}
                               {:id 2 :start 1 :end 3}]}]]]

       [:div {:key "9" :data-grid {:x 6 :y 3 :w 4 :h 3}}
        [carousel/carousel [[:> ReactHighcharts {:config data/heatmap-data}]
                            [:> ReactHighmaps {:config mapping/world-map-data}]
                            [:> ReactHighmaps {:config mapping/aus-map-data}]]]]]]]))



(defn mount [c]
  (r/render-component [c] (.getElementById js/document "app")))


(defn reload! []
  (mount main-component)
  (print "repl reload!"))

(defn main! []
  ; learned this little trick from:
  ;   https://github.com/whawker/react-jsx-highcharts/releases/tag/v3.6.0
  (addSankeyModule ReactHighcharts/Highcharts)
  (addDependencyWheelModule ReactHighcharts/Highcharts)
  (addHeatmapModule ReactHighcharts/Highcharts)

  (mount main-component))
