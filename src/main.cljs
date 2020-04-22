(ns main
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]
            [picker :as p]
            ["@material-ui/core" :refer [Button]]
            ["react-highcharts/ReactHighmaps" :as ReactHighmaps]
            ["highcharts-more" :as HighchartsMore]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["highcharts/modules/heatmap" :as addHeatmapModule]
            ["react-highcharts" :as ReactHighcharts]
            ["toastr" :as toastr]
            ["react-grid-layout" :refer [Responsive WidthProvider]]
            [widgets.default-layout :as layout]

            ["react-gantt-timeline" :default TimeLine]
            [cljs-time.core :as t]
            [basic-widget :refer [basic-widget]]))

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
; Highcharts using NPM
;  https://www.highcharts.com/docs/getting-started/install-from-npm
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
;
; WorldWind
;  https://github.com/worldwindearth/worldwind-react-globe
;  https://worldwind.earth/
;

;(def black {:r 0 :g 0 :b 0 :a 1})
;(def white {:r 255 :g 255 :b 255 :a 1})


(def picker? (r/atom false))

(defn main-component []
  ;(print "main-component")
  ;(print "layout" layout/layout)
  ;(print "expanded layout" (layout/expand-layout layout/layout))
  (fn []
    [:div
     [:h1.title "Shadow-Playground"]
     [:> Button {:variant  "contained"
                 :color    "primary"
                 :on-click #(toastr/success "Toast!")} "Toast!"]
     [:> Button {:variant  "contained"
                 :color    "secondary"
                 :on-click #(swap! picker? not)} "Picker!"]

     [p/picker picker?]

     [:div
      [:> (WidthProvider Responsive)
       {:className   "layout"
        :breakpoints {:lg 1200, :md 996, :sm 768, :xs 480, :xxs 0}
        :cols        {:lg 12, :md 10, :sm 6, :xs 4, :xxs 2}}

       (layout/expand-layout layout/layout)]]]))

       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
       ;
       ; stand-alone GANTT CHART / TIMELINE
       ;
       ;[:div {:key "8" :data-grid {:x 0 :y 0 :w 4 :h 3}}
       ; [basic-widget
       ;  "timeline"
       ;  [:> TimeLine (merge {:mode "year"}
       ;                 data/timeline-data)]
       ;  {:viz/title             "Timeline"
       ;   :viz/banner-color      {:r 150 :g 150 :b 150 :a 1}
       ;   :viz/banner-text-color {:r 255 :g 255 :b 255 :a 1}}]]]]]))




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

  ; http://kirjs.github.io/react-highcharts/more.html
  (HighchartsMore ReactHighcharts/Highcharts)

  (mount main-component))
