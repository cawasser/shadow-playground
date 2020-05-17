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
            [mapping.worldwind :as ww]
            [md-viewer :as md]
            [carousel :as carousel]
            [reagent.core :as r]))



(def black {:r 0 :g 0 :b 0 :a 1})
(def white {:r 255 :g 255 :b 255 :a 1})
(def blue {:r 0 :g 0 :b 255 :a 1})
(def green {:r 0 :g 255 :b 0 :a 1})
(def lavender {:r 128 :g 0 :b 128 :a 1})
(def blue-gray {:r 0 :g 100 :b 128 :a 1})
(def olive {:r 128 :g 128 :b 0 :a 1})
(def gray {:r 150 :g 150 :b 150 :a 1})
(def orange {:r 254 :g 146 :b 0 :a 1})


(defn make-highchart [data]
  (print "make-highcharts" (get-in data [:title :text]))
  [:> ReactHighcharts {:config data}])

(defn make-highmap [data]
  (print "make-highmap")
  [:> ReactHighmaps {:config data}])

(defn make-worldwind [data]
  (print "make-worldwind")
  [ww/globe])

(defn make-timeline [data]
  [:div.time-line-container
   [:> TimeLine (merge {:mode "year"} data/timeline-data)]])

(defn make-carousel [data]
  (print "make-carousel")
  [carousel/carousel
   [[:> ReactHighcharts {:config data/heatmap-data}]
    [:> ReactHighmaps {:config mapping/world-map-data}]
    [:> ReactHighmaps {:config mapping/aus-map-data}]]])

(defn make-markdown [data]
  (print "make-markdown")
  (md/viewer data))


(def layout (r/atom []))


(def widgets-to-add [
                     [{:x 0 :y 0 :w 4 :h 3}
                      "Heatmap" make-highchart data/heatmap-data blue white]

                     ;[{:x 4 :y 0 :w 4 :h 3}
                     ; "Markdown" make-markdown data/md-data green black]
                     ;
                     ;[{:x 4 :y 0 :w 4 :h 3}
                     ; "Spectrum (testing)" make-highchart data/line-data green black]
                     ;
                     [{:x 8 :y 0 :w 4 :h 3}
                      "Dep-wheel" make-highchart data/depwheel-data blue white]

                     [{:x 0 :y 3 :w 4 :h 3}
                      "Sankey" make-highchart data/sankey-data lavender white]

                     [{:x 4 :y 3 :w 4 :h 3}
                      "Timeline" make-timeline data/timeline-data gray white]

                     [{:x 8 :y 3 :w 4 :h 3}
                      "Rose" make-highchart data/rose-data olive white]

                     [{:x 0 :y 6 :w 4 :h 3}
                      "3D World" make-worldwind ww/data olive white]

                     [{:x 4 :y 6 :w 4 :h 3}
                      "Carousel" make-carousel data/timeline-data orange white]

                     [{:x 8 :y 6 :w 4 :h 3}
                      "2D World" make-highmap mapping/world-map-data blue-gray white]])


(defn expand-layout [idx [pos title contentFn data banner-color title-color]]
  ;(print "map-indexed" (map-indexed vector layout))

  ;(print "widget" title data)
  (let [ret [:div {:key idx :data-grid pos}
             ;:style {:width "100%" :height "100%"
             ;        :overflow :hidden}}
             [basic-widget
              title
              (contentFn data)
              {:viz/title             title
               :viz/banner-color      banner-color
               :viz/banner-text-color title-color}]]]
    ;(print ret)
    ret))




(defn add-widget []
  (let [n (count @layout)]
    (print "adding widget" n)

    (if (< n (count widgets-to-add))
      (swap! layout conj (expand-layout n (nth widgets-to-add n))))))

(defn remove-widget []
  (print "adding widget" (count @layout))

  (if (< 0 (count @layout))
    (swap! layout drop-last)))



(comment
  (count [[] []])

  (first widgets-to-add)

  (nth widgets-to-add 0)

  (count widgets-to-add)
  (count @layout)


  (:title data/heatmap-data)

  ())






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



