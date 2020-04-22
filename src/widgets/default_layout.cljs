(ns widgets.default-layout
  (:require [basic-widget :refer [basic-widget]]
            ["react-highcharts/ReactHighmaps" :as ReactHighmaps]
            ["highcharts-more" :as HighchartsMore]
            ["highcharts/modules/sankey" :as addSankeyModule]
            ["highcharts/modules/dependency-wheel" :as addDependencyWheelModule]
            ["highcharts/modules/heatmap" :as addHeatmapModule]
            ["react-highcharts" :as ReactHighcharts]
            ["react-gantt-timeline" :default TimeLine]
            [data :as data]
            [mapping.highcharts-mapping :as mapping]
            [mapping.worldwind :as ww]))



(def black {:r 0 :g 0 :b 0 :a 1})
(def white {:r 255 :g 255 :b 255 :a 1})
(def blue {:r 0 :g 0 :b 255 :a 1})
(def green {:r 0 :g 255 :b 0 :a 1})
(def lavender {:r 128 :g 0 :b 128 :a 1})
(def blue-gray {:r 0 :g 100 :b 128 :a 1})
(def pale-yellow {:r 128 :g 128 :b 0 :a 1})
(def gray {:r 150 :g 150 :b 150 :a 1})


(def layout [
             [{:x 0 :y 0 :w 4 :h 3}
              "Heatmap" ReactHighcharts data/heatmap-data blue white]

             ;[{:x 4 :y 0 :w 4 :h 3}
             ; "Spectrum (testing)" ReactHighcharts data/line-data green black]
             ;
             ;[{:x 8 :y 0 :w 4 :h 3}
             ; "Dep-wheel" ReactHighcharts data/depwheel-data blue white]
             ;
             ;[{:x 0 :y 3 :w 4 :h 3}
             ; "Sankey" ReactHighcharts data/sankey-data lavender white]
             ;
             [{:x 4 :y 3 :w 4 :h 3}
              "2D World" ReactHighmaps mapping/world-map-data blue-gray white]])

             ;[{:x 8 :y 3 :w 4 :h 3}
             ; "Rose" ReactHighcharts data/rose-data pale-yellow white]
             ;
             ;[{:x 0 :y 6 :w 4 :h 3}
             ; "3D World" ww/globe ww/data pale-yellow white]
             ;
             ;[{:x 4 :y 6 :w 4 :h 3}
             ; "Timeline" TimeLine data/timeline-data gray white]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; CAROUSEL with:
;     Heatmap
;     2D World Map (Highmaps)
;     2D Australia Map (Highmaps)
;
;[:div {:key "9" :data-grid {:x 8 :y 6 :w 4 :h 3}}
; [basic-widget
;  "carousel"
;  [carousel/carousel [[:> ReactHighcharts {:config data/heatmap-data}]
;                      [:> ReactHighmaps {:config mapping/world-map-data}]
;                      [:> ReactHighmaps {:config mapping/aus-map-data}]]]
;  {:viz/title             "Carousel"
;   :viz/banner-color      {:r 255 :g 0 :b 0 :a 1}
;   :viz/banner-text-color white}]]]]]))

;#_[:div {:key "100" :data-grid {:x 6 :y 3 :w 4 :h 3}}
;   [basic-widget "markdown"
;    [md/viewer {:raw-data data/md-data}]
;    {:viz/title "Markdown"
;     :viz/banner-color {:r 128 :g 128 :b 0 :a 1}
;     :viz/banner-text-color white}]



(defn expand-layout [layout]
  (print "map-indexed" (map-indexed vector layout))

  (map (fn [[idx [pos title content data banner-color title-color]]]
         ;(print "widget" pos))
         [:div {:key idx :data-grid pos}
          [basic-widget
           title
           [:> content {:config data}]
           {:viz/title             title
            :viz/banner-color      banner-color
            :viz/banner-text-color title-color}]])
    (map-indexed vector layout)))